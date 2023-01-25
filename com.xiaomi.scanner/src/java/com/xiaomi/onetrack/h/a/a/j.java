/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.TimeUnit
 */
package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import com.xiaomi.onetrack.h.o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class j {
    public final LinkedBlockingQueue<a> a = new LinkedBlockingQueue(1);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String a(Context context) {
        Class class_ = Class.forName((String)"com.bun.miitmdid.core.MdidSdkHelper");
        Class class_2 = Class.forName((String)"com.bun.supplier.IIdentifierListener");
        b b2 = new b();
        Object object = Proxy.newProxyInstance((ClassLoader)context.getClassLoader(), (Class[])new Class[]{class_2}, (InvocationHandler)b2);
        Class[] arrclass = new Class[]{Context.class, Boolean.TYPE, class_2};
        Method method = class_.getDeclaredMethod("InitSdk", arrclass);
        Object[] arrobject = new Object[]{context, true, object};
        method.invoke((Object)class_, arrobject);
        a a2 = (a)this.a.poll(1L, TimeUnit.SECONDS);
        if (a2 == null) return "";
        try {
            return a2.c[1].getClass().getMethod("getOAID", new Class[0]).invoke(a2.c[1], new Object[0]).toString();
        }
        catch (Exception exception) {
            o.b("MsaSDKHelper", exception.getMessage());
        }
        return "";
    }

    private class a {
        Object a;
        Method b;
        Object[] c;

        public a(Object object, Method method, Object[] arrobject) {
            this.a = object;
            this.b = method;
            this.c = arrobject;
        }
    }

    public class b
    implements InvocationHandler {
        public Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
            try {
                a a2 = new a(object, method, arrobject);
                j.this.a.offer((Object)a2, 1L, TimeUnit.SECONDS);
            }
            catch (Exception exception) {
                try {
                    exception.printStackTrace();
                }
                catch (Exception exception2) {
                    o.b("MsaSDKHelper", exception2.getMessage());
                }
            }
            return null;
        }
    }

}

