/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.security.KeyPairGeneratorSpec
 *  android.security.KeyPairGeneratorSpec$Builder
 *  android.util.Base64
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.math.BigInteger
 *  java.security.InvalidAlgorithmParameterException
 *  java.security.Key
 *  java.security.KeyPair
 *  java.security.KeyPairGenerator
 *  java.security.KeyStore
 *  java.security.KeyStore$LoadStoreParameter
 *  java.security.KeyStoreException
 *  java.security.NoSuchAlgorithmException
 *  java.security.NoSuchProviderException
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.spec.AlgorithmParameterSpec
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  javax.crypto.Cipher
 *  javax.security.auth.x500.X500Principal
 */
package com.xiaomi.onetrack.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import com.xiaomi.onetrack.h.o;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

public class b {
    public static final String a = b.b();
    private static final String b = "AndroidKeyStore";
    private static final String c = "AndroidKeyStore";
    private static final String d = "RSA/ECB/PKCS1Padding";
    private static final String e = "RSA_KEY";

    public static String a(Context context, String string2) throws Exception {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            block4 : {
                Cipher cipher = Cipher.getInstance((String)d);
                KeyStore keyStore = KeyStore.getInstance((String)"AndroidKeyStore");
                keyStore.load(null);
                b.a(context, keyStore);
                Certificate certificate = keyStore.getCertificate(e);
                if (certificate == null) break block4;
                cipher.init(1, (Key)certificate.getPublicKey());
                String string3 = Base64.encodeToString((byte[])cipher.doFinal(string2.getBytes("UTF-8")), (int)0);
                // ** MonitorExit[var7_2] (shouldn't be in output)
                return string3;
            }
            // ** MonitorExit[var7_2] (shouldn't be in output)
            return null;
        }
    }

    private static void a() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, InvalidAlgorithmParameterException, NoSuchProviderException, NoSuchAlgorithmException {
        Class class_ = Class.forName((String)"android.security.keystore.KeyGenParameterSpec$Builder");
        if (class_ != null) {
            Class[] arrclass = new Class[]{String.class, Integer.TYPE};
            Constructor constructor = class_.getConstructor(arrclass);
            Class class_2 = Class.forName((String)"android.security.keystore.KeyProperties");
            int n2 = class_2.getDeclaredField("PURPOSE_ENCRYPT").getInt(null);
            int n3 = class_2.getDeclaredField("PURPOSE_DECRYPT").getInt(null);
            Object[] arrobject = new Object[]{e, n2 | n3};
            Object object = constructor.newInstance(arrobject);
            Method method = class_.getMethod("setDigests", new Class[]{String[].class});
            String string2 = (String)class_2.getDeclaredField("DIGEST_SHA256").get(null);
            String string3 = (String)class_2.getDeclaredField("DIGEST_SHA512").get(null);
            method.invoke(object, new Object[]{new String[]{string2, string3}});
            Method method2 = class_.getMethod("setEncryptionPaddings", new Class[]{String[].class});
            String string4 = (String)class_2.getDeclaredField("ENCRYPTION_PADDING_RSA_PKCS1").get(null);
            method2.invoke(object, new Object[]{new String[]{string4}});
            Object object2 = class_.getMethod("build", new Class[0]).invoke(object, new Object[0]);
            Class class_3 = Class.forName((String)"java.security.KeyPairGenerator");
            if (class_3 != null) {
                KeyPairGenerator keyPairGenerator = (KeyPairGenerator)class_3.getMethod("getInstance", new Class[]{String.class, String.class}).invoke(null, new Object[]{"RSA", "AndroidKeyStore"});
                class_3.getMethod("initialize", new Class[]{AlgorithmParameterSpec.class}).invoke((Object)keyPairGenerator, new Object[]{object2});
                keyPairGenerator.generateKeyPair();
            }
        }
    }

    @TargetApi(value=18)
    private static void a(Context context) throws KeyStoreException, NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 1);
        KeyPairGeneratorSpec keyPairGeneratorSpec = new KeyPairGeneratorSpec.Builder(context).setAlias(e).setSubject(new X500Principal("CN=RSA_KEY")).setSerialNumber(BigInteger.valueOf((long)1337L)).setStartDate(gregorianCalendar.getTime()).setEndDate(gregorianCalendar2.getTime()).build();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance((String)"RSA", (String)"AndroidKeyStore");
        keyPairGenerator.initialize((AlgorithmParameterSpec)keyPairGeneratorSpec);
        keyPairGenerator.generateKeyPair();
    }

    private static void a(Context context, KeyStore keyStore) {
        try {
            if (!keyStore.containsAlias(e)) {
                if (Build.VERSION.SDK_INT < 18) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 23) {
                    b.a(context);
                    return;
                }
                b.a();
                return;
            }
        }
        catch (Exception exception) {
            o.b("AndroidKeyStore", "createKey e", exception);
        }
    }

    private static String b() {
        byte[] arrby = new byte[]{104, 42, 89, 51, 49, 93, 99, 33, 64, 53, 78, 115, 95, 106, 80, 115, 118, 101, 106, 33, 64, 51, 91, 40, 42, 119, 40, 33, 108};
        try {
            String string2 = new String(arrby, "UTF-8");
            return string2;
        }
        catch (Exception exception) {
            o.b("AndroidKeyStore", exception.getMessage());
            return "";
        }
    }

    public static String b(Context context, String string2) throws Exception {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            Cipher cipher = Cipher.getInstance((String)d);
            KeyStore keyStore = KeyStore.getInstance((String)"AndroidKeyStore");
            keyStore.load(null);
            b.a(context, keyStore);
            cipher.init(2, (Key)((PrivateKey)keyStore.getKey(e, null)));
            String string3 = new String(cipher.doFinal(Base64.decode((String)string2, (int)0)), "UTF-8");
            // ** MonitorExit[var6_2] (shouldn't be in output)
            return string3;
        }
    }
}

