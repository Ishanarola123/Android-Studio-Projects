/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.preference.Preference
 *  androidx.preference.PreferenceViewHolder
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  miuix.animation.Folme
 *  miuix.animation.ITouchStyle
 *  miuix.animation.ITouchStyle$TouchType
 *  miuix.animation.base.AnimConfig
 */
package miuix.preference;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import miuix.animation.Folme;
import miuix.animation.ITouchStyle;
import miuix.animation.base.AnimConfig;
import miuix.preference.R;

public class ConnectPreferenceHelper {
    public static final float BACKGROUND_ANIM_FACTOR = 1.5f;
    public static final int BACKGROUND_ANIM_TIME = 300;
    private static final int[] STATE_ATTR_CONNECTED;
    private static final int[] STATE_ATTR_DISCONNECTED;
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_DISCONNECTED = 0;
    public static final String TAG = "ConnectPreferenceHelper";
    private LayerDrawable BgDrawableParent;
    private Drawable bgDrawableConnected;
    private AnimatedVectorDrawable connectingAnimDrawable;
    private ColorStateList iconColorList;
    private Context mContext;
    private ValueAnimator mDisConnectedToConnectedBgAnim;
    private ValueAnimator mDisConnectedToConnectedIconAnim;
    private ValueAnimator mDisConnectedToConnectedSummaryAnim;
    private ValueAnimator mDisConnectedToConnectedTitleAnim;
    private boolean mIconAnimEnabled = true;
    private int mLastState = 0;
    private Preference mPreference;
    private int mState = 0;
    private TextView mSummaryView;
    private TextView mTitleView;
    private View mWidgetView;
    private ColorStateList summaryColorList;
    private ColorStateList titleColorList;

    static {
        int[] arrn = new int[]{R.attr.state_connected};
        STATE_ATTR_CONNECTED = arrn;
        int[] arrn2 = new int[]{-R.attr.state_connected};
        STATE_ATTR_DISCONNECTED = arrn2;
    }

    public ConnectPreferenceHelper(Context context, Preference preference) {
        this.mContext = context;
        this.mPreference = preference;
        this.titleColorList = ContextCompat.getColorStateList((Context)context, (int)R.color.miuix_preference_connect_title_color);
        this.summaryColorList = ContextCompat.getColorStateList((Context)context, (int)R.color.miuix_preference_connect_summary_color);
        this.iconColorList = ContextCompat.getColorStateList((Context)context, (int)R.color.miuix_preference_connect_icon_color);
        this.initAnim(context);
    }

    private void initAnim(Context context) {
        this.BgDrawableParent = (LayerDrawable)ContextCompat.getDrawable((Context)context, (int)R.drawable.miuix_preference_ic_bg_connect);
        if (this.BgDrawableParent == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.connectingAnimDrawable = (AnimatedVectorDrawable)this.BgDrawableParent.findDrawableByLayerId(R.id.anim_preference_connecting);
        this.bgDrawableConnected = this.BgDrawableParent.findDrawableByLayerId(R.id.shape_preference_connected);
        int n = this.titleColorList.getColorForState(STATE_ATTR_DISCONNECTED, R.color.miuix_preference_connect_title_disconnected_color);
        int n2 = this.titleColorList.getColorForState(STATE_ATTR_CONNECTED, R.color.miuix_preference_connect_title_connected_color);
        int n3 = this.summaryColorList.getColorForState(STATE_ATTR_DISCONNECTED, R.color.miuix_preference_connect_summary_disconnected_color);
        int n4 = this.summaryColorList.getColorForState(STATE_ATTR_CONNECTED, R.color.miuix_preference_connect_summary_connected_color);
        this.mDisConnectedToConnectedIconAnim = ValueAnimator.ofArgb((int[])new int[]{this.iconColorList.getColorForState(STATE_ATTR_DISCONNECTED, R.color.miuix_preference_connect_icon_disconnected_color), this.iconColorList.getColorForState(STATE_ATTR_CONNECTED, R.color.miuix_preference_connect_icon_connected_color)});
        this.mDisConnectedToConnectedIconAnim.setDuration(300L);
        this.mDisConnectedToConnectedIconAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Drawable drawable2 = ConnectPreferenceHelper.this.mPreference.getIcon();
                if (drawable2 != null && ConnectPreferenceHelper.this.mIconAnimEnabled) {
                    DrawableCompat.setTint((Drawable)drawable2, (int)((Integer)valueAnimator.getAnimatedValue()));
                }
            }
        });
        this.mDisConnectedToConnectedTitleAnim = ValueAnimator.ofArgb((int[])new int[]{n, n2});
        this.mDisConnectedToConnectedTitleAnim.setDuration(300L);
        this.mDisConnectedToConnectedTitleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ConnectPreferenceHelper.this.mTitleView != null) {
                    ConnectPreferenceHelper.this.mTitleView.setTextColor(((Integer)valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mDisConnectedToConnectedSummaryAnim = ValueAnimator.ofArgb((int[])new int[]{n3, n4});
        this.mDisConnectedToConnectedSummaryAnim.setDuration(300L);
        this.mDisConnectedToConnectedSummaryAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ConnectPreferenceHelper.this.mSummaryView != null) {
                    ConnectPreferenceHelper.this.mSummaryView.setTextColor(((Integer)valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mDisConnectedToConnectedBgAnim = ValueAnimator.ofInt((int[])new int[]{0, 255});
        this.mDisConnectedToConnectedBgAnim.setDuration(300L);
        this.mDisConnectedToConnectedBgAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ConnectPreferenceHelper.this.bgDrawableConnected.setAlpha(((Integer)valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mDisConnectedToConnectedBgAnim.addListener(new Animator.AnimatorListener(){

            public void onAnimationCancel(Animator animator2) {
            }

            public void onAnimationEnd(Animator animator2) {
                if (ConnectPreferenceHelper.this.connectingAnimDrawable != null && ConnectPreferenceHelper.this.connectingAnimDrawable.isRunning()) {
                    ConnectPreferenceHelper.this.connectingAnimDrawable.stop();
                }
            }

            public void onAnimationRepeat(Animator animator2) {
            }

            public void onAnimationStart(Animator animator2) {
            }
        });
    }

    private static void setAlphaFolme(View view) {
        if (view == null) {
            return;
        }
        ITouchStyle iTouchStyle = Folme.useAt((View[])new View[]{view}).touch();
        ITouchStyle.TouchType[] arrtouchType = new ITouchStyle.TouchType[]{ITouchStyle.TouchType.DOWN};
        iTouchStyle.setAlpha(0.6f, arrtouchType).handleTouchOf(view, new AnimConfig[0]);
    }

    private void startConnectedToDisConnectedAnim() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
        if (this.mDisConnectedToConnectedBgAnim.isRunning()) {
            this.mDisConnectedToConnectedBgAnim.cancel();
        }
        this.mDisConnectedToConnectedBgAnim.setInterpolator((TimeInterpolator)accelerateInterpolator);
        this.mDisConnectedToConnectedBgAnim.reverse();
        if (this.mDisConnectedToConnectedTitleAnim.isRunning()) {
            this.mDisConnectedToConnectedTitleAnim.cancel();
        }
        this.mDisConnectedToConnectedTitleAnim.setInterpolator((TimeInterpolator)accelerateInterpolator);
        this.mDisConnectedToConnectedTitleAnim.reverse();
        if (this.mDisConnectedToConnectedSummaryAnim.isRunning()) {
            this.mDisConnectedToConnectedSummaryAnim.cancel();
        }
        this.mDisConnectedToConnectedSummaryAnim.setInterpolator((TimeInterpolator)accelerateInterpolator);
        this.mDisConnectedToConnectedSummaryAnim.reverse();
        if (this.mDisConnectedToConnectedIconAnim.isRunning()) {
            this.mDisConnectedToConnectedIconAnim.cancel();
        }
        this.mDisConnectedToConnectedIconAnim.setInterpolator((TimeInterpolator)accelerateInterpolator);
        this.mDisConnectedToConnectedIconAnim.reverse();
    }

    private void startDisConnectedToConnectedAnim() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(1.5f);
        if (this.mDisConnectedToConnectedBgAnim.isRunning()) {
            this.mDisConnectedToConnectedBgAnim.cancel();
        }
        this.mDisConnectedToConnectedBgAnim.setInterpolator((TimeInterpolator)decelerateInterpolator);
        this.mDisConnectedToConnectedBgAnim.start();
        if (this.mDisConnectedToConnectedTitleAnim.isRunning()) {
            this.mDisConnectedToConnectedTitleAnim.cancel();
        }
        this.mDisConnectedToConnectedTitleAnim.setInterpolator((TimeInterpolator)decelerateInterpolator);
        this.mDisConnectedToConnectedTitleAnim.start();
        if (this.mDisConnectedToConnectedSummaryAnim.isRunning()) {
            this.mDisConnectedToConnectedSummaryAnim.cancel();
        }
        this.mDisConnectedToConnectedSummaryAnim.setInterpolator((TimeInterpolator)decelerateInterpolator);
        this.mDisConnectedToConnectedSummaryAnim.start();
        if (this.mDisConnectedToConnectedIconAnim.isRunning()) {
            this.mDisConnectedToConnectedIconAnim.cancel();
        }
        this.mDisConnectedToConnectedIconAnim.setInterpolator((TimeInterpolator)decelerateInterpolator);
        this.mDisConnectedToConnectedIconAnim.start();
    }

    private void updateState(boolean bl) {
        int n = this.mState;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    return;
                }
                this.updateStateConnecting(bl);
                return;
            }
            this.updateStateConnected(bl);
            return;
        }
        this.updateStateDisconnected(bl);
    }

    private void updateStateConnected(boolean bl) {
        if (bl) {
            this.startDisConnectedToConnectedAnim();
        } else {
            this.bgDrawableConnected.setAlpha(255);
            this.updateViewColorList(STATE_ATTR_CONNECTED);
        }
        this.updateWidgetDrawable(STATE_ATTR_CONNECTED);
    }

    private void updateStateConnecting(boolean bl) {
        this.bgDrawableConnected.setAlpha(0);
        AnimatedVectorDrawable animatedVectorDrawable = this.connectingAnimDrawable;
        if (animatedVectorDrawable != null) {
            animatedVectorDrawable.setAlpha(255);
            if (!this.connectingAnimDrawable.isRunning()) {
                this.connectingAnimDrawable.start();
            }
        }
        if (!bl) {
            this.updateViewColorList(STATE_ATTR_DISCONNECTED);
        }
        this.updateWidgetDrawable(STATE_ATTR_DISCONNECTED);
    }

    private void updateStateDisconnected(boolean bl) {
        if (bl) {
            AnimatedVectorDrawable animatedVectorDrawable;
            int n = this.mLastState;
            if (n == 1) {
                this.startConnectedToDisConnectedAnim();
            } else if (n == 2 && (animatedVectorDrawable = this.connectingAnimDrawable) != null && animatedVectorDrawable.isRunning()) {
                this.connectingAnimDrawable.stop();
            }
        } else {
            this.bgDrawableConnected.setAlpha(0);
            this.updateViewColorList(STATE_ATTR_DISCONNECTED);
        }
        AnimatedVectorDrawable animatedVectorDrawable = this.connectingAnimDrawable;
        if (animatedVectorDrawable != null) {
            animatedVectorDrawable.setAlpha(0);
        }
        this.updateWidgetDrawable(STATE_ATTR_DISCONNECTED);
    }

    private void updateViewColorList(int[] arrn) {
        TextView textView;
        TextView textView2;
        Drawable drawable2 = this.mPreference.getIcon();
        if (drawable2 != null && this.mIconAnimEnabled) {
            DrawableCompat.setTint((Drawable)drawable2, (int)this.iconColorList.getColorForState(arrn, R.color.miuix_preference_connect_icon_disconnected_color));
        }
        if ((textView2 = this.mTitleView) != null) {
            textView2.setTextColor(this.titleColorList.getColorForState(arrn, R.color.miuix_preference_connect_title_disconnected_color));
        }
        if ((textView = this.mSummaryView) != null) {
            textView.setTextColor(this.summaryColorList.getColorForState(arrn, R.color.miuix_preference_connect_summary_disconnected_color));
        }
    }

    private void updateWidgetDrawable(int[] arrn) {
        View view = this.mWidgetView;
        if (view instanceof ImageView) {
            if (arrn == STATE_ATTR_CONNECTED) {
                ((ImageView)view).setImageDrawable(ContextCompat.getDrawable((Context)this.mContext, (int)R.drawable.miuix_preference_ic_detail_connected));
                return;
            }
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.connectDetailDisconnectedDrawable, typedValue, true);
            ((ImageView)this.mWidgetView).setImageDrawable(ContextCompat.getDrawable((Context)this.mContext, (int)typedValue.resourceId));
        }
    }

    public int getConnectState() {
        return this.mState;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder, View view) {
        if (view != null) {
            if (preferenceViewHolder == null) {
                return;
            }
            view.setBackground((Drawable)this.BgDrawableParent);
            preferenceViewHolder.itemView.setBackground(null);
            this.mTitleView = (TextView)preferenceViewHolder.findViewById(16908310);
            this.mSummaryView = (TextView)preferenceViewHolder.findViewById(16908304);
            this.mWidgetView = preferenceViewHolder.findViewById(R.id.preference_detail);
            ConnectPreferenceHelper.setAlphaFolme(this.mWidgetView);
            this.updateState(false);
        }
    }

    public void setConnectState(int n) {
        this.mLastState = this.mState;
        this.mState = n;
        this.updateState(true);
    }

    public void setIconAnimEnabled(boolean bl) {
        this.mIconAnimEnabled = bl;
    }

}

