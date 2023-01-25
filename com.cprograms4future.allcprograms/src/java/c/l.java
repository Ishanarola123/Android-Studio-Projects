/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.a
 *  c.d
 *  c.e
 *  c.l$1
 *  c.l$2
 *  c.l$3
 *  c.m
 *  c.n
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.Socket
 *  java.util.logging.Logger
 */
package c;

import c.a;
import c.d;
import c.e;
import c.l;
import c.m;
import c.n;
import c.q;
import c.r;
import c.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class l {
    private static final Logger a = Logger.getLogger((String)l.class.getName());

    private l() {
    }

    public static d a(q q2) {
        if (q2 != null) {
            return new m(q2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static e a(r r2) {
        if (r2 != null) {
            return new n(r2);
        }
        throw new IllegalArgumentException("source == null");
    }

    private static q a(OutputStream outputStream, s s2) {
        if (outputStream != null) {
            if (s2 != null) {
                return new 1(s2, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static q a(Socket socket) throws IOException {
        if (socket != null) {
            a a2 = l.c(socket);
            return a2.a(l.a(socket.getOutputStream(), (s)a2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static r a(File file) throws FileNotFoundException {
        if (file != null) {
            return l.a((InputStream)new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static r a(InputStream inputStream) {
        return l.a(inputStream, new s());
    }

    private static r a(InputStream inputStream, s s2) {
        if (inputStream != null) {
            if (s2 != null) {
                return new 2(s2, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    static /* synthetic */ Logger a() {
        return a;
    }

    public static r b(Socket socket) throws IOException {
        if (socket != null) {
            a a2 = l.c(socket);
            return a2.a(l.a(socket.getInputStream(), (s)a2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static a c(Socket socket) {
        return new 3(socket);
    }
}

