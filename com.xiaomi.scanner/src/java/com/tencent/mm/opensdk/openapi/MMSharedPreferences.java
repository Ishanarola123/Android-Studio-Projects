/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.database.Cursor
 *  android.net.Uri
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences
implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";
    private final String[] columns = new String[]{"_id", "key", "type", "value"};
    private final ContentResolver cr;
    private REditor editor = null;
    private final HashMap<String, Object> values = new HashMap();

    public MMSharedPreferences(Context context) {
        this.cr = context.getContentResolver();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object getValue(String string2) {
        try {
            Cursor cursor = this.cr.query(c.b.CONTENT_URI, this.columns, "key = ?", new String[]{string2}, null);
            if (cursor == null) {
                return null;
            }
            int n2 = cursor.getColumnIndex("type");
            int n3 = cursor.getColumnIndex("value");
            Object object = cursor.moveToFirst() ? c.a.a(cursor.getInt(n2), cursor.getString(n3)) : null;
            cursor.close();
            return object;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("getValue exception:");
            stringBuilder.append(exception.getMessage());
            Log.e(TAG, stringBuilder.toString());
            return null;
        }
    }

    public boolean contains(String string2) {
        return this.getValue(string2) != null;
    }

    public SharedPreferences.Editor edit() {
        if (this.editor == null) {
            this.editor = new REditor(this.cr);
        }
        return this.editor;
    }

    public Map<String, ?> getAll() {
        Cursor cursor;
        block4 : {
            cursor = this.cr.query(c.b.CONTENT_URI, this.columns, null, null, null);
            if (cursor != null) break block4;
            return null;
        }
        try {
            int n2 = cursor.getColumnIndex("key");
            int n3 = cursor.getColumnIndex("type");
            int n4 = cursor.getColumnIndex("value");
            while (cursor.moveToNext()) {
                Object object = c.a.a(cursor.getInt(n3), cursor.getString(n4));
                this.values.put((Object)cursor.getString(n2), object);
            }
            cursor.close();
            HashMap<String, Object> hashMap = this.values;
            return hashMap;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("getAll exception:");
            stringBuilder.append(exception.getMessage());
            Log.e(TAG, stringBuilder.toString());
            return this.values;
        }
    }

    public boolean getBoolean(String string2, boolean bl) {
        Object object = this.getValue(string2);
        if (object != null && object instanceof Boolean) {
            return (Boolean)object;
        }
        return bl;
    }

    public float getFloat(String string2, float f2) {
        Object object = this.getValue(string2);
        if (object != null && object instanceof Float) {
            return ((Float)object).floatValue();
        }
        return f2;
    }

    public int getInt(String string2, int n2) {
        Object object = this.getValue(string2);
        if (object != null && object instanceof Integer) {
            return (Integer)object;
        }
        return n2;
    }

    public long getLong(String string2, long l2) {
        Object object = this.getValue(string2);
        if (object != null && object instanceof Long) {
            return (Long)object;
        }
        return l2;
    }

    public String getString(String string2, String string3) {
        Object object = this.getValue(string2);
        if (object != null && object instanceof String) {
            return (String)object;
        }
        return string3;
    }

    public Set<String> getStringSet(String string2, Set<String> set) {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    private static class REditor
    implements SharedPreferences.Editor {
        private boolean clear = false;
        private ContentResolver cr;
        private Set<String> remove = new HashSet();
        private Map<String, Object> values = new HashMap();

        public REditor(ContentResolver contentResolver) {
            this.cr = contentResolver;
        }

        public void apply() {
        }

        public SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean commit() {
            var1_1 = new ContentValues();
            if (this.clear) {
                this.cr.delete(c.b.CONTENT_URI, null, null);
                this.clear = false;
            }
            for (String var15_3 : this.remove) {
                this.cr.delete(c.b.CONTENT_URI, "key = ?", new String[]{var15_3});
            }
            var3_4 = this.values.entrySet().iterator();
            while (var3_4.hasNext() != false) {
                block17 : {
                    var4_5 = (Map.Entry)var3_4.next();
                    var5_6 = var4_5.getValue();
                    if (var5_6 != null) break block17;
                    var8_8 = "unresolve failed, null value";
                    ** GOTO lbl37
                }
                if (var5_6 instanceof Integer) {
                    var9_9 = 1;
                } else if (var5_6 instanceof Long) {
                    var9_9 = 2;
                } else if (var5_6 instanceof String) {
                    var9_9 = 3;
                } else if (var5_6 instanceof Boolean) {
                    var9_9 = 4;
                } else if (var5_6 instanceof Float) {
                    var9_9 = 5;
                } else if (var5_6 instanceof Double) {
                    var9_9 = 6;
                } else {
                    var6_7 = new StringBuilder("unresolve failed, unknown type=");
                    var6_7.append(var5_6.getClass().toString());
                    var8_8 = var6_7.toString();
lbl37: // 2 sources:
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", var8_8);
                    var9_9 = 0;
                }
                if (var9_9 == 0) {
                    var10_10 = false;
                } else {
                    var1_1.put("type", Integer.valueOf((int)var9_9));
                    var1_1.put("value", var5_6.toString());
                    var10_10 = true;
                }
                if (!var10_10) continue;
                var11_11 = this.cr;
                var12_12 = c.b.CONTENT_URI;
                var13_13 = new String[]{(String)var4_5.getKey()};
                var11_11.update(var12_12, var1_1, "key = ?", var13_13);
            }
            return true;
        }

        public SharedPreferences.Editor putBoolean(String string2, boolean bl) {
            this.values.put((Object)string2, (Object)bl);
            this.remove.remove((Object)string2);
            return this;
        }

        public SharedPreferences.Editor putFloat(String string2, float f2) {
            this.values.put((Object)string2, (Object)Float.valueOf((float)f2));
            this.remove.remove((Object)string2);
            return this;
        }

        public SharedPreferences.Editor putInt(String string2, int n2) {
            this.values.put((Object)string2, (Object)n2);
            this.remove.remove((Object)string2);
            return this;
        }

        public SharedPreferences.Editor putLong(String string2, long l2) {
            this.values.put((Object)string2, (Object)l2);
            this.remove.remove((Object)string2);
            return this;
        }

        public SharedPreferences.Editor putString(String string2, String string3) {
            this.values.put((Object)string2, (Object)string3);
            this.remove.remove((Object)string2);
            return this;
        }

        public SharedPreferences.Editor putStringSet(String string2, Set<String> set) {
            return null;
        }

        public SharedPreferences.Editor remove(String string2) {
            this.remove.add((Object)string2);
            return this;
        }
    }

}

