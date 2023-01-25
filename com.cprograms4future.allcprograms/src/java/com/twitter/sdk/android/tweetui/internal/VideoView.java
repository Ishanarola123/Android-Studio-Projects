/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnBufferingUpdateListener
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.media.MediaPlayer$OnVideoSizeChangedListener
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;

public class VideoView
extends SurfaceView
implements VideoControlView.a {
    private GestureDetector A = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (VideoView.n(this.a) && VideoView.e(this.a) != null) {
                VideoView.o(this.a);
            }
            return false;
        }
    });
    MediaPlayer.OnVideoSizeChangedListener a = new MediaPlayer.OnVideoSizeChangedListener(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int n2, int n3) {
            VideoView.a(this.a, mediaPlayer.getVideoWidth());
            VideoView.b(this.a, mediaPlayer.getVideoHeight());
            if (VideoView.a(this.a) != 0 && VideoView.b(this.a) != 0) {
                this.a.getHolder().setFixedSize(VideoView.a(this.a), VideoView.b(this.a));
                this.a.requestLayout();
            }
        }
    };
    MediaPlayer.OnPreparedListener b = new MediaPlayer.OnPreparedListener(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        /*
         * Enabled aggressive block sorting
         */
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoView.c(this.a, 2);
            if (VideoView.c(this.a) != null) {
                VideoView.c(this.a).onPrepared(VideoView.d(this.a));
            }
            if (VideoView.e(this.a) != null) {
                VideoView.e(this.a).setEnabled(true);
            }
            VideoView.a(this.a, mediaPlayer.getVideoWidth());
            VideoView.b(this.a, mediaPlayer.getVideoHeight());
            int n2 = VideoView.f(this.a);
            if (n2 != 0) {
                this.a.a(n2);
            }
            if (VideoView.a(this.a) != 0 && VideoView.b(this.a) != 0) {
                this.a.getHolder().setFixedSize(VideoView.a(this.a), VideoView.b(this.a));
                if (VideoView.g(this.a) != VideoView.a(this.a) || VideoView.h(this.a) != VideoView.b(this.a)) return;
                if (VideoView.i(this.a) == 3) {
                    this.a.a();
                    if (VideoView.e(this.a) == null) return;
                } else if (this.a.c() || n2 == 0 && this.a.getCurrentPosition() <= 0 || VideoView.e(this.a) == null) return;
                VideoView.e(this.a).j();
                return;
            }
            if (VideoView.i(this.a) != 3) return;
            {
                this.a.a();
            }
        }
    };
    SurfaceHolder.Callback c = new SurfaceHolder.Callback(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int n2, int n3, int n4) {
            VideoView.f(this.a, n3);
            VideoView.g(this.a, n4);
            boolean bl = VideoView.i(this.a) == 3;
            int n5 = VideoView.a(this.a);
            boolean bl2 = false;
            if (n5 == n3) {
                int n6 = VideoView.b(this.a);
                bl2 = false;
                if (n6 == n4) {
                    bl2 = true;
                }
            }
            if (VideoView.d(this.a) != null && bl && bl2) {
                if (VideoView.f(this.a) != 0) {
                    this.a.a(VideoView.f(this.a));
                }
                this.a.a();
                if (VideoView.e(this.a) != null) {
                    VideoView.e(this.a).j();
                }
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            VideoView.a(this.a, surfaceHolder);
            VideoView.p(this.a);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            VideoView.a(this.a, null);
            if (VideoView.e(this.a) != null) {
                VideoView.e(this.a).i();
            }
            VideoView.a(this.a, true);
        }
    };
    private String d = "VideoView";
    private Uri e;
    private int f = 0;
    private int g = 0;
    private SurfaceHolder h = null;
    private MediaPlayer i = null;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private VideoControlView o;
    private MediaPlayer.OnCompletionListener p;
    private MediaPlayer.OnPreparedListener q;
    private int r;
    private MediaPlayer.OnErrorListener s;
    private MediaPlayer.OnInfoListener t;
    private int u;
    private boolean v;
    private MediaPlayer.OnCompletionListener w = new MediaPlayer.OnCompletionListener(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            VideoView.c(this.a, 5);
            VideoView.d(this.a, 5);
            if (VideoView.j(this.a) != null) {
                VideoView.j(this.a).onCompletion(VideoView.d(this.a));
            }
        }
    };
    private MediaPlayer.OnInfoListener x = new MediaPlayer.OnInfoListener(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int n2, int n3) {
            if (VideoView.k(this.a) != null) {
                VideoView.k(this.a).onInfo(mediaPlayer, n2, n3);
            }
            return true;
        }
    };
    private MediaPlayer.OnErrorListener y = new MediaPlayer.OnErrorListener(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
            String string = VideoView.l(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error: ");
            stringBuilder.append(n2);
            stringBuilder.append(",");
            stringBuilder.append(n3);
            Log.d((String)string, (String)stringBuilder.toString());
            VideoView.c(this.a, -1);
            VideoView.d(this.a, -1);
            if (VideoView.e(this.a) != null) {
                VideoView.e(this.a).i();
            }
            if (VideoView.m(this.a) == null || VideoView.m(this.a).onError(VideoView.d(this.a), n2, n3)) {
                // empty if block
            }
            return true;
        }
    };
    private MediaPlayer.OnBufferingUpdateListener z = new MediaPlayer.OnBufferingUpdateListener(this){
        final /* synthetic */ VideoView a;
        {
            this.a = videoView;
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int n2) {
            VideoView.e(this.a, n2);
        }
    };

    public VideoView(Context context) {
        super(context);
        this.e();
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.e();
    }

    static /* synthetic */ int a(VideoView videoView) {
        return videoView.k;
    }

    static /* synthetic */ int a(VideoView videoView, int n2) {
        videoView.k = n2;
        return n2;
    }

    static /* synthetic */ SurfaceHolder a(VideoView videoView, SurfaceHolder surfaceHolder) {
        videoView.h = surfaceHolder;
        return surfaceHolder;
    }

    static /* synthetic */ void a(VideoView videoView, boolean bl) {
        videoView.a(bl);
    }

    private void a(boolean bl) {
        if (this.i != null) {
            this.i.reset();
            this.i.release();
            this.i = null;
            this.f = 0;
            if (bl) {
                this.g = 0;
            }
        }
    }

    static /* synthetic */ int b(VideoView videoView) {
        return videoView.l;
    }

    static /* synthetic */ int b(VideoView videoView, int n2) {
        videoView.l = n2;
        return n2;
    }

    static /* synthetic */ int c(VideoView videoView, int n2) {
        videoView.f = n2;
        return n2;
    }

    static /* synthetic */ MediaPlayer.OnPreparedListener c(VideoView videoView) {
        return videoView.q;
    }

    static /* synthetic */ int d(VideoView videoView, int n2) {
        videoView.g = n2;
        return n2;
    }

    static /* synthetic */ MediaPlayer d(VideoView videoView) {
        return videoView.i;
    }

    static /* synthetic */ int e(VideoView videoView, int n2) {
        videoView.r = n2;
        return n2;
    }

    static /* synthetic */ VideoControlView e(VideoView videoView) {
        return videoView.o;
    }

    private void e() {
        this.k = 0;
        this.l = 0;
        this.getHolder().addCallback(this.c);
        this.getHolder().setType(3);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.setClickable(true);
        this.requestFocus();
        this.f = 0;
        this.g = 0;
    }

    static /* synthetic */ int f(VideoView videoView) {
        return videoView.u;
    }

    static /* synthetic */ int f(VideoView videoView, int n2) {
        videoView.m = n2;
        return n2;
    }

    private void f() {
        if (this.e != null) {
            if (this.h == null) {
                return;
            }
            this.a(false);
            try {
                this.i = new MediaPlayer();
                if (this.j != 0) {
                    this.i.setAudioSessionId(this.j);
                } else {
                    this.j = this.i.getAudioSessionId();
                }
                this.i.setOnPreparedListener(this.b);
                this.i.setOnVideoSizeChangedListener(this.a);
                this.i.setOnCompletionListener(this.w);
                this.i.setOnErrorListener(this.y);
                this.i.setOnInfoListener(this.x);
                this.i.setOnBufferingUpdateListener(this.z);
                this.r = 0;
                this.i.setLooping(this.v);
                this.i.setDataSource(this.getContext(), this.e);
                this.i.setDisplay(this.h);
                this.i.setAudioStreamType(3);
                this.i.setScreenOnWhilePlaying(true);
                this.i.prepareAsync();
                this.f = 1;
                this.g();
                return;
            }
            catch (Exception exception) {
                String string = this.d;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to open content: ");
                stringBuilder.append((Object)this.e);
                Log.w((String)string, (String)stringBuilder.toString(), (Throwable)exception);
                this.f = -1;
                this.g = -1;
                this.y.onError(this.i, 1, 0);
            }
        }
    }

    static /* synthetic */ int g(VideoView videoView) {
        return videoView.m;
    }

    static /* synthetic */ int g(VideoView videoView, int n2) {
        videoView.n = n2;
        return n2;
    }

    private void g() {
        if (this.i != null && this.o != null) {
            this.o.setMediaPlayer(this);
            this.o.setEnabled(this.i());
        }
    }

    static /* synthetic */ int h(VideoView videoView) {
        return videoView.n;
    }

    private void h() {
        if (this.o.k()) {
            this.o.i();
            return;
        }
        this.o.j();
    }

    static /* synthetic */ int i(VideoView videoView) {
        return videoView.g;
    }

    private boolean i() {
        return this.i != null && this.f != -1 && this.f != 0 && this.f != 1;
    }

    static /* synthetic */ MediaPlayer.OnCompletionListener j(VideoView videoView) {
        return videoView.p;
    }

    static /* synthetic */ MediaPlayer.OnInfoListener k(VideoView videoView) {
        return videoView.t;
    }

    static /* synthetic */ String l(VideoView videoView) {
        return videoView.d;
    }

    static /* synthetic */ MediaPlayer.OnErrorListener m(VideoView videoView) {
        return videoView.s;
    }

    static /* synthetic */ boolean n(VideoView videoView) {
        return videoView.i();
    }

    static /* synthetic */ void o(VideoView videoView) {
        videoView.h();
    }

    static /* synthetic */ void p(VideoView videoView) {
        videoView.f();
    }

    @Override
    public void a() {
        if (this.i()) {
            this.i.start();
            this.f = 3;
        }
        this.g = 3;
    }

    @Override
    public void a(int n2) {
        if (this.i()) {
            this.i.seekTo(n2);
            n2 = 0;
        }
        this.u = n2;
    }

    public void a(Uri uri, boolean bl) {
        this.e = uri;
        this.v = bl;
        this.u = 0;
        this.f();
        this.requestLayout();
        this.invalidate();
    }

    @Override
    public void b() {
        if (this.i() && this.i.isPlaying()) {
            this.i.pause();
            this.f = 4;
        }
        this.g = 4;
    }

    @Override
    public boolean c() {
        return this.i() && this.i.isPlaying();
    }

    public void d() {
        if (this.i != null) {
            this.i.stop();
            this.i.release();
            this.i = null;
            this.f = 0;
            this.g = 0;
        }
    }

    @Override
    public int getBufferPercentage() {
        if (this.i != null) {
            return this.r;
        }
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        if (this.i()) {
            return this.i.getCurrentPosition();
        }
        return 0;
    }

    @Override
    public int getDuration() {
        if (this.i()) {
            return this.i.getDuration();
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        boolean bl = n2 != 4 && n2 != 24 && n2 != 25 && n2 != 82 && n2 != 5 && n2 != 6;
        if (!this.i()) return super.onKeyDown(n2, keyEvent);
        if (!bl) return super.onKeyDown(n2, keyEvent);
        if (this.o == null) return super.onKeyDown(n2, keyEvent);
        if (n2 != 79 && n2 != 85) {
            if (n2 == 126) {
                if (this.i.isPlaying()) return true;
                this.a();
                this.o.i();
                return true;
            }
            if (n2 != 86 && n2 != 127) {
                this.h();
                return super.onKeyDown(n2, keyEvent);
            }
            if (!this.i.isPlaying()) return true;
            this.b();
            this.o.j();
            return true;
        }
        if (this.i.isPlaying()) {
            this.b();
            this.o.j();
            return true;
        }
        this.a();
        this.o.i();
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        block6 : {
            int n6;
            block11 : {
                int n7;
                block3 : {
                    int n8;
                    block10 : {
                        block7 : {
                            int n9;
                            int n10;
                            block9 : {
                                block8 : {
                                    block4 : {
                                        block5 : {
                                            n7 = VideoView.getDefaultSize((int)this.k, (int)n2);
                                            n6 = VideoView.getDefaultSize((int)this.l, (int)n3);
                                            if (this.k <= 0 || this.l <= 0) break block3;
                                            n10 = View.MeasureSpec.getMode((int)n2);
                                            n4 = View.MeasureSpec.getSize((int)n2);
                                            n9 = View.MeasureSpec.getMode((int)n3);
                                            n5 = View.MeasureSpec.getSize((int)n3);
                                            if (n10 != 1073741824 || n9 != 1073741824) break block4;
                                            if (n5 * this.k >= n4 * this.l) break block5;
                                            n4 = n5 * this.k / this.l;
                                            break block6;
                                        }
                                        if (n5 * this.k <= n4 * this.l) break block6;
                                        break block7;
                                    }
                                    if (n10 != 1073741824) break block8;
                                    int n11 = n4 * this.l / this.k;
                                    if (n9 != Integer.MIN_VALUE || n11 <= n5) {
                                        n5 = n11;
                                    }
                                    break block6;
                                }
                                if (n9 != 1073741824) break block9;
                                n8 = n5 * this.k / this.l;
                                if (n10 != Integer.MIN_VALUE || n8 <= n4) break block10;
                                break block6;
                            }
                            int n12 = this.k;
                            int n13 = this.l;
                            if (n9 == Integer.MIN_VALUE && n13 > n5) {
                                n8 = n5 * this.k / this.l;
                            } else {
                                n8 = n12;
                                n5 = n13;
                            }
                            if (n10 != Integer.MIN_VALUE || n8 <= n4) break block10;
                        }
                        n6 = n4 * this.l / this.k;
                        break block11;
                    }
                    n4 = n8;
                    break block6;
                }
                n4 = n7;
            }
            n5 = n6;
        }
        this.setMeasuredDimension(n4, n5);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.A.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
        {
        }
    }

    public void setMediaController(VideoControlView videoControlView) {
        if (this.o != null) {
            this.o.i();
        }
        this.o = videoControlView;
        this.g();
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.p = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.s = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.t = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.q = onPreparedListener;
    }
}

