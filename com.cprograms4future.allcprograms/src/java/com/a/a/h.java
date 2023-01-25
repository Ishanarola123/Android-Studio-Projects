/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.widget.ImageView
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package com.a.a;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.a.a.e;
import com.a.a.x;
import java.lang.ref.WeakReference;

class h
implements ViewTreeObserver.OnPreDrawListener {
    final x a;
    final WeakReference<ImageView> b;
    e c;

    h(x x2, ImageView imageView, e e2) {
        this.a = x2;
        this.b = new WeakReference((Object)imageView);
        this.c = e2;
        imageView.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }

    void a() {
        this.c = null;
        ImageView imageView = (ImageView)this.b.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView)this.b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int n2 = imageView.getWidth();
        int n3 = imageView.getHeight();
        if (n2 > 0) {
            if (n3 <= 0) {
                return true;
            }
            viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
            this.a.b().a(n2, n3).a(imageView, this.c);
        }
        return true;
    }
}

