/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package com.cprograms4future.allcprograms;

import java.util.Date;

public class b {
    private String messageText;
    private long messageTime;
    private String messageUser;

    public b() {
    }

    public b(String string, String string2) {
        this.messageText = string;
        this.messageUser = string2;
        this.messageTime = new Date().getTime();
    }

    public String getMessageText() {
        return this.messageText;
    }

    public long getMessageTime() {
        return this.messageTime;
    }

    public String getMessageUser() {
        return this.messageUser;
    }

    public void setMessageText(String string) {
        this.messageText = string;
    }

    public void setMessageTime(long l2) {
        this.messageTime = l2;
    }

    public void setMessageUser(String string) {
        this.messageUser = string;
    }
}

