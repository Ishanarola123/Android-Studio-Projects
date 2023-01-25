/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  com.twitter.sdk.android.tweetui.internal.VideoView
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.tweetui;

import a.a.a.a.c;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;
import com.twitter.sdk.android.tweetui.internal.f;

class g {
    final VideoView a;
    final VideoControlView b;
    final ProgressBar c;
    final TextView d;
    View e;
    int f = 0;
    boolean g = true;
    final f.a h;

    g(View view, f.a a2) {
        this.e = view;
        this.a = (VideoView)view.findViewById(h.e.video_view);
        this.b = (VideoControlView)view.findViewById(h.e.video_control_view);
        this.c = (ProgressBar)view.findViewById(h.e.video_progress_view);
        this.d = (TextView)view.findViewById(h.e.call_to_action_view);
        this.h = a2;
    }

    void a() {
        if (this.f != 0) {
            this.a.a(this.f);
        }
        if (this.g) {
            this.a.a();
            this.b.l();
        }
    }

    void a(PlayerActivity.a a2) {
        try {
            this.b(a2);
            this.a(a2.b);
            f f2 = f.a((View)this.a, this.h);
            this.a.setOnTouchListener((View.OnTouchListener)f2);
            this.a.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){

                public void onPrepared(MediaPlayer mediaPlayer) {
                    g.this.c.setVisibility(8);
                }
            });
            this.a.setOnInfoListener(new MediaPlayer.OnInfoListener(){

                public boolean onInfo(MediaPlayer mediaPlayer, int n2, int n3) {
                    if (n2 == 702) {
                        g.this.c.setVisibility(8);
                        return true;
                    }
                    if (n2 == 701) {
                        g.this.c.setVisibility(0);
                        return true;
                    }
                    return false;
                }
            });
            Uri uri = Uri.parse((String)a2.a);
            this.a.a(uri, a2.b);
            this.a.requestFocus();
            return;
        }
        catch (Exception exception) {
            c.h().d("PlayerController", "Error occurred during video playback", exception);
            return;
        }
    }

    void a(final String string) {
        this.d.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string));
                com.twitter.sdk.android.core.f.b(g.this.d.getContext(), intent);
            }
        });
    }

    void a(boolean bl) {
        if (bl) {
            this.d();
            return;
        }
        this.e();
    }

    void b() {
        this.g = this.a.c();
        this.f = this.a.getCurrentPosition();
        this.a.b();
    }

    void b(PlayerActivity.a a2) {
        if (a2.d != null && a2.c != null) {
            this.d.setVisibility(0);
            this.d.setText((CharSequence)a2.d);
            this.a(a2.c);
            this.f();
        }
    }

    void c() {
        this.a.d();
    }

    void d() {
        this.b.setVisibility(4);
        this.a.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (g.this.a.c()) {
                    g.this.a.b();
                    return;
                }
                g.this.a.a();
            }
        });
    }

    void e() {
        this.a.setMediaController(this.b);
    }

    void f() {
        this.e.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                int n2;
                TextView textView;
                if (g.this.d.getVisibility() == 0) {
                    textView = g.this.d;
                    n2 = 8;
                } else {
                    textView = g.this.d;
                    n2 = 0;
                }
                textView.setVisibility(n2);
            }
        });
    }

}

