/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.util.DisplayMetrics
 *  android.widget.ImageView
 */
package com.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.a.a.t;

final class u
extends BitmapDrawable {
    private static final Paint e = new Paint();
    Drawable a;
    long b;
    boolean c;
    int d = 255;
    private final boolean f;
    private final float g;
    private final t.d h;

    u(Context context, Bitmap bitmap, Drawable drawable, t.d d2, boolean bl, boolean bl2) {
        super(context.getResources(), bitmap);
        this.f = bl2;
        this.g = context.getResources().getDisplayMetrics().density;
        this.h = d2;
        boolean bl3 = d2 != t.d.a && !bl;
        if (bl3) {
            this.a = drawable;
            this.c = true;
            this.b = SystemClock.uptimeMillis();
        }
    }

    private static Path a(Point point, int n2) {
        Point point2 = new Point(n2 + point.x, point.y);
        Point point3 = new Point(point.x, n2 + point.y);
        Path path = new Path();
        path.moveTo((float)point.x, (float)point.y);
        path.lineTo((float)point2.x, (float)point2.y);
        path.lineTo((float)point3.x, (float)point3.y);
        return path;
    }

    private void a(Canvas canvas) {
        e.setColor(-1);
        canvas.drawPath(u.a(new Point(0, 0), (int)(16.0f * this.g)), e);
        e.setColor(this.h.d);
        canvas.drawPath(u.a(new Point(0, 0), (int)(15.0f * this.g)), e);
    }

    static void a(ImageView imageView, Context context, Bitmap bitmap, t.d d2, boolean bl, boolean bl2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable)drawable).stop();
        }
        u u2 = new u(context, bitmap, drawable, d2, bl, bl2);
        imageView.setImageDrawable((Drawable)u2);
    }

    static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable)imageView.getDrawable()).start();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void draw(Canvas var1_1) {
        if (!this.c) ** GOTO lbl6
        var2_2 = (float)(SystemClock.uptimeMillis() - this.b) / 200.0f;
        if (var2_2 >= 1.0f) {
            this.c = false;
            this.a = null;
lbl6: // 2 sources:
            super.draw(var1_1);
        } else {
            if (this.a != null) {
                this.a.draw(var1_1);
            }
            super.setAlpha((int)(var2_2 * (float)this.d));
            super.draw(var1_1);
            super.setAlpha(this.d);
            if (Build.VERSION.SDK_INT <= 10) {
                this.invalidateSelf();
            }
        }
        if (this.f == false) return;
        this.a(var1_1);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int n2) {
        this.d = n2;
        if (this.a != null) {
            this.a.setAlpha(n2);
        }
        super.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}

