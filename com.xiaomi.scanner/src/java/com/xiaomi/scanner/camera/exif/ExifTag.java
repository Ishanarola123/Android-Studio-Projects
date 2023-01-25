/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.text.SimpleDateFormat
 *  java.util.Arrays
 *  java.util.Date
 */
package com.xiaomi.scanner.camera.exif;

import com.xiaomi.scanner.camera.exif.Rational;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ExifTag {
    private static final long LONG_MAX = Integer.MAX_VALUE;
    private static final long LONG_MIN = Integer.MIN_VALUE;
    static final int SIZE_UNDEFINED = 0;
    private static final SimpleDateFormat TIME_FORMAT;
    public static final short TYPE_ASCII = 2;
    public static final short TYPE_LONG = 9;
    public static final short TYPE_RATIONAL = 10;
    private static final int[] TYPE_TO_SIZE_MAP;
    public static final short TYPE_UNDEFINED = 7;
    public static final short TYPE_UNSIGNED_BYTE = 1;
    public static final short TYPE_UNSIGNED_LONG = 4;
    public static final short TYPE_UNSIGNED_RATIONAL = 5;
    public static final short TYPE_UNSIGNED_SHORT = 3;
    private static final long UNSIGNED_LONG_MAX = 0xFFFFFFFFL;
    private static final int UNSIGNED_SHORT_MAX = 65535;
    private static Charset US_ASCII;
    private int mComponentCountActual;
    private final short mDataType;
    private boolean mHasDefinedDefaultComponentCount;
    private int mIfd;
    private int mOffset;
    private final short mTagId;
    private Object mValue;

    static {
        US_ASCII = Charset.forName((String)"US-ASCII");
        int[] arrn = TYPE_TO_SIZE_MAP = new int[11];
        arrn[1] = 1;
        arrn[2] = 1;
        arrn[3] = 2;
        arrn[4] = 4;
        arrn[5] = 8;
        arrn[7] = 1;
        arrn[9] = 4;
        arrn[10] = 8;
        TIME_FORMAT = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    }

    ExifTag(short s2, short s3, int n2, int n3, boolean bl) {
        this.mTagId = s2;
        this.mDataType = s3;
        this.mComponentCountActual = n2;
        this.mHasDefinedDefaultComponentCount = bl;
        this.mIfd = n3;
        this.mValue = null;
    }

    private boolean checkBadComponentCount(int n2) {
        return this.mHasDefinedDefaultComponentCount && this.mComponentCountActual != n2;
    }

    private boolean checkOverflowForRational(Rational[] arrrational) {
        for (Rational rational : arrrational) {
            if (rational.getNumerator() >= Integer.MIN_VALUE && rational.getDenominator() >= Integer.MIN_VALUE && rational.getNumerator() <= Integer.MAX_VALUE && rational.getDenominator() <= Integer.MAX_VALUE) {
                continue;
            }
            return true;
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(int[] arrn) {
        int n2 = arrn.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] >= 0) continue;
            return true;
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(long[] arrl) {
        for (long l2 : arrl) {
            if (l2 >= 0L && l2 <= 0xFFFFFFFFL) {
                continue;
            }
            return true;
        }
        return false;
    }

    private boolean checkOverflowForUnsignedRational(Rational[] arrrational) {
        for (Rational rational : arrrational) {
            if (rational.getNumerator() >= 0L && rational.getDenominator() >= 0L && rational.getNumerator() <= 0xFFFFFFFFL && rational.getDenominator() <= 0xFFFFFFFFL) {
                continue;
            }
            return true;
        }
        return false;
    }

    private boolean checkOverflowForUnsignedShort(int[] arrn) {
        for (int n2 : arrn) {
            if (n2 <= 65535 && n2 >= 0) {
                continue;
            }
            return true;
        }
        return false;
    }

    private static String convertTypeToString(short s2) {
        switch (s2) {
            default: {
                return "";
            }
            case 10: {
                return "RATIONAL";
            }
            case 9: {
                return "LONG";
            }
            case 7: {
                return "UNDEFINED";
            }
            case 5: {
                return "UNSIGNED_RATIONAL";
            }
            case 4: {
                return "UNSIGNED_LONG";
            }
            case 3: {
                return "UNSIGNED_SHORT";
            }
            case 2: {
                return "ASCII";
            }
            case 1: 
        }
        return "UNSIGNED_BYTE";
    }

    public static int getElementSize(short s2) {
        return TYPE_TO_SIZE_MAP[s2];
    }

    public static boolean isValidIfd(int n2) {
        int n3 = 1;
        if (n2 != 0 && n2 != n3 && n2 != 2 && n2 != 3) {
            if (n2 == 4) {
                return n3;
            }
            n3 = 0;
        }
        return n3;
    }

    public static boolean isValidType(short s2) {
        short s3 = 1;
        if (s2 != s3 && s2 != 2 && s2 != 3 && s2 != 4 && s2 != 5 && s2 != 7 && s2 != 9) {
            if (s2 == 10) {
                return s3;
            }
            s3 = 0;
        }
        return s3;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl = object instanceof ExifTag;
        boolean bl2 = false;
        if (bl) {
            ExifTag exifTag = (ExifTag)object;
            short s2 = exifTag.mTagId;
            short s3 = this.mTagId;
            bl2 = false;
            if (s2 == s3) {
                int n2 = exifTag.mComponentCountActual;
                int n3 = this.mComponentCountActual;
                bl2 = false;
                if (n2 == n3) {
                    if (exifTag.mDataType != this.mDataType) {
                        return false;
                    }
                    Object object2 = this.mValue;
                    if (object2 != null) {
                        Object object3 = exifTag.mValue;
                        if (object3 == null) {
                            return false;
                        }
                        if (object2 instanceof long[]) {
                            if (!(object3 instanceof long[])) {
                                return false;
                            }
                            return Arrays.equals((long[])((long[])object2), (long[])((long[])object3));
                        }
                        if (object2 instanceof Rational[]) {
                            if (!(object3 instanceof Rational[])) {
                                return false;
                            }
                            return Arrays.equals((Object[])((Rational[])object2), (Object[])((Rational[])object3));
                        }
                        if (object2 instanceof byte[]) {
                            if (!(object3 instanceof byte[])) {
                                return false;
                            }
                            return Arrays.equals((byte[])((byte[])object2), (byte[])((byte[])object3));
                        }
                        return object2.equals(object3);
                    }
                    Object object4 = exifTag.mValue;
                    bl2 = false;
                    if (object4 == null) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public long forceGetValueAsLong(long l2) {
        long[] arrl = this.getValueAsLongs();
        if (arrl != null && arrl.length >= 1) {
            return arrl[0];
        }
        byte[] arrby = this.getValueAsBytes();
        if (arrby != null && arrby.length >= 1) {
            return arrby[0];
        }
        Rational[] arrrational = this.getValueAsRationals();
        if (arrrational != null && arrrational.length >= 1 && arrrational[0].getDenominator() != 0L) {
            l2 = (long)arrrational[0].toDouble();
        }
        return l2;
    }

    public String forceGetValueAsString() {
        Object object = this.mValue;
        if (object == null) {
            return "";
        }
        if (object instanceof byte[]) {
            if (this.mDataType == 2) {
                return new String((byte[])object, US_ASCII);
            }
            return Arrays.toString((byte[])((byte[])object));
        }
        if (object instanceof long[]) {
            if (((long[])object).length == 1) {
                return String.valueOf((long)((long[])object)[0]);
            }
            return Arrays.toString((long[])((long[])object));
        }
        if (object instanceof Object[]) {
            if (((Object[])object).length == 1) {
                Object object2 = ((Object[])object)[0];
                if (object2 == null) {
                    return "";
                }
                return object2.toString();
            }
            return Arrays.toString((Object[])((Object[])object));
        }
        return object.toString();
    }

    protected void forceSetComponentCount(int n2) {
        this.mComponentCountActual = n2;
    }

    protected void getBytes(byte[] arrby) {
        this.getBytes(arrby, 0, arrby.length);
    }

    protected void getBytes(byte[] arrby, int n2, int n3) {
        short s2 = this.mDataType;
        if (s2 != 7 && s2 != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot get BYTE value from ");
            stringBuilder.append(ExifTag.convertTypeToString(this.mDataType));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Object object = this.mValue;
        int n4 = this.mComponentCountActual;
        if (n3 > n4) {
            n3 = n4;
        }
        System.arraycopy((Object)object, (int)0, (Object)arrby, (int)n2, (int)n3);
    }

    public int getComponentCount() {
        return this.mComponentCountActual;
    }

    public int getDataSize() {
        return this.getComponentCount() * ExifTag.getElementSize(this.getDataType());
    }

    public short getDataType() {
        return this.mDataType;
    }

    public int getIfd() {
        return this.mIfd;
    }

    protected int getOffset() {
        return this.mOffset;
    }

    protected Rational getRational(int n2) {
        short s2 = this.mDataType;
        if (s2 != 10 && s2 != 5) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot get RATIONAL value from ");
            stringBuilder.append(ExifTag.convertTypeToString(this.mDataType));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return ((Rational[])this.mValue)[n2];
    }

    protected String getString() {
        if (this.mDataType == 2) {
            return new String((byte[])this.mValue, US_ASCII);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot get ASCII value from ");
        stringBuilder.append(ExifTag.convertTypeToString(this.mDataType));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    protected byte[] getStringByte() {
        return (byte[])this.mValue;
    }

    public short getTagId() {
        return this.mTagId;
    }

    public Object getValue() {
        return this.mValue;
    }

    public byte getValueAsByte(byte by) {
        byte[] arrby = this.getValueAsBytes();
        if (arrby != null) {
            if (arrby.length < 1) {
                return by;
            }
            by = arrby[0];
        }
        return by;
    }

    public byte[] getValueAsBytes() {
        Object object = this.mValue;
        if (object instanceof byte[]) {
            return (byte[])object;
        }
        return null;
    }

    public int getValueAsInt(int n2) {
        int[] arrn = this.getValueAsInts();
        if (arrn != null) {
            if (arrn.length < 1) {
                return n2;
            }
            n2 = arrn[0];
        }
        return n2;
    }

    public int[] getValueAsInts() {
        Object object = this.mValue;
        if (object == null) {
            return null;
        }
        boolean bl = object instanceof long[];
        int[] arrn = null;
        if (bl) {
            long[] arrl = (long[])object;
            arrn = new int[arrl.length];
            for (int i2 = 0; i2 < arrl.length; ++i2) {
                arrn[i2] = (int)arrl[i2];
            }
        }
        return arrn;
    }

    public long getValueAsLong(long l2) {
        long[] arrl = this.getValueAsLongs();
        if (arrl != null) {
            if (arrl.length < 1) {
                return l2;
            }
            l2 = arrl[0];
        }
        return l2;
    }

    public long[] getValueAsLongs() {
        Object object = this.mValue;
        if (object instanceof long[]) {
            return (long[])object;
        }
        return null;
    }

    public Rational getValueAsRational(long l2) {
        return this.getValueAsRational(new Rational(l2, 1L));
    }

    public Rational getValueAsRational(Rational rational) {
        Rational[] arrrational = this.getValueAsRationals();
        if (arrrational != null) {
            if (arrrational.length < 1) {
                return rational;
            }
            rational = arrrational[0];
        }
        return rational;
    }

    public Rational[] getValueAsRationals() {
        Object object = this.mValue;
        if (object instanceof Rational[]) {
            return (Rational[])object;
        }
        return null;
    }

    public String getValueAsString() {
        Object object = this.mValue;
        if (object == null) {
            return null;
        }
        if (object instanceof String) {
            return (String)object;
        }
        boolean bl = object instanceof byte[];
        String string2 = null;
        if (bl) {
            string2 = new String((byte[])object, US_ASCII);
        }
        return string2;
    }

    public String getValueAsString(String string2) {
        String string3 = this.getValueAsString();
        if (string3 == null) {
            return string2;
        }
        return string3;
    }

    protected long getValueAt(int n2) {
        Object object = this.mValue;
        if (object instanceof long[]) {
            return ((long[])object)[n2];
        }
        if (object instanceof byte[]) {
            return ((byte[])object)[n2];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot get integer value from ");
        stringBuilder.append(ExifTag.convertTypeToString(this.mDataType));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    protected boolean hasDefinedCount() {
        return this.mHasDefinedDefaultComponentCount;
    }

    public boolean hasValue() {
        return this.mValue != null;
    }

    protected void setHasDefinedCount(boolean bl) {
        this.mHasDefinedDefaultComponentCount = bl;
    }

    protected void setIfd(int n2) {
        this.mIfd = n2;
    }

    protected void setOffset(int n2) {
        this.mOffset = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean setTimeValue(long l2) {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat = TIME_FORMAT;
        synchronized (simpleDateFormat2) {
            return this.setValue(TIME_FORMAT.format(new Date(l2)));
        }
    }

    public boolean setValue(byte by) {
        return this.setValue(new byte[]{by});
    }

    public boolean setValue(int n2) {
        return this.setValue(new int[]{n2});
    }

    public boolean setValue(long l2) {
        return this.setValue(new long[]{l2});
    }

    public boolean setValue(Rational rational) {
        return this.setValue(new Rational[]{rational});
    }

    public boolean setValue(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof Short) {
            return this.setValue(65535 & (Short)object);
        }
        if (object instanceof String) {
            return this.setValue((String)object);
        }
        if (object instanceof int[]) {
            return this.setValue((int[])object);
        }
        if (object instanceof long[]) {
            return this.setValue((long[])object);
        }
        if (object instanceof Rational) {
            return this.setValue((Rational)object);
        }
        if (object instanceof Rational[]) {
            return this.setValue((Rational[])object);
        }
        if (object instanceof byte[]) {
            return this.setValue((byte[])object);
        }
        if (object instanceof Integer) {
            return this.setValue((Integer)object);
        }
        if (object instanceof Long) {
            return this.setValue((Long)object);
        }
        if (object instanceof Byte) {
            return this.setValue((Byte)object);
        }
        if (object instanceof Short[]) {
            Short[] arrshort = (Short[])object;
            int[] arrn = new int[arrshort.length];
            for (int i2 = 0; i2 < arrshort.length; ++i2) {
                int n2 = arrshort[i2] == null ? 0 : 65535 & arrshort[i2];
                arrn[i2] = n2;
            }
            return this.setValue(arrn);
        }
        if (object instanceof Integer[]) {
            Integer[] arrinteger = (Integer[])object;
            int[] arrn = new int[arrinteger.length];
            for (int i3 = 0; i3 < arrinteger.length; ++i3) {
                int n3 = arrinteger[i3] == null ? 0 : arrinteger[i3];
                arrn[i3] = n3;
            }
            return this.setValue(arrn);
        }
        if (object instanceof Long[]) {
            Long[] arrlong = (Long[])object;
            long[] arrl = new long[arrlong.length];
            for (int i4 = 0; i4 < arrlong.length; ++i4) {
                long l2 = arrlong[i4] == null ? 0L : arrlong[i4];
                arrl[i4] = l2;
            }
            return this.setValue(arrl);
        }
        if (object instanceof Byte[]) {
            Byte[] arrbyte = (Byte[])object;
            byte[] arrby = new byte[arrbyte.length];
            for (int i5 = 0; i5 < arrbyte.length; ++i5) {
                byte by = arrbyte[i5] == null ? (byte)0 : arrbyte[i5];
                arrby[i5] = by;
            }
            return this.setValue(arrby);
        }
        return false;
    }

    public boolean setValue(String string2) {
        int n2;
        short s2 = this.mDataType;
        if (s2 != 2 && s2 != 7) {
            return false;
        }
        byte[] arrby = string2.getBytes(US_ASCII);
        if (arrby.length > 0) {
            if (arrby[arrby.length - 1] != 0 && this.mDataType != 7) {
                arrby = Arrays.copyOf((byte[])arrby, (int)(1 + arrby.length));
            }
        } else if (this.mDataType == 2 && this.mComponentCountActual == 1) {
            arrby = new byte[]{0};
        }
        if (this.checkBadComponentCount(n2 = arrby.length)) {
            return false;
        }
        this.mComponentCountActual = n2;
        this.mValue = arrby;
        return true;
    }

    public boolean setValue(byte[] arrby) {
        return this.setValue(arrby, 0, arrby.length);
    }

    public boolean setValue(byte[] arrby, int n2, int n3) {
        if (this.checkBadComponentCount(n3)) {
            return false;
        }
        short s2 = this.mDataType;
        if (s2 != 1 && s2 != 7) {
            return false;
        }
        this.mValue = new byte[n3];
        System.arraycopy((Object)arrby, (int)n2, (Object)this.mValue, (int)0, (int)n3);
        this.mComponentCountActual = n3;
        return true;
    }

    public boolean setValue(int[] arrn) {
        boolean bl = this.checkBadComponentCount(arrn.length);
        if (bl) {
            return false;
        }
        short s2 = this.mDataType;
        if (s2 != 3 && s2 != 9 && s2 != 4) {
            return false;
        }
        if (this.mDataType == 3 && this.checkOverflowForUnsignedShort(arrn)) {
            return false;
        }
        if (this.mDataType == 4 && this.checkOverflowForUnsignedLong(arrn)) {
            return false;
        }
        long[] arrl = new long[arrn.length];
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            arrl[i2] = arrn[i2];
        }
        this.mValue = arrl;
        this.mComponentCountActual = arrn.length;
        return true;
    }

    public boolean setValue(long[] arrl) {
        if (!this.checkBadComponentCount(arrl.length)) {
            if (this.mDataType != 4) {
                return false;
            }
            if (this.checkOverflowForUnsignedLong(arrl)) {
                return false;
            }
            this.mValue = arrl;
            this.mComponentCountActual = arrl.length;
            return true;
        }
        return false;
    }

    public boolean setValue(Rational[] arrrational) {
        if (this.checkBadComponentCount(arrrational.length)) {
            return false;
        }
        short s2 = this.mDataType;
        if (s2 != 5 && s2 != 10) {
            return false;
        }
        if (this.mDataType == 5 && this.checkOverflowForUnsignedRational(arrrational)) {
            return false;
        }
        if (this.mDataType == 10 && this.checkOverflowForRational(arrrational)) {
            return false;
        }
        this.mValue = arrrational;
        this.mComponentCountActual = arrrational.length;
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] arrobject = new Object[]{this.mTagId};
        stringBuilder.append(String.format((String)"tag id: %04X\n", (Object[])arrobject));
        stringBuilder.append("ifd id: ");
        stringBuilder.append(this.mIfd);
        stringBuilder.append("\ntype: ");
        stringBuilder.append(ExifTag.convertTypeToString(this.mDataType));
        stringBuilder.append("\ncount: ");
        stringBuilder.append(this.mComponentCountActual);
        stringBuilder.append("\noffset: ");
        stringBuilder.append(this.mOffset);
        stringBuilder.append("\nvalue: ");
        stringBuilder.append(this.forceGetValueAsString());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}

