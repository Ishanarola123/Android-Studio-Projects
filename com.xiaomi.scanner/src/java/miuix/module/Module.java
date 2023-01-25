/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package miuix.module;

public class Module {
    public static final int CONTENT_DEFAULT = 0;
    public static final int CONTENT_DEX = 1;
    public static final int CONTENT_LIB = 2;
    public static final int CONTENT_NONE = 0;
    public static final int CONTENT_RES = 4;
    private int content;
    private int level;
    private String name;

    public int getContent() {
        return this.content;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public void setContent(int n) {
        this.content = n;
    }

    public void setLevel(int n) {
        this.level = n;
    }

    public void setName(String string2) {
        this.name = string2;
    }
}

