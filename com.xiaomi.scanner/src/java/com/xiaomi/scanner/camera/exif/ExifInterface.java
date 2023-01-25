/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.util.SparseIntArray
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Byte
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.text.DateFormat
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.TimeZone
 */
package com.xiaomi.scanner.camera.exif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseIntArray;
import com.xiaomi.scanner.camera.exif.ExifData;
import com.xiaomi.scanner.camera.exif.ExifInvalidFormatException;
import com.xiaomi.scanner.camera.exif.ExifModifier;
import com.xiaomi.scanner.camera.exif.ExifOutputStream;
import com.xiaomi.scanner.camera.exif.ExifReader;
import com.xiaomi.scanner.camera.exif.ExifTag;
import com.xiaomi.scanner.camera.exif.IfdData;
import com.xiaomi.scanner.camera.exif.Rational;
import com.xiaomi.scanner.debug.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class ExifInterface {
    private static final String DATETIME_FORMAT_STR = "yyyy:MM:dd kk:mm:ss";
    public static final ByteOrder DEFAULT_BYTE_ORDER;
    public static final int DEFINITION_NULL = 0;
    public static final String EXIF_VERSION = "0220";
    private static final String GPS_DATE_FORMAT_STR = "yyyy:MM:dd";
    public static final int IFD_NULL = -1;
    private static final String NULL_ARGUMENT_STRING = "Argument is null";
    private static final Log.Tag TAG;
    public static final int TAG_APERTURE_VALUE = 0;
    public static final int TAG_ARTIST = 0;
    public static final int TAG_BITS_PER_SAMPLE = 0;
    public static final int TAG_BRIGHTNESS_VALUE = 0;
    public static final int TAG_CFA_PATTERN = 0;
    public static final int TAG_COLOR_SPACE = 0;
    public static final int TAG_COMPONENTS_CONFIGURATION = 0;
    public static final int TAG_COMPRESSED_BITS_PER_PIXEL = 0;
    public static final int TAG_COMPRESSION = 0;
    public static final int TAG_CONTRAST = 0;
    public static final int TAG_COPYRIGHT = 0;
    public static final int TAG_CUSTOM_RENDERED = 0;
    public static final int TAG_DATE_TIME = 0;
    public static final int TAG_DATE_TIME_DIGITIZED = 0;
    public static final int TAG_DATE_TIME_ORIGINAL = 0;
    public static final int TAG_DEVICE_SETTING_DESCRIPTION = 0;
    public static final int TAG_DIGITAL_ZOOM_RATIO = 0;
    public static final int TAG_EXIF_IFD = 0;
    public static final int TAG_EXIF_VERSION = 0;
    public static final int TAG_EXPOSURE_BIAS_VALUE = 0;
    public static final int TAG_EXPOSURE_INDEX = 0;
    public static final int TAG_EXPOSURE_MODE = 0;
    public static final int TAG_EXPOSURE_PROGRAM = 0;
    public static final int TAG_EXPOSURE_TIME = 0;
    public static final int TAG_FILE_SOURCE = 0;
    public static final int TAG_FLASH = 0;
    public static final int TAG_FLASHPIX_VERSION = 0;
    public static final int TAG_FLASH_ENERGY = 0;
    public static final int TAG_FOCAL_LENGTH = 0;
    public static final int TAG_FOCAL_LENGTH_IN_35_MM_FILE = 0;
    public static final int TAG_FOCAL_PLANE_RESOLUTION_UNIT = 0;
    public static final int TAG_FOCAL_PLANE_X_RESOLUTION = 0;
    public static final int TAG_FOCAL_PLANE_Y_RESOLUTION = 0;
    public static final int TAG_F_NUMBER = 0;
    public static final int TAG_GAIN_CONTROL = 0;
    public static final int TAG_GPS_ALTITUDE = 0;
    public static final int TAG_GPS_ALTITUDE_REF = 0;
    public static final int TAG_GPS_AREA_INFORMATION = 0;
    public static final int TAG_GPS_DATE_STAMP = 0;
    public static final int TAG_GPS_DEST_BEARING = 0;
    public static final int TAG_GPS_DEST_BEARING_REF = 0;
    public static final int TAG_GPS_DEST_DISTANCE = 0;
    public static final int TAG_GPS_DEST_DISTANCE_REF = 0;
    public static final int TAG_GPS_DEST_LATITUDE = 0;
    public static final int TAG_GPS_DEST_LATITUDE_REF = 0;
    public static final int TAG_GPS_DEST_LONGITUDE = 0;
    public static final int TAG_GPS_DEST_LONGITUDE_REF = 0;
    public static final int TAG_GPS_DIFFERENTIAL = 0;
    public static final int TAG_GPS_DOP = 0;
    public static final int TAG_GPS_IFD = 0;
    public static final int TAG_GPS_IMG_DIRECTION = 0;
    public static final int TAG_GPS_IMG_DIRECTION_REF = 0;
    public static final int TAG_GPS_LATITUDE = 0;
    public static final int TAG_GPS_LATITUDE_REF = 0;
    public static final int TAG_GPS_LONGITUDE = 0;
    public static final int TAG_GPS_LONGITUDE_REF = 0;
    public static final int TAG_GPS_MAP_DATUM = 0;
    public static final int TAG_GPS_MEASURE_MODE = 0;
    public static final int TAG_GPS_PROCESSING_METHOD = 0;
    public static final int TAG_GPS_SATTELLITES = 0;
    public static final int TAG_GPS_SPEED = 0;
    public static final int TAG_GPS_SPEED_REF = 0;
    public static final int TAG_GPS_STATUS = 0;
    public static final int TAG_GPS_TIME_STAMP = 0;
    public static final int TAG_GPS_TRACK = 0;
    public static final int TAG_GPS_TRACK_REF = 0;
    public static final int TAG_GPS_VERSION_ID = 0;
    public static final int TAG_IMAGE_DESCRIPTION = 0;
    public static final int TAG_IMAGE_LENGTH = 0;
    public static final int TAG_IMAGE_UNIQUE_ID = 0;
    public static final int TAG_IMAGE_WIDTH = 0;
    public static final int TAG_INTEROPERABILITY_IFD = 0;
    public static final int TAG_INTEROPERABILITY_INDEX = 0;
    public static final int TAG_ISO_SPEED_RATINGS = 0;
    public static final int TAG_JPEG_INTERCHANGE_FORMAT = 0;
    public static final int TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = 0;
    public static final int TAG_LIGHT_SOURCE = 0;
    public static final int TAG_MAKE = 0;
    public static final int TAG_MAKER_NOTE = 0;
    public static final int TAG_MAX_APERTURE_VALUE = 0;
    public static final int TAG_METERING_MODE = 0;
    public static final int TAG_MODEL = 0;
    public static final int TAG_NULL = -1;
    public static final int TAG_OECF;
    public static final int TAG_ORIENTATION;
    public static final int TAG_PHOTOMETRIC_INTERPRETATION;
    public static final int TAG_PIXEL_X_DIMENSION;
    public static final int TAG_PIXEL_Y_DIMENSION;
    public static final int TAG_PLANAR_CONFIGURATION;
    public static final int TAG_PRIMARY_CHROMATICITIES;
    public static final int TAG_REFERENCE_BLACK_WHITE;
    public static final int TAG_RELATED_SOUND_FILE;
    public static final int TAG_RESOLUTION_UNIT;
    public static final int TAG_ROWS_PER_STRIP;
    public static final int TAG_SAMPLES_PER_PIXEL;
    public static final int TAG_SATURATION;
    public static final int TAG_SCENE_CAPTURE_TYPE;
    public static final int TAG_SCENE_TYPE;
    public static final int TAG_SENSING_METHOD;
    public static final int TAG_SHARPNESS;
    public static final int TAG_SHUTTER_SPEED_VALUE;
    public static final int TAG_SOFTWARE;
    public static final int TAG_SPATIAL_FREQUENCY_RESPONSE;
    public static final int TAG_SPECTRAL_SENSITIVITY;
    public static final int TAG_STRIP_BYTE_COUNTS;
    public static final int TAG_STRIP_OFFSETS;
    public static final int TAG_SUBJECT_AREA;
    public static final int TAG_SUBJECT_DISTANCE;
    public static final int TAG_SUBJECT_DISTANCE_RANGE;
    public static final int TAG_SUBJECT_LOCATION;
    public static final int TAG_SUB_SEC_TIME;
    public static final int TAG_SUB_SEC_TIME_DIGITIZED;
    public static final int TAG_SUB_SEC_TIME_ORIGINAL;
    public static final int TAG_TRANSFER_FUNCTION;
    public static final int TAG_USER_COMMENT;
    public static final int TAG_WHITE_BALANCE;
    public static final int TAG_WHITE_POINT;
    public static final int TAG_X_RESOLUTION;
    public static final int TAG_Y_CB_CR_COEFFICIENTS;
    public static final int TAG_Y_CB_CR_POSITIONING;
    public static final int TAG_Y_CB_CR_SUB_SAMPLING;
    public static final int TAG_Y_RESOLUTION;
    protected static HashSet<Short> sBannedDefines;
    private static HashSet<Short> sOffsetTags;
    private ExifData mData = new ExifData(DEFAULT_BYTE_ORDER);
    private final DateFormat mDateTimeStampFormat = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    private final DateFormat mGPSDateStampFormat = new SimpleDateFormat("yyyy:MM:dd");
    private final Calendar mGPSTimeStampCalendar = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
    private SparseIntArray mTagInfo = null;

    static {
        TAG_IMAGE_WIDTH = ExifInterface.defineTag(0, (short)256);
        TAG_IMAGE_LENGTH = ExifInterface.defineTag(0, (short)257);
        TAG_BITS_PER_SAMPLE = ExifInterface.defineTag(0, (short)258);
        TAG_COMPRESSION = ExifInterface.defineTag(0, (short)259);
        TAG_PHOTOMETRIC_INTERPRETATION = ExifInterface.defineTag(0, (short)262);
        TAG_IMAGE_DESCRIPTION = ExifInterface.defineTag(0, (short)270);
        TAG_MAKE = ExifInterface.defineTag(0, (short)271);
        TAG_MODEL = ExifInterface.defineTag(0, (short)272);
        TAG_STRIP_OFFSETS = ExifInterface.defineTag(0, (short)273);
        TAG_ORIENTATION = ExifInterface.defineTag(0, (short)274);
        TAG_SAMPLES_PER_PIXEL = ExifInterface.defineTag(0, (short)277);
        TAG_ROWS_PER_STRIP = ExifInterface.defineTag(0, (short)278);
        TAG_STRIP_BYTE_COUNTS = ExifInterface.defineTag(0, (short)279);
        TAG_X_RESOLUTION = ExifInterface.defineTag(0, (short)282);
        TAG_Y_RESOLUTION = ExifInterface.defineTag(0, (short)283);
        TAG_PLANAR_CONFIGURATION = ExifInterface.defineTag(0, (short)284);
        TAG_RESOLUTION_UNIT = ExifInterface.defineTag(0, (short)296);
        TAG_TRANSFER_FUNCTION = ExifInterface.defineTag(0, (short)301);
        TAG_SOFTWARE = ExifInterface.defineTag(0, (short)305);
        TAG_DATE_TIME = ExifInterface.defineTag(0, (short)306);
        TAG_ARTIST = ExifInterface.defineTag(0, (short)315);
        TAG_WHITE_POINT = ExifInterface.defineTag(0, (short)318);
        TAG_PRIMARY_CHROMATICITIES = ExifInterface.defineTag(0, (short)319);
        TAG_Y_CB_CR_COEFFICIENTS = ExifInterface.defineTag(0, (short)529);
        TAG_Y_CB_CR_SUB_SAMPLING = ExifInterface.defineTag(0, (short)530);
        TAG_Y_CB_CR_POSITIONING = ExifInterface.defineTag(0, (short)531);
        TAG_REFERENCE_BLACK_WHITE = ExifInterface.defineTag(0, (short)532);
        TAG_COPYRIGHT = ExifInterface.defineTag(0, (short)-32104);
        TAG_EXIF_IFD = ExifInterface.defineTag(0, (short)-30871);
        TAG_GPS_IFD = ExifInterface.defineTag(0, (short)-30683);
        TAG_JPEG_INTERCHANGE_FORMAT = ExifInterface.defineTag(1, (short)513);
        TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = ExifInterface.defineTag(1, (short)514);
        TAG_EXPOSURE_TIME = ExifInterface.defineTag(2, (short)-32102);
        TAG_F_NUMBER = ExifInterface.defineTag(2, (short)-32099);
        TAG_EXPOSURE_PROGRAM = ExifInterface.defineTag(2, (short)-30686);
        TAG_SPECTRAL_SENSITIVITY = ExifInterface.defineTag(2, (short)-30684);
        TAG_ISO_SPEED_RATINGS = ExifInterface.defineTag(2, (short)-30681);
        TAG_OECF = ExifInterface.defineTag(2, (short)-30680);
        TAG_EXIF_VERSION = ExifInterface.defineTag(2, (short)-28672);
        TAG_DATE_TIME_ORIGINAL = ExifInterface.defineTag(2, (short)-28669);
        TAG_DATE_TIME_DIGITIZED = ExifInterface.defineTag(2, (short)-28668);
        TAG_COMPONENTS_CONFIGURATION = ExifInterface.defineTag(2, (short)-28415);
        TAG_COMPRESSED_BITS_PER_PIXEL = ExifInterface.defineTag(2, (short)-28414);
        TAG_SHUTTER_SPEED_VALUE = ExifInterface.defineTag(2, (short)-28159);
        TAG_APERTURE_VALUE = ExifInterface.defineTag(2, (short)-28158);
        TAG_BRIGHTNESS_VALUE = ExifInterface.defineTag(2, (short)-28157);
        TAG_EXPOSURE_BIAS_VALUE = ExifInterface.defineTag(2, (short)-28156);
        TAG_MAX_APERTURE_VALUE = ExifInterface.defineTag(2, (short)-28155);
        TAG_SUBJECT_DISTANCE = ExifInterface.defineTag(2, (short)-28154);
        TAG_METERING_MODE = ExifInterface.defineTag(2, (short)-28153);
        TAG_LIGHT_SOURCE = ExifInterface.defineTag(2, (short)-28152);
        TAG_FLASH = ExifInterface.defineTag(2, (short)-28151);
        TAG_FOCAL_LENGTH = ExifInterface.defineTag(2, (short)-28150);
        TAG_SUBJECT_AREA = ExifInterface.defineTag(2, (short)-28140);
        TAG_MAKER_NOTE = ExifInterface.defineTag(2, (short)-28036);
        TAG_USER_COMMENT = ExifInterface.defineTag(2, (short)-28026);
        TAG_SUB_SEC_TIME = ExifInterface.defineTag(2, (short)-28016);
        TAG_SUB_SEC_TIME_ORIGINAL = ExifInterface.defineTag(2, (short)-28015);
        TAG_SUB_SEC_TIME_DIGITIZED = ExifInterface.defineTag(2, (short)-28014);
        TAG_FLASHPIX_VERSION = ExifInterface.defineTag(2, (short)-24576);
        TAG_COLOR_SPACE = ExifInterface.defineTag(2, (short)-24575);
        TAG_PIXEL_X_DIMENSION = ExifInterface.defineTag(2, (short)-24574);
        TAG_PIXEL_Y_DIMENSION = ExifInterface.defineTag(2, (short)-24573);
        TAG_RELATED_SOUND_FILE = ExifInterface.defineTag(2, (short)-24572);
        TAG_INTEROPERABILITY_IFD = ExifInterface.defineTag(2, (short)-24571);
        TAG_FLASH_ENERGY = ExifInterface.defineTag(2, (short)-24053);
        TAG_SPATIAL_FREQUENCY_RESPONSE = ExifInterface.defineTag(2, (short)-24052);
        TAG_FOCAL_PLANE_X_RESOLUTION = ExifInterface.defineTag(2, (short)-24050);
        TAG_FOCAL_PLANE_Y_RESOLUTION = ExifInterface.defineTag(2, (short)-24049);
        TAG_FOCAL_PLANE_RESOLUTION_UNIT = ExifInterface.defineTag(2, (short)-24048);
        TAG_SUBJECT_LOCATION = ExifInterface.defineTag(2, (short)-24044);
        TAG_EXPOSURE_INDEX = ExifInterface.defineTag(2, (short)-24043);
        TAG_SENSING_METHOD = ExifInterface.defineTag(2, (short)-24041);
        TAG_FILE_SOURCE = ExifInterface.defineTag(2, (short)-23808);
        TAG_SCENE_TYPE = ExifInterface.defineTag(2, (short)-23807);
        TAG_CFA_PATTERN = ExifInterface.defineTag(2, (short)-23806);
        TAG_CUSTOM_RENDERED = ExifInterface.defineTag(2, (short)-23551);
        TAG_EXPOSURE_MODE = ExifInterface.defineTag(2, (short)-23550);
        TAG_WHITE_BALANCE = ExifInterface.defineTag(2, (short)-23549);
        TAG_DIGITAL_ZOOM_RATIO = ExifInterface.defineTag(2, (short)-23548);
        TAG_FOCAL_LENGTH_IN_35_MM_FILE = ExifInterface.defineTag(2, (short)-23547);
        TAG_SCENE_CAPTURE_TYPE = ExifInterface.defineTag(2, (short)-23546);
        TAG_GAIN_CONTROL = ExifInterface.defineTag(2, (short)-23545);
        TAG_CONTRAST = ExifInterface.defineTag(2, (short)-23544);
        TAG_SATURATION = ExifInterface.defineTag(2, (short)-23543);
        TAG_SHARPNESS = ExifInterface.defineTag(2, (short)-23542);
        TAG_DEVICE_SETTING_DESCRIPTION = ExifInterface.defineTag(2, (short)-23541);
        TAG_SUBJECT_DISTANCE_RANGE = ExifInterface.defineTag(2, (short)-23540);
        TAG_IMAGE_UNIQUE_ID = ExifInterface.defineTag(2, (short)-23520);
        TAG_GPS_VERSION_ID = ExifInterface.defineTag(4, (short)0);
        TAG_GPS_LATITUDE_REF = ExifInterface.defineTag(4, (short)1);
        TAG_GPS_LATITUDE = ExifInterface.defineTag(4, (short)2);
        TAG_GPS_LONGITUDE_REF = ExifInterface.defineTag(4, (short)3);
        TAG_GPS_LONGITUDE = ExifInterface.defineTag(4, (short)4);
        TAG_GPS_ALTITUDE_REF = ExifInterface.defineTag(4, (short)5);
        TAG_GPS_ALTITUDE = ExifInterface.defineTag(4, (short)6);
        TAG_GPS_TIME_STAMP = ExifInterface.defineTag(4, (short)7);
        TAG_GPS_SATTELLITES = ExifInterface.defineTag(4, (short)8);
        TAG_GPS_STATUS = ExifInterface.defineTag(4, (short)9);
        TAG_GPS_MEASURE_MODE = ExifInterface.defineTag(4, (short)10);
        TAG_GPS_DOP = ExifInterface.defineTag(4, (short)11);
        TAG_GPS_SPEED_REF = ExifInterface.defineTag(4, (short)12);
        TAG_GPS_SPEED = ExifInterface.defineTag(4, (short)13);
        TAG_GPS_TRACK_REF = ExifInterface.defineTag(4, (short)14);
        TAG_GPS_TRACK = ExifInterface.defineTag(4, (short)15);
        TAG_GPS_IMG_DIRECTION_REF = ExifInterface.defineTag(4, (short)16);
        TAG_GPS_IMG_DIRECTION = ExifInterface.defineTag(4, (short)17);
        TAG_GPS_MAP_DATUM = ExifInterface.defineTag(4, (short)18);
        TAG_GPS_DEST_LATITUDE_REF = ExifInterface.defineTag(4, (short)19);
        TAG_GPS_DEST_LATITUDE = ExifInterface.defineTag(4, (short)20);
        TAG_GPS_DEST_LONGITUDE_REF = ExifInterface.defineTag(4, (short)21);
        TAG_GPS_DEST_LONGITUDE = ExifInterface.defineTag(4, (short)22);
        TAG_GPS_DEST_BEARING_REF = ExifInterface.defineTag(4, (short)23);
        TAG_GPS_DEST_BEARING = ExifInterface.defineTag(4, (short)24);
        TAG_GPS_DEST_DISTANCE_REF = ExifInterface.defineTag(4, (short)25);
        TAG_GPS_DEST_DISTANCE = ExifInterface.defineTag(4, (short)26);
        TAG_GPS_PROCESSING_METHOD = ExifInterface.defineTag(4, (short)27);
        TAG_GPS_AREA_INFORMATION = ExifInterface.defineTag(4, (short)28);
        TAG_GPS_DATE_STAMP = ExifInterface.defineTag(4, (short)29);
        TAG_GPS_DIFFERENTIAL = ExifInterface.defineTag(4, (short)30);
        TAG_INTEROPERABILITY_INDEX = ExifInterface.defineTag(3, (short)1);
        TAG = new Log.Tag("ExifInterface");
        sOffsetTags = new HashSet();
        sOffsetTags.add((Object)ExifInterface.getTrueTagKey(TAG_GPS_IFD));
        sOffsetTags.add((Object)ExifInterface.getTrueTagKey(TAG_EXIF_IFD));
        sOffsetTags.add((Object)ExifInterface.getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT));
        sOffsetTags.add((Object)ExifInterface.getTrueTagKey(TAG_INTEROPERABILITY_IFD));
        sOffsetTags.add((Object)ExifInterface.getTrueTagKey(TAG_STRIP_OFFSETS));
        sBannedDefines = new HashSet(sOffsetTags);
        sBannedDefines.add((Object)ExifInterface.getTrueTagKey(-1));
        sBannedDefines.add((Object)ExifInterface.getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
        sBannedDefines.add((Object)ExifInterface.getTrueTagKey(TAG_STRIP_BYTE_COUNTS));
        DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;
    }

    public ExifInterface() {
        this.mGPSDateStampFormat.setTimeZone(TimeZone.getTimeZone((String)"UTC"));
    }

    /*
     * Exception decompiling
     */
    protected static void closeSilently(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public static double convertLatOrLongToDouble(Rational[] arrrational, String string2) {
        double d2;
        block2 : {
            try {
                boolean bl;
                double d3 = arrrational[0].toDouble();
                double d4 = arrrational[1].toDouble();
                double d5 = arrrational[2].toDouble();
                d2 = d3 + d4 / 60.0 + d5 / 3600.0;
                if (string2.equals((Object)"S") || (bl = string2.equals((Object)"W"))) break block2;
                return d2;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw new IllegalArgumentException();
            }
        }
        return -d2;
    }

    public static int defineTag(int n2, short s2) {
        return s2 & 65535 | n2 << 16;
    }

    private void doExifStreamIO(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] arrby = new byte[1024];
        int n2 = inputStream.read(arrby, 0, 1024);
        while (n2 != -1) {
            outputStream.write(arrby, 0, n2);
            n2 = inputStream.read(arrby, 0, 1024);
        }
    }

    protected static int getAllowedIfdFlagsFromInfo(int n2) {
        return n2 >>> 24;
    }

    protected static int[] getAllowedIfdsFromInfo(int n2) {
        int n3 = ExifInterface.getAllowedIfdFlagsFromInfo(n2);
        int[] arrn = IfdData.getIfds();
        ArrayList arrayList = new ArrayList();
        int n4 = 0;
        for (int i2 = 0; i2 < 5; ++i2) {
            if ((1 & n3 >> i2) != 1) continue;
            arrayList.add((Object)arrn[i2]);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int[] arrn2 = new int[arrayList.size()];
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int n5 = (Integer)iterator.next();
            int n6 = n4 + 1;
            arrn2[n4] = n5;
            n4 = n6;
        }
        return arrn2;
    }

    protected static int getComponentCountFromInfo(int n2) {
        return n2 & 65535;
    }

    protected static int getFlagsFromAllowedIfds(int[] arrn) {
        if (arrn != null) {
            if (arrn.length == 0) {
                return 0;
            }
            int[] arrn2 = IfdData.getIfds();
            int n2 = 0;
            block0 : for (int i2 = 0; i2 < 5; ++i2) {
                for (int n3 : arrn) {
                    if (arrn2[i2] != n3) continue;
                    n2 |= 1 << i2;
                    continue block0;
                }
            }
            return n2;
        }
        return 0;
    }

    public static short getOrientationValueForRotation(int n2) {
        int n3 = n2 % 360;
        if (n3 < 0) {
            n3 += 360;
        }
        if (n3 < 90) {
            return 1;
        }
        if (n3 < 180) {
            return 6;
        }
        if (n3 < 270) {
            return 3;
        }
        return 8;
    }

    public static int getRotationForOrientationValue(short s2) {
        if (s2 != 1) {
            if (s2 != 3) {
                if (s2 != 6) {
                    if (s2 != 8) {
                        return 0;
                    }
                    return 270;
                }
                return 90;
            }
            return 180;
        }
        return 0;
    }

    public static int getTrueIfd(int n2) {
        return n2 >>> 16;
    }

    public static short getTrueTagKey(int n2) {
        return (short)n2;
    }

    protected static short getTypeFromInfo(int n2) {
        return (short)(255 & n2 >> 16);
    }

    private void initTagInfo() {
        int n2 = ExifInterface.getFlagsFromAllowedIfds(new int[]{0, 1}) << 24;
        SparseIntArray sparseIntArray = this.mTagInfo;
        int n3 = TAG_MAKE;
        int n4 = n2 | 131072;
        int n5 = n4 | 0;
        sparseIntArray.put(n3, n5);
        SparseIntArray sparseIntArray2 = this.mTagInfo;
        int n6 = TAG_IMAGE_WIDTH;
        int n7 = n2 | 262144;
        int n8 = n7 | 1;
        sparseIntArray2.put(n6, n8);
        this.mTagInfo.put(TAG_IMAGE_LENGTH, n8);
        SparseIntArray sparseIntArray3 = this.mTagInfo;
        int n9 = TAG_BITS_PER_SAMPLE;
        int n10 = n2 | 196608;
        sparseIntArray3.put(n9, n10 | 3);
        SparseIntArray sparseIntArray4 = this.mTagInfo;
        int n11 = TAG_COMPRESSION;
        int n12 = n10 | 1;
        sparseIntArray4.put(n11, n12);
        this.mTagInfo.put(TAG_PHOTOMETRIC_INTERPRETATION, n12);
        this.mTagInfo.put(TAG_ORIENTATION, n12);
        this.mTagInfo.put(TAG_SAMPLES_PER_PIXEL, n12);
        this.mTagInfo.put(TAG_PLANAR_CONFIGURATION, n12);
        this.mTagInfo.put(TAG_Y_CB_CR_SUB_SAMPLING, n10 | 2);
        this.mTagInfo.put(TAG_Y_CB_CR_POSITIONING, n12);
        SparseIntArray sparseIntArray5 = this.mTagInfo;
        int n13 = TAG_X_RESOLUTION;
        int n14 = n2 | 327680;
        int n15 = n14 | 1;
        sparseIntArray5.put(n13, n15);
        this.mTagInfo.put(TAG_Y_RESOLUTION, n15);
        this.mTagInfo.put(TAG_RESOLUTION_UNIT, n12);
        SparseIntArray sparseIntArray6 = this.mTagInfo;
        int n16 = TAG_STRIP_OFFSETS;
        int n17 = n7 | 0;
        sparseIntArray6.put(n16, n17);
        this.mTagInfo.put(TAG_ROWS_PER_STRIP, n8);
        this.mTagInfo.put(TAG_STRIP_BYTE_COUNTS, n17);
        this.mTagInfo.put(TAG_TRANSFER_FUNCTION, n10 | 768);
        this.mTagInfo.put(TAG_WHITE_POINT, n14 | 2);
        SparseIntArray sparseIntArray7 = this.mTagInfo;
        int n18 = TAG_PRIMARY_CHROMATICITIES;
        int n19 = n14 | 6;
        sparseIntArray7.put(n18, n19);
        this.mTagInfo.put(TAG_Y_CB_CR_COEFFICIENTS, n14 | 3);
        this.mTagInfo.put(TAG_REFERENCE_BLACK_WHITE, n19);
        this.mTagInfo.put(TAG_DATE_TIME, n4 | 20);
        this.mTagInfo.put(TAG_IMAGE_DESCRIPTION, n5);
        this.mTagInfo.put(TAG_MAKE, n5);
        this.mTagInfo.put(TAG_MODEL, n5);
        this.mTagInfo.put(TAG_SOFTWARE, n5);
        this.mTagInfo.put(TAG_ARTIST, n5);
        this.mTagInfo.put(TAG_COPYRIGHT, n5);
        this.mTagInfo.put(TAG_EXIF_IFD, n8);
        this.mTagInfo.put(TAG_GPS_IFD, n8);
        int n20 = ExifInterface.getFlagsFromAllowedIfds(new int[]{1}) << 24;
        SparseIntArray sparseIntArray8 = this.mTagInfo;
        int n21 = TAG_JPEG_INTERCHANGE_FORMAT;
        int n22 = 1 | (n20 | 262144);
        sparseIntArray8.put(n21, n22);
        this.mTagInfo.put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, n22);
        int n23 = ExifInterface.getFlagsFromAllowedIfds(new int[]{2}) << 24;
        SparseIntArray sparseIntArray9 = this.mTagInfo;
        int n24 = TAG_EXIF_VERSION;
        int n25 = n23 | 458752;
        int n26 = n25 | 4;
        sparseIntArray9.put(n24, n26);
        this.mTagInfo.put(TAG_FLASHPIX_VERSION, n26);
        SparseIntArray sparseIntArray10 = this.mTagInfo;
        int n27 = TAG_COLOR_SPACE;
        int n28 = n23 | 196608;
        int n29 = n28 | 1;
        sparseIntArray10.put(n27, n29);
        this.mTagInfo.put(TAG_COMPONENTS_CONFIGURATION, n26);
        SparseIntArray sparseIntArray11 = this.mTagInfo;
        int n30 = TAG_COMPRESSED_BITS_PER_PIXEL;
        int n31 = 1 | (n23 | 327680);
        sparseIntArray11.put(n30, n31);
        SparseIntArray sparseIntArray12 = this.mTagInfo;
        int n32 = TAG_PIXEL_X_DIMENSION;
        int n33 = 1 | (262144 | n23);
        sparseIntArray12.put(n32, n33);
        this.mTagInfo.put(TAG_PIXEL_Y_DIMENSION, n33);
        SparseIntArray sparseIntArray13 = this.mTagInfo;
        int n34 = TAG_MAKER_NOTE;
        int n35 = n25 | 0;
        sparseIntArray13.put(n34, n35);
        this.mTagInfo.put(TAG_USER_COMMENT, n35);
        SparseIntArray sparseIntArray14 = this.mTagInfo;
        int n36 = TAG_RELATED_SOUND_FILE;
        int n37 = n23 | 131072;
        sparseIntArray14.put(n36, n37 | 13);
        SparseIntArray sparseIntArray15 = this.mTagInfo;
        int n38 = TAG_DATE_TIME_ORIGINAL;
        int n39 = n37 | 20;
        sparseIntArray15.put(n38, n39);
        this.mTagInfo.put(TAG_DATE_TIME_DIGITIZED, n39);
        SparseIntArray sparseIntArray16 = this.mTagInfo;
        int n40 = TAG_SUB_SEC_TIME;
        int n41 = n37 | 0;
        sparseIntArray16.put(n40, n41);
        this.mTagInfo.put(TAG_SUB_SEC_TIME_ORIGINAL, n41);
        this.mTagInfo.put(TAG_SUB_SEC_TIME_DIGITIZED, n41);
        this.mTagInfo.put(TAG_IMAGE_UNIQUE_ID, n37 | 33);
        this.mTagInfo.put(TAG_EXPOSURE_TIME, n31);
        this.mTagInfo.put(TAG_F_NUMBER, n31);
        this.mTagInfo.put(TAG_EXPOSURE_PROGRAM, n29);
        this.mTagInfo.put(TAG_SPECTRAL_SENSITIVITY, n41);
        SparseIntArray sparseIntArray17 = this.mTagInfo;
        int n42 = TAG_ISO_SPEED_RATINGS;
        int n43 = n28 | 0;
        sparseIntArray17.put(n42, n43);
        this.mTagInfo.put(TAG_OECF, n35);
        SparseIntArray sparseIntArray18 = this.mTagInfo;
        int n44 = TAG_SHUTTER_SPEED_VALUE;
        int n45 = 1 | (n23 | 655360);
        sparseIntArray18.put(n44, n45);
        this.mTagInfo.put(TAG_APERTURE_VALUE, n31);
        this.mTagInfo.put(TAG_BRIGHTNESS_VALUE, n45);
        this.mTagInfo.put(TAG_EXPOSURE_BIAS_VALUE, n45);
        this.mTagInfo.put(TAG_MAX_APERTURE_VALUE, n31);
        this.mTagInfo.put(TAG_SUBJECT_DISTANCE, n31);
        this.mTagInfo.put(TAG_METERING_MODE, n29);
        this.mTagInfo.put(TAG_LIGHT_SOURCE, n29);
        this.mTagInfo.put(TAG_FLASH, n29);
        this.mTagInfo.put(TAG_FOCAL_LENGTH, n31);
        this.mTagInfo.put(TAG_SUBJECT_AREA, n43);
        this.mTagInfo.put(TAG_FLASH_ENERGY, n31);
        this.mTagInfo.put(TAG_SPATIAL_FREQUENCY_RESPONSE, n35);
        this.mTagInfo.put(TAG_FOCAL_PLANE_X_RESOLUTION, n31);
        this.mTagInfo.put(TAG_FOCAL_PLANE_Y_RESOLUTION, n31);
        this.mTagInfo.put(TAG_FOCAL_PLANE_RESOLUTION_UNIT, n29);
        this.mTagInfo.put(TAG_SUBJECT_LOCATION, 2 | n28);
        this.mTagInfo.put(TAG_EXPOSURE_INDEX, n31);
        this.mTagInfo.put(TAG_SENSING_METHOD, n29);
        SparseIntArray sparseIntArray19 = this.mTagInfo;
        int n46 = TAG_FILE_SOURCE;
        int n47 = n25 | 1;
        sparseIntArray19.put(n46, n47);
        this.mTagInfo.put(TAG_SCENE_TYPE, n47);
        this.mTagInfo.put(TAG_CFA_PATTERN, n35);
        this.mTagInfo.put(TAG_CUSTOM_RENDERED, n29);
        this.mTagInfo.put(TAG_EXPOSURE_MODE, n29);
        this.mTagInfo.put(TAG_WHITE_BALANCE, n29);
        this.mTagInfo.put(TAG_DIGITAL_ZOOM_RATIO, n31);
        this.mTagInfo.put(TAG_FOCAL_LENGTH_IN_35_MM_FILE, n29);
        this.mTagInfo.put(TAG_SCENE_CAPTURE_TYPE, n29);
        this.mTagInfo.put(TAG_GAIN_CONTROL, n31);
        this.mTagInfo.put(TAG_CONTRAST, n29);
        this.mTagInfo.put(TAG_SATURATION, n29);
        this.mTagInfo.put(TAG_SHARPNESS, n29);
        this.mTagInfo.put(TAG_DEVICE_SETTING_DESCRIPTION, n35);
        this.mTagInfo.put(TAG_SUBJECT_DISTANCE_RANGE, n29);
        this.mTagInfo.put(TAG_INTEROPERABILITY_IFD, n33);
        int n48 = ExifInterface.getFlagsFromAllowedIfds(new int[]{4}) << 24;
        SparseIntArray sparseIntArray20 = this.mTagInfo;
        int n49 = TAG_GPS_VERSION_ID;
        int n50 = 65536 | n48;
        sparseIntArray20.put(n49, n50 | 4);
        SparseIntArray sparseIntArray21 = this.mTagInfo;
        int n51 = TAG_GPS_LATITUDE_REF;
        int n52 = n48 | 131072;
        int n53 = n52 | 2;
        sparseIntArray21.put(n51, n53);
        this.mTagInfo.put(TAG_GPS_LONGITUDE_REF, n53);
        SparseIntArray sparseIntArray22 = this.mTagInfo;
        int n54 = TAG_GPS_LATITUDE;
        int n55 = 3 | (n48 | 655360);
        sparseIntArray22.put(n54, n55);
        this.mTagInfo.put(TAG_GPS_LONGITUDE, n55);
        this.mTagInfo.put(TAG_GPS_ALTITUDE_REF, n50 | 1);
        SparseIntArray sparseIntArray23 = this.mTagInfo;
        int n56 = TAG_GPS_ALTITUDE;
        int n57 = 327680 | n48;
        int n58 = n57 | 1;
        sparseIntArray23.put(n56, n58);
        this.mTagInfo.put(TAG_GPS_TIME_STAMP, n57 | 3);
        SparseIntArray sparseIntArray24 = this.mTagInfo;
        int n59 = TAG_GPS_SATTELLITES;
        int n60 = n52 | 0;
        sparseIntArray24.put(n59, n60);
        this.mTagInfo.put(TAG_GPS_STATUS, n53);
        this.mTagInfo.put(TAG_GPS_MEASURE_MODE, n53);
        this.mTagInfo.put(TAG_GPS_DOP, n58);
        this.mTagInfo.put(TAG_GPS_SPEED_REF, n53);
        this.mTagInfo.put(TAG_GPS_SPEED, n58);
        this.mTagInfo.put(TAG_GPS_TRACK_REF, n53);
        this.mTagInfo.put(TAG_GPS_TRACK, n58);
        this.mTagInfo.put(TAG_GPS_IMG_DIRECTION_REF, n53);
        this.mTagInfo.put(TAG_GPS_IMG_DIRECTION, n58);
        this.mTagInfo.put(TAG_GPS_MAP_DATUM, n60);
        this.mTagInfo.put(TAG_GPS_DEST_LATITUDE_REF, n53);
        this.mTagInfo.put(TAG_GPS_DEST_LATITUDE, n58);
        this.mTagInfo.put(TAG_GPS_DEST_BEARING_REF, n53);
        this.mTagInfo.put(TAG_GPS_DEST_BEARING, n58);
        this.mTagInfo.put(TAG_GPS_DEST_DISTANCE_REF, n53);
        this.mTagInfo.put(TAG_GPS_DEST_DISTANCE, n58);
        SparseIntArray sparseIntArray25 = this.mTagInfo;
        int n61 = TAG_GPS_PROCESSING_METHOD;
        int n62 = 0 | (458752 | n48);
        sparseIntArray25.put(n61, n62);
        this.mTagInfo.put(TAG_GPS_AREA_INFORMATION, n62);
        this.mTagInfo.put(TAG_GPS_DATE_STAMP, n52 | 11);
        this.mTagInfo.put(TAG_GPS_DIFFERENTIAL, 11 | (n48 | 196608));
        int n63 = ExifInterface.getFlagsFromAllowedIfds(new int[]{3}) << 24;
        this.mTagInfo.put(TAG_INTEROPERABILITY_INDEX, 0 | (n63 | 131072));
    }

    protected static boolean isIfdAllowed(int n2, int n3) {
        int[] arrn = IfdData.getIfds();
        int n4 = ExifInterface.getAllowedIfdFlagsFromInfo(n2);
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            if (n3 != arrn[i2] || (1 & n4 >> i2) != 1) continue;
            return true;
        }
        return false;
    }

    protected static boolean isOffsetTag(short s2) {
        return sOffsetTags.contains((Object)s2);
    }

    private static Rational[] toExifLatLong(double d2) {
        double d3 = Math.abs((double)d2);
        int n2 = (int)d3;
        double d4 = n2;
        Double.isNaN((double)d4);
        double d5 = 60.0 * (d3 - d4);
        int n3 = (int)d5;
        double d6 = n3;
        Double.isNaN((double)d6);
        int n4 = (int)(6000.0 * (d5 - d6));
        Rational[] arrrational = new Rational[]{new Rational(n2, 1L), new Rational(n3, 1L), new Rational(n4, 100L)};
        return arrrational;
    }

    public boolean addDateTimeStampTag(int n2, long l2, TimeZone timeZone) {
        if (n2 != TAG_DATE_TIME && n2 != TAG_DATE_TIME_DIGITIZED && n2 != TAG_DATE_TIME_ORIGINAL) {
            return false;
        }
        this.mDateTimeStampFormat.setTimeZone(timeZone);
        ExifTag exifTag = this.buildTag(n2, this.mDateTimeStampFormat.format((Object)l2));
        if (exifTag == null) {
            return false;
        }
        this.setTag(exifTag);
        return true;
    }

    public boolean addGpsDateTimeStampTag(long l2) {
        ExifTag exifTag = this.buildTag(TAG_GPS_DATE_STAMP, this.mGPSDateStampFormat.format((Object)l2));
        if (exifTag == null) {
            return false;
        }
        this.setTag(exifTag);
        this.mGPSTimeStampCalendar.setTimeInMillis(l2);
        int n2 = TAG_GPS_TIME_STAMP;
        Rational[] arrrational = new Rational[]{new Rational(this.mGPSTimeStampCalendar.get(11), 1L), new Rational(this.mGPSTimeStampCalendar.get(12), 1L), new Rational(this.mGPSTimeStampCalendar.get(13), 1L)};
        ExifTag exifTag2 = this.buildTag(n2, arrrational);
        if (exifTag2 == null) {
            return false;
        }
        this.setTag(exifTag2);
        return true;
    }

    public boolean addGpsTags(double d2, double d3) {
        ExifTag exifTag = this.buildTag(TAG_GPS_LATITUDE, ExifInterface.toExifLatLong(d2));
        ExifTag exifTag2 = this.buildTag(TAG_GPS_LONGITUDE, ExifInterface.toExifLatLong(d3));
        int n2 = TAG_GPS_LATITUDE_REF;
        String string2 = d2 >= 0.0 ? "N" : "S";
        ExifTag exifTag3 = this.buildTag(n2, string2);
        int n3 = TAG_GPS_LONGITUDE_REF;
        String string3 = d3 >= 0.0 ? "E" : "W";
        ExifTag exifTag4 = this.buildTag(n3, string3);
        if (exifTag != null && exifTag2 != null && exifTag3 != null && exifTag4 != null) {
            this.setTag(exifTag);
            this.setTag(exifTag2);
            this.setTag(exifTag3);
            this.setTag(exifTag4);
            return true;
        }
        return false;
    }

    public ExifTag buildTag(int n2, int n3, Object object) {
        int n4 = this.getTagInfo().get(n2);
        if (n4 != 0) {
            if (object == null) {
                return null;
            }
            short s2 = ExifInterface.getTypeFromInfo(n4);
            int n5 = ExifInterface.getComponentCountFromInfo(n4);
            boolean bl = n5 != 0;
            if (!ExifInterface.isIfdAllowed(n4, n3)) {
                return null;
            }
            ExifTag exifTag = new ExifTag(ExifInterface.getTrueTagKey(n2), s2, n5, n3, bl);
            if (!exifTag.setValue(object)) {
                return null;
            }
            return exifTag;
        }
        return null;
    }

    public ExifTag buildTag(int n2, Object object) {
        return this.buildTag(n2, ExifInterface.getTrueIfd(n2), object);
    }

    protected ExifTag buildUninitializedTag(int n2) {
        int n3 = this.getTagInfo().get(n2);
        if (n3 == 0) {
            return null;
        }
        short s2 = ExifInterface.getTypeFromInfo(n3);
        int n4 = ExifInterface.getComponentCountFromInfo(n3);
        boolean bl = n4 != 0;
        int n5 = ExifInterface.getTrueIfd(n2);
        ExifTag exifTag = new ExifTag(ExifInterface.getTrueTagKey(n2), s2, n4, n5, bl);
        return exifTag;
    }

    public void clearExif() {
        this.mData = new ExifData(DEFAULT_BYTE_ORDER);
    }

    public void deleteTag(int n2) {
        this.deleteTag(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public void deleteTag(int n2, int n3) {
        this.mData.removeTag(ExifInterface.getTrueTagKey(n2), n3);
    }

    public void forceRewriteExif(String string2) throws FileNotFoundException, IOException {
        this.forceRewriteExif(string2, (Collection<ExifTag>)this.getAllTags());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void forceRewriteExif(String string2, Collection<ExifTag> collection) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream;
        void var6_9;
        ExifData exifData;
        block4 : {
            if (this.rewriteExif(string2, collection)) return;
            exifData = this.mData;
            this.mData = new ExifData(DEFAULT_BYTE_ORDER);
            fileInputStream = new FileInputStream(string2);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.doExifStreamIO((InputStream)fileInputStream, (OutputStream)byteArrayOutputStream);
                byte[] arrby = byteArrayOutputStream.toByteArray();
                this.readExif(arrby);
                this.setTags(collection);
                this.writeExif(arrby, string2);
            }
            catch (Throwable throwable) {}
            fileInputStream.close();
            this.mData = exifData;
            return;
            break block4;
            catch (Throwable throwable) {
                fileInputStream = null;
            }
        }
        fileInputStream.close();
        this.mData = exifData;
        throw var6_9;
    }

    public int getActualTagCount(int n2, int n3) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return 0;
        }
        return exifTag.getComponentCount();
    }

    public List<ExifTag> getAllTags() {
        return this.mData.getAllTags();
    }

    public int getDefinedTagCount(int n2) {
        int n3 = this.getTagInfo().get(n2);
        if (n3 == 0) {
            return 0;
        }
        return ExifInterface.getComponentCountFromInfo(n3);
    }

    public int getDefinedTagDefaultIfd(int n2) {
        if (this.getTagInfo().get(n2) == 0) {
            return -1;
        }
        return ExifInterface.getTrueIfd(n2);
    }

    public short getDefinedTagType(int n2) {
        int n3 = this.getTagInfo().get(n2);
        if (n3 == 0) {
            return -1;
        }
        return ExifInterface.getTypeFromInfo(n3);
    }

    public OutputStream getExifWriterStream(OutputStream outputStream) {
        if (outputStream != null) {
            ExifOutputStream exifOutputStream = new ExifOutputStream(outputStream, this);
            exifOutputStream.setExifData(this.mData);
            return exifOutputStream;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public OutputStream getExifWriterStream(String string2) throws FileNotFoundException {
        if (string2 != null) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(string2);
            }
            catch (FileNotFoundException fileNotFoundException) {
                ExifInterface.closeSilently(null);
                throw fileNotFoundException;
            }
            return this.getExifWriterStream((OutputStream)fileOutputStream);
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public double[] getLatLongAsDoubles() {
        Rational[] arrrational = this.getTagRationalValues(TAG_GPS_LATITUDE);
        String string2 = this.getTagStringValue(TAG_GPS_LATITUDE_REF);
        Rational[] arrrational2 = this.getTagRationalValues(TAG_GPS_LONGITUDE);
        String string3 = this.getTagStringValue(TAG_GPS_LONGITUDE_REF);
        if (arrrational != null && arrrational2 != null && string2 != null && string3 != null && arrrational.length >= 3 && arrrational2.length >= 3) {
            double[] arrd = new double[]{ExifInterface.convertLatOrLongToDouble(arrrational, string2), ExifInterface.convertLatOrLongToDouble(arrrational2, string3)};
            return arrd;
        }
        return null;
    }

    public ExifTag getTag(int n2) {
        return this.getTag(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public ExifTag getTag(int n2, int n3) {
        if (!ExifTag.isValidIfd(n3)) {
            return null;
        }
        return this.mData.getTag(ExifInterface.getTrueTagKey(n2), n3);
    }

    public Byte getTagByteValue(int n2) {
        return this.getTagByteValue(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public Byte getTagByteValue(int n2, int n3) {
        byte[] arrby = this.getTagByteValues(n2, n3);
        if (arrby != null && arrby.length > 0) {
            return new Byte(arrby[0]);
        }
        return null;
    }

    public byte[] getTagByteValues(int n2) {
        return this.getTagByteValues(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public byte[] getTagByteValues(int n2, int n3) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return null;
        }
        return exifTag.getValueAsBytes();
    }

    protected int getTagDefinition(short s2, int n2) {
        return this.getTagInfo().get(ExifInterface.defineTag(n2, s2));
    }

    protected int getTagDefinitionForTag(ExifTag exifTag) {
        short s2 = exifTag.getDataType();
        int n2 = exifTag.getComponentCount();
        int n3 = exifTag.getIfd();
        return this.getTagDefinitionForTag(exifTag.getTagId(), s2, n2, n3);
    }

    protected int getTagDefinitionForTag(short s2, short s3, int n2, int n3) {
        int[] arrn = this.getTagDefinitionsForTagId(s2);
        if (arrn == null) {
            return -1;
        }
        SparseIntArray sparseIntArray = this.getTagInfo();
        for (int n4 : arrn) {
            int n5;
            boolean bl;
            short s4;
            block3 : {
                int n6 = sparseIntArray.get(n4);
                s4 = ExifInterface.getTypeFromInfo(n6);
                n5 = ExifInterface.getComponentCountFromInfo(n6);
                int[] arrn2 = ExifInterface.getAllowedIfdsFromInfo(n6);
                int n7 = arrn2.length;
                for (int i2 = 0; i2 < n7; ++i2) {
                    if (arrn2[i2] != n3) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
            if (!bl || s3 != s4 || n2 != n5 && n5 != 0) continue;
            return n4;
        }
        return -1;
    }

    protected int[] getTagDefinitionsForTagId(short s2) {
        int[] arrn = IfdData.getIfds();
        int[] arrn2 = new int[arrn.length];
        SparseIntArray sparseIntArray = this.getTagInfo();
        int n2 = arrn.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = ExifInterface.defineTag(arrn[i2], s2);
            if (sparseIntArray.get(n4) == 0) continue;
            int n5 = n3 + 1;
            arrn2[n3] = n4;
            n3 = n5;
        }
        if (n3 == 0) {
            return null;
        }
        return Arrays.copyOfRange((int[])arrn2, (int)0, (int)n3);
    }

    protected SparseIntArray getTagInfo() {
        if (this.mTagInfo == null) {
            this.mTagInfo = new SparseIntArray();
            this.initTagInfo();
        }
        return this.mTagInfo;
    }

    public Integer getTagIntValue(int n2) {
        return this.getTagIntValue(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public Integer getTagIntValue(int n2, int n3) {
        int[] arrn = this.getTagIntValues(n2, n3);
        if (arrn != null && arrn.length > 0) {
            return new Integer(arrn[0]);
        }
        return null;
    }

    public int[] getTagIntValues(int n2) {
        return this.getTagIntValues(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public int[] getTagIntValues(int n2, int n3) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return null;
        }
        return exifTag.getValueAsInts();
    }

    public Long getTagLongValue(int n2) {
        return this.getTagLongValue(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public Long getTagLongValue(int n2, int n3) {
        long[] arrl = this.getTagLongValues(n2, n3);
        if (arrl != null && arrl.length > 0) {
            return new Long(arrl[0]);
        }
        return null;
    }

    public long[] getTagLongValues(int n2) {
        return this.getTagLongValues(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public long[] getTagLongValues(int n2, int n3) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return null;
        }
        return exifTag.getValueAsLongs();
    }

    public Rational getTagRationalValue(int n2) {
        return this.getTagRationalValue(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public Rational getTagRationalValue(int n2, int n3) {
        Rational[] arrrational = this.getTagRationalValues(n2, n3);
        if (arrrational != null && arrrational.length != 0) {
            return new Rational(arrrational[0]);
        }
        return null;
    }

    public Rational[] getTagRationalValues(int n2) {
        return this.getTagRationalValues(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public Rational[] getTagRationalValues(int n2, int n3) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return null;
        }
        return exifTag.getValueAsRationals();
    }

    public String getTagStringValue(int n2) {
        return this.getTagStringValue(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public String getTagStringValue(int n2, int n3) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return null;
        }
        return exifTag.getValueAsString();
    }

    public Object getTagValue(int n2) {
        return this.getTagValue(n2, this.getDefinedTagDefaultIfd(n2));
    }

    public Object getTagValue(int n2, int n3) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return null;
        }
        return exifTag.getValue();
    }

    public List<ExifTag> getTagsForIfdId(int n2) {
        return this.mData.getAllTagsForIfd(n2);
    }

    public List<ExifTag> getTagsForTagId(short s2) {
        return this.mData.getAllTagsForTagId(s2);
    }

    public byte[] getThumbnail() {
        return this.mData.getCompressedThumbnail();
    }

    public Bitmap getThumbnailBitmap() {
        if (this.mData.hasCompressedThumbnail()) {
            byte[] arrby = this.mData.getCompressedThumbnail();
            return BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length);
        }
        this.mData.hasUncompressedStrip();
        return null;
    }

    public byte[] getThumbnailBytes() {
        if (this.mData.hasCompressedThumbnail()) {
            return this.mData.getCompressedThumbnail();
        }
        this.mData.hasUncompressedStrip();
        return null;
    }

    public String getUserComment() {
        return this.mData.getUserComment();
    }

    public boolean hasThumbnail() {
        return this.mData.hasCompressedThumbnail();
    }

    public boolean isTagCountDefined(int n2) {
        int n3 = this.getTagInfo().get(n2);
        if (n3 == 0) {
            return false;
        }
        int n4 = ExifInterface.getComponentCountFromInfo(n3);
        boolean bl = false;
        if (n4 != 0) {
            bl = true;
        }
        return bl;
    }

    public boolean isThumbnailCompressed() {
        return this.mData.hasCompressedThumbnail();
    }

    public void readExif(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            ExifData exifData;
            try {}
            catch (ExifInvalidFormatException exifInvalidFormatException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid exif format : ");
                stringBuilder.append((Object)exifInvalidFormatException);
                throw new IOException(stringBuilder.toString());
            }
            this.mData = exifData = new ExifReader(this).read(inputStream);
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void readExif(String string2) throws FileNotFoundException, IOException {
        if (string2 != null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)new FileInputStream(string2));
            this.readExif((InputStream)bufferedInputStream);
            bufferedInputStream.close();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void readExif(byte[] arrby) throws IOException {
        this.readExif((InputStream)new ByteArrayInputStream(arrby));
    }

    public void removeCompressedThumbnail() {
        this.mData.setCompressedThumbnail(null);
    }

    public void removeTagDefinition(int n2) {
        this.getTagInfo().delete(n2);
    }

    public void resetTagDefinitions() {
        this.mTagInfo = null;
    }

    /*
     * Exception decompiling
     */
    public boolean rewriteExif(String var1_1, Collection<ExifTag> var2_2) throws FileNotFoundException, IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 7[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public boolean rewriteExif(ByteBuffer byteBuffer, Collection<ExifTag> collection) throws IOException {
        try {
            ExifModifier exifModifier = new ExifModifier(byteBuffer, this);
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                exifModifier.modifyTag((ExifTag)iterator.next());
            }
            boolean bl = exifModifier.commit();
            return bl;
        }
        catch (ExifInvalidFormatException exifInvalidFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid exif format : ");
            stringBuilder.append((Object)exifInvalidFormatException);
            throw new IOException(stringBuilder.toString());
        }
    }

    public boolean setCompressedThumbnail(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)byteArrayOutputStream)) {
            return false;
        }
        return this.setCompressedThumbnail(byteArrayOutputStream.toByteArray());
    }

    public boolean setCompressedThumbnail(byte[] arrby) {
        this.mData.clearThumbnailAndStrips();
        this.mData.setCompressedThumbnail(arrby);
        return true;
    }

    public void setExif(Collection<ExifTag> collection) {
        this.clearExif();
        this.setTags(collection);
    }

    public ExifTag setTag(ExifTag exifTag) {
        return this.mData.addTag(exifTag);
    }

    public int setTagDefinition(short s2, int n2, short s3, short s4, int[] arrn) {
        if (sBannedDefines.contains((Object)s2)) {
            return -1;
        }
        if (ExifTag.isValidType(s3) && ExifTag.isValidIfd(n2)) {
            int n3 = ExifInterface.defineTag(n2, s2);
            if (n3 == -1) {
                return -1;
            }
            int[] arrn2 = this.getTagDefinitionsForTagId(s2);
            SparseIntArray sparseIntArray = this.getTagInfo();
            int n4 = arrn.length;
            int n5 = 0;
            boolean bl = false;
            for (int i2 = 0; i2 < n4; ++i2) {
                int n6 = arrn[i2];
                if (n2 == n6) {
                    bl = true;
                }
                if (ExifTag.isValidIfd(n6)) continue;
                return -1;
            }
            if (!bl) {
                return -1;
            }
            int n7 = ExifInterface.getFlagsFromAllowedIfds(arrn);
            if (arrn2 != null) {
                int n8 = arrn2.length;
                while (n5 < n8) {
                    if ((n7 & ExifInterface.getAllowedIfdFlagsFromInfo(sparseIntArray.get(arrn2[n5]))) != 0) {
                        return -1;
                    }
                    ++n5;
                }
            }
            this.getTagInfo().put(n3, s4 | (n7 << 24 | s3 << 16));
            return n3;
        }
        return -1;
    }

    public boolean setTagValue(int n2, int n3, Object object) {
        ExifTag exifTag = this.getTag(n2, n3);
        if (exifTag == null) {
            return false;
        }
        return exifTag.setValue(object);
    }

    public boolean setTagValue(int n2, Object object) {
        return this.setTagValue(n2, this.getDefinedTagDefaultIfd(n2), object);
    }

    public void setTags(Collection<ExifTag> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.setTag((ExifTag)iterator.next());
        }
    }

    public void writeExif(Bitmap bitmap, OutputStream outputStream) throws IOException {
        if (bitmap != null && outputStream != null) {
            OutputStream outputStream2 = this.getExifWriterStream(outputStream);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream2);
            outputStream2.flush();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void writeExif(Bitmap bitmap, String string2) throws FileNotFoundException, IOException {
        if (bitmap != null && string2 != null) {
            OutputStream outputStream = this.getExifWriterStream(string2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void writeExif(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream != null && outputStream != null) {
            OutputStream outputStream2 = this.getExifWriterStream(outputStream);
            this.doExifStreamIO(inputStream, outputStream2);
            outputStream2.flush();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void writeExif(InputStream inputStream, String string2) throws FileNotFoundException, IOException {
        if (inputStream != null && string2 != null) {
            OutputStream outputStream = this.getExifWriterStream(string2);
            this.doExifStreamIO(inputStream, outputStream);
            outputStream.flush();
            outputStream.close();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void writeExif(String string2, String string3) throws FileNotFoundException, IOException {
        if (string2 != null && string3 != null) {
            FileInputStream fileInputStream = new FileInputStream(string2);
            this.writeExif((InputStream)fileInputStream, string3);
            fileInputStream.close();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void writeExif(byte[] arrby, OutputStream outputStream) throws IOException {
        if (arrby != null && outputStream != null) {
            OutputStream outputStream2 = this.getExifWriterStream(outputStream);
            outputStream2.write(arrby, 0, arrby.length);
            outputStream2.flush();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void writeExif(byte[] arrby, String string2) throws FileNotFoundException, IOException {
        if (arrby != null && string2 != null) {
            OutputStream outputStream = this.getExifWriterStream(string2);
            outputStream.write(arrby, 0, arrby.length);
            outputStream.flush();
            outputStream.close();
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public static interface ColorSpace {
        public static final short SRGB = 1;
        public static final short UNCALIBRATED = -1;
    }

    public static interface ComponentsConfiguration {
        public static final short B = 6;
        public static final short CB = 2;
        public static final short CR = 3;
        public static final short G = 5;
        public static final short NOT_EXIST = 0;
        public static final short R = 4;
        public static final short Y = 1;
    }

    public static interface Compression {
        public static final short JPEG = 6;
        public static final short UNCOMPRESSION = 1;
    }

    public static interface Contrast {
        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public static interface ExposureMode {
        public static final short AUTO_BRACKET = 2;
        public static final short AUTO_EXPOSURE = 0;
        public static final short MANUAL_EXPOSURE = 1;
    }

    public static interface ExposureProgram {
        public static final short ACTION_PROGRAM = 6;
        public static final short APERTURE_PRIORITY = 3;
        public static final short CREATIVE_PROGRAM = 5;
        public static final short LANDSCAPE_MODE = 8;
        public static final short MANUAL = 1;
        public static final short NORMAL_PROGRAM = 2;
        public static final short NOT_DEFINED = 0;
        public static final short PROTRAIT_MODE = 7;
        public static final short SHUTTER_PRIORITY = 4;
    }

    public static interface FileSource {
        public static final short DSC = 3;
    }

    public static interface Flash {
        public static final short DID_NOT_FIRE = 0;
        public static final short FIRED = 1;
        public static final short FUNCTION_NO_FUNCTION = 32;
        public static final short FUNCTION_PRESENT = 0;
        public static final short MODE_AUTO_MODE = 24;
        public static final short MODE_COMPULSORY_FLASH_FIRING = 8;
        public static final short MODE_COMPULSORY_FLASH_SUPPRESSION = 16;
        public static final short MODE_UNKNOWN = 0;
        public static final short RED_EYE_REDUCTION_NO_OR_UNKNOWN = 0;
        public static final short RED_EYE_REDUCTION_SUPPORT = 64;
        public static final short RETURN_NO_STROBE_RETURN_DETECTION_FUNCTION = 0;
        public static final short RETURN_STROBE_RETURN_LIGHT_DETECTED = 6;
        public static final short RETURN_STROBE_RETURN_LIGHT_NOT_DETECTED = 4;
    }

    public static interface GainControl {
        public static final short HIGH_DOWN = 4;
        public static final short HIGH_UP = 2;
        public static final short LOW_DOWN = 3;
        public static final short LOW_UP = 1;
        public static final short NONE;
    }

    public static interface GpsAltitudeRef {
        public static final short SEA_LEVEL = 0;
        public static final short SEA_LEVEL_NEGATIVE = 1;
    }

    public static interface GpsDifferential {
        public static final short DIFFERENTIAL_CORRECTION_APPLIED = 1;
        public static final short WITHOUT_DIFFERENTIAL_CORRECTION;
    }

    public static interface GpsLatitudeRef {
        public static final String NORTH = "N";
        public static final String SOUTH = "S";
    }

    public static interface GpsLongitudeRef {
        public static final String EAST = "E";
        public static final String WEST = "W";
    }

    public static interface GpsMeasureMode {
        public static final String MODE_2_DIMENSIONAL = "2";
        public static final String MODE_3_DIMENSIONAL = "3";
    }

    public static interface GpsSpeedRef {
        public static final String KILOMETERS = "K";
        public static final String KNOTS = "N";
        public static final String MILES = "M";
    }

    public static interface GpsStatus {
        public static final String INTEROPERABILITY = "V";
        public static final String IN_PROGRESS = "A";
    }

    public static interface GpsTrackRef {
        public static final String MAGNETIC_DIRECTION = "M";
        public static final String TRUE_DIRECTION = "T";
    }

    public static interface LightSource {
        public static final short CLOUDY_WEATHER = 10;
        public static final short COOL_WHITE_FLUORESCENT = 14;
        public static final short D50 = 23;
        public static final short D55 = 20;
        public static final short D65 = 21;
        public static final short D75 = 22;
        public static final short DAYLIGHT = 1;
        public static final short DAYLIGHT_FLUORESCENT = 12;
        public static final short DAY_WHITE_FLUORESCENT = 13;
        public static final short FINE_WEATHER = 9;
        public static final short FLASH = 4;
        public static final short FLUORESCENT = 2;
        public static final short ISO_STUDIO_TUNGSTEN = 24;
        public static final short OTHER = 255;
        public static final short SHADE = 11;
        public static final short STANDARD_LIGHT_A = 17;
        public static final short STANDARD_LIGHT_B = 18;
        public static final short STANDARD_LIGHT_C = 19;
        public static final short TUNGSTEN = 3;
        public static final short UNKNOWN = 0;
        public static final short WHITE_FLUORESCENT = 15;
    }

    public static interface MeteringMode {
        public static final short AVERAGE = 1;
        public static final short CENTER_WEIGHTED_AVERAGE = 2;
        public static final short MULTISPOT = 4;
        public static final short OTHER = 255;
        public static final short PARTAIL = 6;
        public static final short PATTERN = 5;
        public static final short SPOT = 3;
        public static final short UNKNOWN;
    }

    public static interface Orientation {
        public static final short BOTTOM_LEFT = 3;
        public static final short BOTTOM_RIGHT = 4;
        public static final short LEFT_BOTTOM = 7;
        public static final short LEFT_TOP = 5;
        public static final short RIGHT_BOTTOM = 8;
        public static final short RIGHT_TOP = 6;
        public static final short TOP_LEFT = 1;
        public static final short TOP_RIGHT = 2;
    }

    public static interface PhotometricInterpretation {
        public static final short RGB = 2;
        public static final short YCBCR = 6;
    }

    public static interface PlanarConfiguration {
        public static final short CHUNKY = 1;
        public static final short PLANAR = 2;
    }

    public static interface ResolutionUnit {
        public static final short CENTIMETERS = 3;
        public static final short INCHES = 2;
    }

    public static interface Saturation {
        public static final short HIGH = 2;
        public static final short LOW = 1;
        public static final short NORMAL;
    }

    public static interface SceneCapture {
        public static final short LANDSCAPE = 1;
        public static final short NIGHT_SCENE = 3;
        public static final short PROTRAIT = 2;
        public static final short STANDARD;
    }

    public static interface SceneType {
        public static final short DIRECT_PHOTOGRAPHED = 1;
    }

    public static interface SensingMethod {
        public static final short COLOR_SEQUENTIAL_AREA = 5;
        public static final short COLOR_SEQUENTIAL_LINEAR = 8;
        public static final short NOT_DEFINED = 1;
        public static final short ONE_CHIP_COLOR = 2;
        public static final short THREE_CHIP_COLOR = 4;
        public static final short TRILINEAR = 7;
        public static final short TWO_CHIP_COLOR = 3;
    }

    public static interface Sharpness {
        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public static interface SubjectDistance {
        public static final short CLOSE_VIEW = 2;
        public static final short DISTANT_VIEW = 3;
        public static final short MACRO = 1;
        public static final short UNKNOWN;
    }

    public static interface WhiteBalance {
        public static final short AUTO = 0;
        public static final short MANUAL = 1;
    }

    public static interface YCbCrPositioning {
        public static final short CENTERED = 1;
        public static final short CO_SITED = 2;
    }

}

