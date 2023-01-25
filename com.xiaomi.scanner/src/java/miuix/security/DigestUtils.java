/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package miuix.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ALGORITHM_SHA_1 = "SHA-1";
    private static final int BUFFER_SIZE = 4096;

    protected DigestUtils() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static byte[] get(InputStream inputStream, String string2) throws IOException {
        int n;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)string2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("NoSuchAlgorithmException", (Throwable)noSuchAlgorithmException);
        }
        byte[] arrby = new byte[4096];
        while ((n = inputStream.read(arrby)) > 0) {
            messageDigest.update(arrby, 0, n);
        }
        return messageDigest.digest();
    }

    public static byte[] get(CharSequence charSequence, String string2) {
        return DigestUtils.get(charSequence.toString().getBytes(), string2);
    }

    public static byte[] get(byte[] arrby, String string2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
        try {
            byte[] arrby2 = DigestUtils.get((InputStream)byteArrayInputStream, string2);
            return arrby2;
        }
        catch (IOException iOException) {
            throw new RuntimeException("IO exception happend in ByteArrayInputStream", (Throwable)iOException);
        }
    }
}

