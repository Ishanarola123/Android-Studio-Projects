/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.rubensousa.raiflatbutton;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.github.rubensousa.raiflatbutton.a;

class b {
    private View a;
    private StateListAnimator b;
    private StateListAnimator c;
    private boolean d;

    public b(View view) {
        this.a = view;
    }

    @TargetApi(value=21)
    private void a() {
        this.b = new StateListAnimator();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this, (String)"elevation", (float[])new float[]{0.0f}).setDuration((long)this.a.getContext().getResources().getInteger(17694720));
        float[] arrf = new float[]{this.a.getElevation() + this.a.getTranslationZ()};
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)this, (String)"elevation", (float[])arrf).setDuration((long)this.a.getContext().getResources().getInteger(17694720));
        objectAnimator2.setStartDelay(100L);
        this.b.addState(new int[]{16842919, 16842910}, (Animator)objectAnimator);
        this.b.addState(new int[]{16842910}, (Animator)objectAnimator2);
        this.b.addState(new int[0], (Animator)ObjectAnimator.ofFloat((Object)this, (String)"elevation", (float[])new float[]{0.0f}).setDuration(0L));
        this.a.setStateListAnimator(this.b);
    }

    public Parcelable a(Parcelable parcelable) {
        new a((Parcelable)parcelable).a = this.d;
        return parcelable;
    }

    @TargetApi(value=21)
    public void a(boolean bl) {
        this.d = bl;
        if (this.a.getElevation() == 0.0f) {
            this.a.setElevation((float)this.a.getContext().getResources().getDimensionPixelSize(a.a.button_elevation));
        }
        this.c = this.a.getStateListAnimator();
        if (bl) {
            this.a();
        }
    }

    public Parcelable b(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            return parcelable;
        }
        a a2 = (a)parcelable;
        this.d = a2.a;
        return a2.getSuperState();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(boolean bl) {
        block3 : {
            View view;
            StateListAnimator stateListAnimator;
            block4 : {
                block2 : {
                    this.d = bl;
                    if (!this.d) break block2;
                    if (Build.VERSION.SDK_INT < 21) break block3;
                    view = this.a;
                    stateListAnimator = this.b;
                    break block4;
                }
                this.a.setPressed(false);
                if (Build.VERSION.SDK_INT < 21) break block3;
                view = this.a;
                stateListAnimator = this.c;
            }
            view.setStateListAnimator(stateListAnimator);
            return;
        }
    }

    public static class a
    extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

            public a a(Parcel parcel) {
                return new a(parcel);
            }

            public a[] a(int n2) {
                return new a[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        public boolean a;

        public a(Parcel parcel) {
            super(parcel);
            byte by = parcel.readByte();
            byte by2 = 1;
            if (by != by2) {
                by2 = 0;
            }
            this.a = by2;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeByte((byte)(this.a ? 1 : 0));
        }

    }

}

