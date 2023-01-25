/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Message
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.twitter.sdk.android.tweetui.h;
import com.twitter.sdk.android.tweetui.internal.c;

public class VideoControlView
extends FrameLayout {
    a a;
    ImageButton b;
    TextView c;
    TextView d;
    SeekBar e;
    @SuppressLint(value={"HandlerLeak"})
    private final Handler f = new Handler(){

        public void handleMessage(Message message) {
            if (message.what == 1001) {
                if (VideoControlView.this.a == null) {
                    return;
                }
                VideoControlView.this.d();
                VideoControlView.this.e();
                if (VideoControlView.this.k() && VideoControlView.this.a.c()) {
                    this.sendMessageDelayed(this.obtainMessage(1001), 500L);
                }
            }
        }
    };

    public VideoControlView(Context context) {
        super(context);
    }

    public VideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoControlView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    void a() {
        ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(h.f.tw__video_control, (ViewGroup)this);
        this.b = (ImageButton)this.findViewById(h.e.tw__state_control);
        this.c = (TextView)this.findViewById(h.e.tw__current_time);
        this.d = (TextView)this.findViewById(h.e.tw__duration);
        this.e = (SeekBar)this.findViewById(h.e.tw__progress);
        this.e.setMax(1000);
        this.e.setOnSeekBarChangeListener(this.c());
        this.b.setOnClickListener(this.b());
        this.setDuration(0);
        this.setCurrentTime(0);
        this.a(0, 0, 0);
    }

    void a(int n2, int n3, int n4) {
        long l2 = n3 > 0 ? 1000L * (long)n2 / (long)n3 : 0L;
        this.e.setProgress((int)l2);
        this.e.setSecondaryProgress(n4 * 10);
    }

    View.OnClickListener b() {
        return new View.OnClickListener(){

            public void onClick(View view) {
                if (VideoControlView.this.a.c()) {
                    VideoControlView.this.a.b();
                } else {
                    VideoControlView.this.a.a();
                }
                VideoControlView.this.j();
            }
        };
    }

    SeekBar.OnSeekBarChangeListener c() {
        return new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                if (!bl) {
                    return;
                }
                long l2 = (long)(n2 * VideoControlView.this.a.getDuration()) / 1000L;
                a a2 = VideoControlView.this.a;
                int n3 = (int)l2;
                a2.a(n3);
                VideoControlView.this.setCurrentTime(n3);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.f.removeMessages(1001);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.f.sendEmptyMessage(1001);
            }
        };
    }

    void d() {
        int n2 = this.a.getDuration();
        int n3 = this.a.getCurrentPosition();
        int n4 = this.a.getBufferPercentage();
        this.setDuration(n2);
        this.setCurrentTime(n3);
        this.a(n3, n2, n4);
    }

    void e() {
        if (this.a.c()) {
            this.g();
            return;
        }
        if (this.a.getCurrentPosition() > Math.max((int)(-500 + this.a.getDuration()), (int)0)) {
            this.h();
            return;
        }
        this.f();
    }

    void f() {
        this.b.setImageResource(h.d.tw__video_play_btn);
        this.b.setContentDescription((CharSequence)this.getContext().getString(h.g.tw__play));
    }

    void g() {
        this.b.setImageResource(h.d.tw__video_pause_btn);
        this.b.setContentDescription((CharSequence)this.getContext().getString(h.g.tw__pause));
    }

    void h() {
        this.b.setImageResource(h.d.tw__video_replay_btn);
        this.b.setContentDescription((CharSequence)this.getContext().getString(h.g.tw__replay));
    }

    void i() {
        this.f.removeMessages(1001);
        com.twitter.sdk.android.tweetui.internal.a.a((View)this, 150);
    }

    void j() {
        this.f.sendEmptyMessage(1001);
        com.twitter.sdk.android.tweetui.internal.a.b((View)this, 150);
    }

    public boolean k() {
        return this.getVisibility() == 0;
    }

    public void l() {
        this.f.sendEmptyMessage(1001);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a();
    }

    void setCurrentTime(int n2) {
        this.c.setText((CharSequence)c.a(n2));
    }

    void setDuration(int n2) {
        this.d.setText((CharSequence)c.a(n2));
    }

    public void setMediaPlayer(a a2) {
        this.a = a2;
    }

    public static interface a {
        public void a();

        public void a(int var1);

        public void b();

        public boolean c();

        public int getBufferPercentage();

        public int getCurrentPosition();

        public int getDuration();
    }

}

