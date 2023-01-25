/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tencent.mm.opensdk.diffdev.a;

public final class g
extends Enum<g> {
    public static final /* enum */ g A;
    public static final /* enum */ g B;
    public static final /* enum */ g C;
    private static final /* synthetic */ g[] D;
    public static final /* enum */ g x;
    public static final /* enum */ g y;
    public static final /* enum */ g z;
    private int code;

    static {
        x = new g(402);
        y = new g(403);
        z = new g(404);
        A = new g(405);
        B = new g(408);
        C = new g(500);
        g[] arrg = new g[]{x, y, z, A, B, C};
        D = arrg;
    }

    private g(int n3) {
        this.code = n3;
    }

    public static g valueOf(String string2) {
        return (g)Enum.valueOf(g.class, (String)string2);
    }

    public static g[] values() {
        return (g[])D.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UUIDStatusCode:");
        stringBuilder.append(this.code);
        return stringBuilder.toString();
    }
}

