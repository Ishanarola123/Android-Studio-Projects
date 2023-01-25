/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package miuix.module;

public class Dependency {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_INSTALLED = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OPTIONAL = 1;
    private Level level;
    private String name;
    private int type;

    public Level getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setType(int n) {
        this.type = n;
    }

    public static class Level {
        private int maxLevel;
        private int minLevel;
        private int targetLevel;

        public int getMaxLevel() {
            return this.maxLevel;
        }

        public int getMinLevel() {
            return this.minLevel;
        }

        public int getTargetLevel() {
            return this.targetLevel;
        }

        public void setMaxLevel(int n) {
            this.maxLevel = n;
        }

        public void setMinLevel(int n) {
            this.minLevel = n;
        }

        public void setTargetLevel(int n) {
            this.targetLevel = n;
        }
    }

}

