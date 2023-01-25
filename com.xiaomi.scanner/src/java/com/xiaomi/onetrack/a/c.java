/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.StringWriter
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.onetrack.a;

import android.content.Context;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.a.a;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.f.b;
import com.xiaomi.onetrack.h.f;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.w;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static final String a = "B";
    public static final String b = "H";
    private static final String c = "EventDataBuilder";

    public static String a(long l2, String string2, long l3, long l4, Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b, (Object)b.a("onetrack_upgrade", configuration, iEventHook));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("last_ver_code", l2);
        jSONObject2.put("last_ver_name", (Object)string2);
        jSONObject2.put("cur_ver_code", l3);
        jSONObject2.put("last_upgrade_time", l4);
        jSONObject.put(a, (Object)jSONObject2);
        return jSONObject.toString();
    }

    public static String a(Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b, (Object)b.a("onetrack_cta_status", configuration, iEventHook));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("value", g.b());
        jSONObject.put(a, (Object)jSONObject2);
        return jSONObject.toString();
    }

    public static String a(Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(b, (Object)b.a("onetrack_dau", configuration, iEventHook));
        JSONObject jSONObject3 = new JSONObject();
        Context context = com.xiaomi.onetrack.f.a.a();
        boolean bl = w.s();
        if (bl) {
            w.c(false);
        }
        jSONObject3.put("first_open", bl);
        boolean bl2 = p.a() ? p.A() : configuration.isInternational();
        if (!bl2) {
            if (configuration.isIMEIEnable()) {
                jSONObject3.put("imeis", f.q(context));
            }
            if (configuration.isIMSIEnable()) {
                jSONObject3.put("imsis", (Object)f.v(context));
            }
        }
        jSONObject3.put("config_status", a.a(configuration));
        jSONObject2.put(a, (Object)q.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(ServiceQualityEvent serviceQualityEvent, Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b, (Object)b.a("ot_service_quality", configuration, iEventHook));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("scheme", (Object)serviceQualityEvent.getScheme());
        jSONObject2.put("host", (Object)serviceQualityEvent.getHost());
        jSONObject2.put("port", (Object)serviceQualityEvent.getPort());
        jSONObject2.put("path", (Object)serviceQualityEvent.getPath());
        jSONObject2.put("ips", (Object)serviceQualityEvent.getIps());
        jSONObject2.put("response", (Object)serviceQualityEvent.getResponseCode());
        jSONObject2.put("status", (Object)serviceQualityEvent.getStatusCode());
        jSONObject2.put("exception", (Object)serviceQualityEvent.getExceptionTag());
        jSONObject2.put("result", (Object)serviceQualityEvent.getResultType());
        jSONObject2.put("retry", (Object)serviceQualityEvent.getRetryCount());
        jSONObject2.put("req_ts", (Object)serviceQualityEvent.getRequestTimestamp());
        jSONObject2.put("req_net", (Object)serviceQualityEvent.getRequestNetType());
        jSONObject2.put("dns", (Object)serviceQualityEvent.getDnsLookupTime());
        jSONObject2.put("tcp_connect", (Object)serviceQualityEvent.getTcpConnectTime());
        jSONObject2.put("handshake", (Object)serviceQualityEvent.getHandshakeTime());
        jSONObject2.put("res_first_byte", (Object)serviceQualityEvent.getReceiveFirstByteTime());
        jSONObject2.put("res_all_byte", (Object)serviceQualityEvent.getReceiveAllByteTime());
        jSONObject2.put("req_data_send", (Object)serviceQualityEvent.getRequestDataSendTime());
        jSONObject2.put("duration", (Object)serviceQualityEvent.getDuration());
        jSONObject2.put("net_sdk_ver", (Object)serviceQualityEvent.getNetSdkVersion());
        Map<String, Object> map = serviceQualityEvent.getExtraParams();
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                String string2 = (String)entry.getKey();
                Object object = entry.getValue();
                if (!q.b(object)) continue;
                jSONObject2.put(string2, object);
            }
        }
        jSONObject.put(a, (Object)jSONObject2);
        return jSONObject.toString();
    }

    public static String a(String string2, String string3, long l2, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(b, (Object)b.a(string3, configuration, iEventHook));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("class", (Object)string2);
        jSONObject3.put("type", 2);
        jSONObject3.put("duration", l2);
        jSONObject2.put(a, (Object)q.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String string2, String string3, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject, boolean bl) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(b, (Object)b.a(string3, configuration, iEventHook));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("class", (Object)string2);
        jSONObject3.put("type", 1);
        jSONObject3.put("app_start", bl);
        jSONObject2.put(a, (Object)q.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String string2, String string3, String string4, String string5, String string6, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = b.a("onetrack_bug_report", configuration, iEventHook);
        if (string6 != null) {
            jSONObject3.put(b.b.o, (Object)string6);
        }
        jSONObject2.put(b, (Object)jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        new StringWriter().toString();
        jSONObject4.put("exception", (Object)string2);
        jSONObject4.put("type", (Object)string4);
        jSONObject4.put("message", (Object)string3);
        jSONObject4.put("feature", (Object)string5);
        jSONObject2.put(a, (Object)q.a(jSONObject4, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String string2, String string3, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, (Object)b.a(string3, configuration, iEventHook, string2));
        jSONObject3.put(a, (Object)q.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(String string2, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, (Object)b.a(string2, configuration, iEventHook));
        jSONObject3.put(a, (Object)q.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, (Object)b.a("ot_profile_set", configuration, iEventHook));
        jSONObject3.put(a, (Object)q.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String b(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, (Object)b.a("ot_profile_increment", configuration, iEventHook));
        jSONObject3.put(a, (Object)q.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String c(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, (Object)b.a("ot_login", configuration, iEventHook));
        jSONObject3.put(a, (Object)q.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String d(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, (Object)b.a("ot_logout", configuration, iEventHook));
        jSONObject3.put(a, (Object)q.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }
}

