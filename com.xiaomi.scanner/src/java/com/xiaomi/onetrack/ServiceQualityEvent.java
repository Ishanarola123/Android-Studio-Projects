/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.xiaomi.onetrack;

import android.text.TextUtils;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.ServiceQualityEvent$1;
import java.util.Map;

public class ServiceQualityEvent {
    private String a;
    private String b;
    private Integer c;
    private String d;
    private String e;
    private Integer f;
    private Integer g;
    private String h;
    private String i;
    private Integer j;
    private Long k;
    private Long l;
    private Long m;
    private Long n;
    private Long o;
    private Long p;
    private Long q;
    private Long r;
    private String s;
    private String t;
    private Map<String, Object> u;

    private ServiceQualityEvent(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        String string2 = builder.i != null ? builder.i.getResultType() : null;
        this.i = string2;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.o = builder.o;
        this.p = builder.p;
        this.r = builder.r;
        OneTrack.NetType netType = builder.s;
        String string3 = null;
        if (netType != null) {
            string3 = builder.s.toString();
        }
        this.s = string3;
        this.n = builder.n;
        this.q = builder.q;
        this.t = builder.t;
        this.u = builder.u;
    }

    /* synthetic */ ServiceQualityEvent(Builder builder, ServiceQualityEvent$1 serviceQualityEvent$1) {
        this(builder);
    }

    public Long getDnsLookupTime() {
        return this.k;
    }

    public Long getDuration() {
        return this.q;
    }

    public String getExceptionTag() {
        return this.h;
    }

    public Map<String, Object> getExtraParams() {
        return this.u;
    }

    public Long getHandshakeTime() {
        return this.m;
    }

    public String getHost() {
        return this.b;
    }

    public String getIps() {
        return this.e;
    }

    public String getNetSdkVersion() {
        return this.t;
    }

    public String getPath() {
        return this.d;
    }

    public Integer getPort() {
        return this.c;
    }

    public Long getReceiveAllByteTime() {
        return this.p;
    }

    public Long getReceiveFirstByteTime() {
        return this.o;
    }

    public Long getRequestDataSendTime() {
        return this.n;
    }

    public String getRequestNetType() {
        return this.s;
    }

    public Long getRequestTimestamp() {
        return this.r;
    }

    public Integer getResponseCode() {
        return this.f;
    }

    public String getResultType() {
        return this.i;
    }

    public Integer getRetryCount() {
        return this.j;
    }

    public String getScheme() {
        return this.a;
    }

    public Integer getStatusCode() {
        return this.g;
    }

    public Long getTcpConnectTime() {
        return this.l;
    }

    public static final class Builder {
        private String a;
        private String b;
        private Integer c;
        private String d;
        private String e;
        private Integer f;
        private Integer g;
        private String h;
        private ResultType i;
        private Integer j;
        private Long k;
        private Long l;
        private Long m;
        private Long n;
        private Long o;
        private Long p;
        private Long q;
        private Long r;
        private OneTrack.NetType s;
        private String t;
        private Map<String, Object> u;

        public ServiceQualityEvent build() {
            return new ServiceQualityEvent(this, null);
        }

        public Builder setDnsLookupTime(Long l2) {
            this.k = l2;
            return this;
        }

        public Builder setDuration(Long l2) {
            this.q = l2;
            return this;
        }

        public Builder setExceptionTag(String string2) {
            this.h = string2;
            return this;
        }

        public Builder setExtraParams(Map<String, Object> map) {
            this.u = map;
            return this;
        }

        public Builder setHandshakeTime(Long l2) {
            this.m = l2;
            return this;
        }

        public Builder setHost(String string2) {
            this.b = string2;
            return this;
        }

        public /* varargs */ Builder setIps(String ... arrstring) {
            if (arrstring != null) {
                this.e = TextUtils.join((CharSequence)",", (Object[])arrstring);
            }
            return this;
        }

        public Builder setNetSdkVersion(String string2) {
            this.t = string2;
            return this;
        }

        public Builder setPath(String string2) {
            this.d = string2;
            return this;
        }

        public Builder setPort(Integer n2) {
            this.c = n2;
            return this;
        }

        public Builder setReceiveAllByteTime(Long l2) {
            this.p = l2;
            return this;
        }

        public Builder setReceiveFirstByteTime(Long l2) {
            this.o = l2;
            return this;
        }

        public Builder setRequestDataSendTime(Long l2) {
            this.n = l2;
            return this;
        }

        public Builder setRequestNetType(OneTrack.NetType netType) {
            this.s = netType;
            return this;
        }

        public Builder setRequestTimestamp(Long l2) {
            this.r = l2;
            return this;
        }

        public Builder setResponseCode(Integer n2) {
            this.f = n2;
            return this;
        }

        public Builder setResultType(ResultType resultType) {
            this.i = resultType;
            return this;
        }

        public Builder setRetryCount(Integer n2) {
            this.j = n2;
            return this;
        }

        public Builder setScheme(String string2) {
            this.a = string2;
            return this;
        }

        public Builder setStatusCode(Integer n2) {
            this.g = n2;
            return this;
        }

        public Builder setTcpConnectTime(Long l2) {
            this.l = l2;
            return this;
        }
    }

    public static final class ResultType
    extends Enum<ResultType> {
        public static final /* enum */ ResultType FAILED;
        public static final /* enum */ ResultType SUCCESS;
        public static final /* enum */ ResultType TIMEOUT;
        private static final /* synthetic */ ResultType[] b;
        private String a;

        static {
            SUCCESS = new ResultType("ok");
            FAILED = new ResultType("failed");
            TIMEOUT = new ResultType("timeout");
            ResultType[] arrresultType = new ResultType[]{SUCCESS, FAILED, TIMEOUT};
            b = arrresultType;
        }

        private ResultType(String string3) {
            this.a = string3;
        }

        public static ResultType valueOf(String string2) {
            return (ResultType)Enum.valueOf(ResultType.class, (String)string2);
        }

        public static ResultType[] values() {
            return (ResultType[])b.clone();
        }

        public String getResultType() {
            return this.a;
        }
    }

}

