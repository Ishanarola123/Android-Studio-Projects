/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.xiaomi.scanner.app.AppUI
 *  com.xiaomi.scanner.app.ScanActivity
 *  com.xiaomi.scanner.debug.Log
 *  com.xiaomi.scanner.debug.Log$Tag
 *  com.xiaomi.scanner.module.CodeModule
 *  com.xiaomi.scanner.module.code.ui.QRCodeFgView
 *  com.xiaomi.scanner.util.AppUtil
 *  com.xiaomi.scanner.util.Util
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.xiaomi.scanner.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.scanner.app.AppUI;
import com.xiaomi.scanner.app.ScanActivity;
import com.xiaomi.scanner.config.ConfigModel;
import com.xiaomi.scanner.debug.Log;
import com.xiaomi.scanner.module.CodeModule;
import com.xiaomi.scanner.module.code.ui.QRCodeFgView;
import com.xiaomi.scanner.util.AppUtil;
import com.xiaomi.scanner.util.Util;

public class CodeModuleUI {
    private static final String REQUEST_EXTRA_SUBTITLE = "subTitle";
    private static final String REQUEST_EXTRA_SUBTITLE_LINK = "subTitleLink";
    private static final String REQUEST_EXTRA_SUBTITLE_LINK_ACTION = "subTitleLinkAction";
    private static final String REQUEST_EXTRA_TITLE = "title";
    private static final Log.Tag TAG = new Log.Tag("CodeModuleUI");
    private final ScanActivity mActivity;
    private final View mAppRoot;
    private AppUI mAppUI;
    private final CodeModule mController;
    private Rect mFrameRectInPreview;
    private Rect mFramingRect;
    private final ViewGroup mModuleRoot;
    private QRCodeFgView mQRFgView;
    private TextView tipView;

    public CodeModuleUI(ScanActivity scanActivity, CodeModule codeModule, View view, String string) {
        this.mActivity = scanActivity;
        this.mController = codeModule;
        this.mAppRoot = view;
        this.mAppUI = this.mActivity.getAppUI();
        this.mModuleRoot = (ViewGroup)this.mAppRoot.findViewById(2131362048);
        this.mActivity.getLayoutInflater().inflate(2131558434, this.mModuleRoot, true);
        this.mQRFgView = (QRCodeFgView)this.mModuleRoot.findViewById(2131362093);
        this.mQRFgView.setScannerFrame(this.getFramingRect());
        if (!this.mController.isPause() && AppUtil.isUserAgreeToRun()) {
            this.mQRFgView.startLaserAnim();
        }
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.showThirdAppUI();
        }
        this.tipView = (TextView)this.mModuleRoot.findViewById(2131362239);
        ((FrameLayout.LayoutParams)this.tipView.getLayoutParams()).topMargin = this.getFramingRect().bottom + scanActivity.getResources().getDimensionPixelSize(2131165348);
    }

    public Rect getFramingRect() {
        if (this.mFramingRect == null) {
            Resources resources = this.mActivity.getResources();
            int n = (int)resources.getDimension(2131165347);
            int n2 = (int)resources.getDimension(2131165345);
            int n3 = this.mModuleRoot.getWidth() == 0 ? Math.min((int)Util.screenWidth, (int)Util.screenHeight) : this.mModuleRoot.getWidth();
            int n4 = (n3 - n) / 2;
            int n5 = resources.getDimensionPixelSize(2131165346);
            this.mFramingRect = new Rect(n4, n5, n + n4, n2 + n5);
        }
        Log.Tag tag = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("framingRect: ");
        stringBuilder.append((Object)this.mFramingRect);
        Log.v((Log.Tag)tag, (String)stringBuilder.toString());
        return this.mFramingRect;
    }

    public Rect getFramingRectInPreview(int n, int n2, int n3) {
        if (this.mFrameRectInPreview == null) {
            float f;
            int n4;
            Rect rect = new Rect(this.mQRFgView.getRect());
            if (n3 != 90 && n3 != 270) {
                f = 1.0f * (float)n;
                n4 = this.mAppUI.getPreviewWidth();
            } else {
                f = 1.0f * (float)n2;
                n4 = this.mAppUI.getPreviewWidth();
            }
            float f2 = f / (float)n4;
            rect.left = (int)(f2 * (float)rect.left);
            rect.right = (int)(f2 * (float)rect.right);
            rect.top = (int)(f2 * (float)rect.top);
            rect.bottom = (int)(f2 * (float)rect.bottom);
            int n5 = Math.min((int)rect.left, (int)rect.top) / 3;
            if ((float)(n5 + rect.bottom) < f2 * (float)this.mAppUI.getPreviewHeight() && (float)(n5 + rect.right) < f2 * (float)this.mAppUI.getPreviewWidth()) {
                rect.left -= n5;
                rect.top -= n5;
                rect.right = n5 + rect.right;
                rect.bottom = n5 + rect.bottom;
            }
            this.mFrameRectInPreview = rect;
            Log.Tag tag = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("framingRectInPreview: ");
            stringBuilder.append((Object)this.mFrameRectInPreview);
            Log.v((Log.Tag)tag, (String)stringBuilder.toString());
        }
        return this.mFrameRectInPreview;
    }

    public void onDestroy() {
        this.mQRFgView.clear();
    }

    public void onPause() {
        QRCodeFgView qRCodeFgView = this.mQRFgView;
        if (qRCodeFgView != null) {
            qRCodeFgView.stopLaserAnim();
        }
    }

    public void onResume() {
        QRCodeFgView qRCodeFgView = this.mQRFgView;
        if (qRCodeFgView != null && this.mFramingRect != null) {
            qRCodeFgView.startLaserAnim();
        } else {
            Log.Tag tag = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("drop this start operation, mFramingRect=");
            stringBuilder.append((Object)this.mFramingRect);
            Log.v((Log.Tag)tag, (String)stringBuilder.toString());
        }
        this.tipView.setText(2131755405);
        this.setTipView();
    }

    public void setTipView() {
        if (this.mActivity != null && this.tipView != null && !TextUtils.isEmpty((CharSequence)ConfigModel.instance.getQrScanTip(this.mActivity))) {
            this.tipView.setText((CharSequence)ConfigModel.instance.getQrScanTip(this.mActivity));
        }
    }

    public void showThirdAppUI() {
        Intent intent = this.mActivity.getIntent();
        String string = intent.getStringExtra(REQUEST_EXTRA_TITLE);
        String string2 = intent.getStringExtra(REQUEST_EXTRA_SUBTITLE);
        final String string3 = intent.getStringExtra(REQUEST_EXTRA_SUBTITLE_LINK_ACTION);
        boolean bl = intent.getBooleanExtra(REQUEST_EXTRA_SUBTITLE_LINK, false);
        this.mModuleRoot.findViewById(2131362111).setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)string)) {
            ((TextView)this.mModuleRoot.findViewById(2131362206)).setText((CharSequence)string);
        }
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            TextView textView = (TextView)this.mModuleRoot.findViewById(2131362173);
            textView.getPaint().setFlags(8);
            textView.setText((CharSequence)string2);
            if (bl) {
                textView.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setAction(string3);
                        try {
                            CodeModuleUI.this.mActivity.startActivityForResult(intent, 0);
                            return;
                        }
                        catch (ActivityNotFoundException activityNotFoundException) {
                            Log.e((Log.Tag)TAG, (String)"ActivityNotFoundException", (Throwable)activityNotFoundException);
                            return;
                        }
                    }
                });
            }
        }
    }

}

