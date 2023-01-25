/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLEncoder
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.MMSharedPreferences;
import com.tencent.mm.opensdk.openapi.WXApiImplComm;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class BaseWXApiImplV10
implements IWXAPI {
    protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname;
    protected String appId;
    protected boolean checkSignature = false;
    protected Context context;
    protected boolean detached = false;

    BaseWXApiImplV10(Context context, String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder("<init>, appId = ");
        stringBuilder.append(string);
        stringBuilder.append(", checkSignature = ");
        stringBuilder.append(bl);
        Log.d(TAG, stringBuilder.toString());
        this.context = context;
        this.appId = string;
        this.checkSignature = bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean checkSumConsistent(byte[] arrby, byte[] arrby2) {
        block4 : {
            String string;
            block5 : {
                block3 : {
                    if (arrby == null || arrby.length == 0 || arrby2 == null || arrby2.length == 0) break block3;
                    if (arrby.length == arrby2.length) break block4;
                    string = "checkSumConsistent fail, length is different";
                    break block5;
                }
                string = "checkSumConsistent fail, invalid arguments";
            }
            Log.e(TAG, string);
            return false;
        }
        int n = 0;
        while (n < arrby.length) {
            if (arrby[n] != arrby2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/createChatroom");
        String[] arrstring = new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private String getTokenFromWX(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk");
        String[] arrstring = new String[]{this.appId, "620824064"};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null && cursor.moveToFirst()) {
            String string = cursor.getString(0);
            StringBuilder stringBuilder = new StringBuilder("getTokenFromWX token is ");
            stringBuilder.append(string);
            Log.i(TAG, stringBuilder.toString());
            cursor.close();
            return string;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean handleWxInternalRespType(String string, IWXAPIEventHandler iWXAPIEventHandler) {
        StringBuilder stringBuilder = new StringBuilder("handleWxInternalRespType, extInfo = ");
        stringBuilder.append(string);
        Log.i(TAG, stringBuilder.toString());
        try {
            Uri uri = Uri.parse((String)string);
            String string2 = uri.getQueryParameter("wx_internal_resptype");
            StringBuilder stringBuilder2 = new StringBuilder("handleWxInternalRespType, respType = ");
            stringBuilder2.append(string2);
            Log.i(TAG, stringBuilder2.toString());
            if (d.b(string2)) {
                Log.e(TAG, "handleWxInternalRespType fail, respType is null");
                return false;
            }
            boolean bl = string2.equals((Object)"subscribemessage");
            if (bl) {
                SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
                String string3 = uri.getQueryParameter("ret");
                if (string3 != null && string3.length() > 0) {
                    resp.errCode = d.c(string3);
                }
                resp.openId = uri.getQueryParameter("openid");
                resp.templateID = uri.getQueryParameter("template_id");
                resp.scene = d.c(uri.getQueryParameter("scene"));
                resp.action = uri.getQueryParameter("action");
                resp.reserved = uri.getQueryParameter("reserved");
                iWXAPIEventHandler.onResp(resp);
                return true;
            }
            boolean bl2 = string2.contains((CharSequence)"invoice_auth_insert");
            if (bl2) {
                WXInvoiceAuthInsert.Resp resp = new WXInvoiceAuthInsert.Resp();
                String string4 = uri.getQueryParameter("ret");
                if (string4 != null && string4.length() > 0) {
                    resp.errCode = d.c(string4);
                }
                resp.wxOrderId = uri.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp);
                return true;
            }
            if (string2.contains((CharSequence)"payinsurance")) {
                WXPayInsurance.Resp resp = new WXPayInsurance.Resp();
                String string5 = uri.getQueryParameter("ret");
                if (string5 != null && string5.length() > 0) {
                    resp.errCode = d.c(string5);
                }
                resp.wxOrderId = uri.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp);
                return true;
            }
            if (string2.contains((CharSequence)"nontaxpay")) {
                WXNontaxPay.Resp resp = new WXNontaxPay.Resp();
                String string6 = uri.getQueryParameter("ret");
                if (string6 != null && string6.length() > 0) {
                    resp.errCode = d.c(string6);
                }
                resp.wxOrderId = uri.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp);
                return true;
            }
            if (!"subscribeminiprogrammsg".equals((Object)string2) && !"5".equals((Object)string2)) {
                Log.e(TAG, "this open sdk version not support the request type");
                return false;
            }
            SubscribeMiniProgramMsg.Resp resp = new SubscribeMiniProgramMsg.Resp();
            String string7 = uri.getQueryParameter("ret");
            if (string7 != null && string7.length() > 0) {
                resp.errCode = d.c(string7);
            }
            resp.openId = uri.getQueryParameter("openid");
            resp.unionId = uri.getQueryParameter("unionid");
            resp.nickname = uri.getQueryParameter("nickname");
            resp.errStr = uri.getQueryParameter("errmsg");
            iWXAPIEventHandler.onResp(resp);
            return true;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder3 = new StringBuilder("handleWxInternalRespType fail, ex = ");
            stringBuilder3.append(exception.getMessage());
            Log.e(TAG, stringBuilder3.toString());
            return false;
        }
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/joinChatroom");
        String[] arrstring = new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/addCardToWX");
        String[] arrstring = new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX");
        String[] arrstring = new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/handleScanResult");
        String[] arrstring = new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context, BaseReq baseReq) {
        WXInvoiceAuthInsert.Req req = baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        Object[] arrobject = new Object[]{URLEncoder.encode((String)req.url)};
        String string = URLEncoder.encode((String)String.format((String)"url=%s", (Object[])arrobject));
        String[] arrstring = new String[]{this.appId, "2", string};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String[] arrstring = new String[5];
        arrstring[0] = this.appId;
        arrstring[1] = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
        arrstring[2] = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"));
        arrstring[3] = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type"));
        arrstring[4] = stringBuilder2.toString();
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendJumpToBizTempSessionReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession");
        String[] arrstring = new String[4];
        arrstring[0] = this.appId;
        arrstring[1] = bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
        arrstring[2] = bundle.getString("_wxapi_jump_to_biz_webview_req_session_from");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type"));
        arrstring[3] = stringBuilder.toString();
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String[] arrstring = new String[4];
        arrstring[0] = this.appId;
        arrstring[1] = bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
        arrstring[2] = bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene"));
        arrstring[3] = stringBuilder.toString();
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendJumpToOfflinePayReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay");
        String[] arrstring = new String[]{this.appId};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogram(Context context, BaseReq baseReq) {
        WXLaunchMiniProgram.Req req = baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        String[] arrstring = new String[4];
        arrstring[0] = this.appId;
        arrstring[1] = req.userName;
        arrstring[2] = req.path;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.miniprogramType);
        arrstring[3] = stringBuilder.toString();
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context, BaseReq baseReq) {
        WXNontaxPay.Req req = baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        Object[] arrobject = new Object[]{URLEncoder.encode((String)req.url)};
        String string = URLEncoder.encode((String)String.format((String)"url=%s", (Object[])arrobject));
        String[] arrstring = new String[]{this.appId, "3", string};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney");
        String[] arrstring = new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendOpenBusinessWebview(Context context, BaseReq baseReq) {
        WXOpenBusinessWebview.Req req = baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
        String string = req.queryInfo != null && req.queryInfo.size() > 0 ? new JSONObject(req.queryInfo).toString() : "";
        String[] arrstring = new String[3];
        arrstring[0] = this.appId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.businessType);
        arrstring[1] = stringBuilder.toString();
        arrstring[2] = string;
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        Cursor cursor = context.getContentResolver().query(Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openWebview");
        String[] arrstring = new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendPayInSurance(Context context, BaseReq baseReq) {
        WXPayInsurance.Req req = baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        Object[] arrobject = new Object[]{URLEncoder.encode((String)req.url)};
        String string = URLEncoder.encode((String)String.format((String)"url=%s", (Object[])arrobject));
        String[] arrstring = new String[]{this.appId, "4", string};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            StringBuilder stringBuilder = new StringBuilder("pay, set wxappPayEntryClassname = ");
            stringBuilder.append(wxappPayEntryClassname);
            Log.d(TAG, stringBuilder.toString());
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context.getPackageManager().getApplicationInfo((String)"com.tencent.mm", (int)128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder2 = new StringBuilder("get from metaData failed : ");
                    stringBuilder2.append(exception.getMessage());
                    Log.e(TAG, stringBuilder2.toString());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context, args);
    }

    private boolean sendSubscribeMessage(Context context, BaseReq baseReq) {
        SubscribeMessage.Req req = baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        String[] arrstring = new String[]{this.appId, "1", String.valueOf((int)req.scene), req.templateID, req.reserved};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    private boolean sendSubscribeMiniProgramMsg(Context context, BaseReq baseReq) {
        SubscribeMiniProgramMsg.Req req = baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        String[] arrstring = new String[]{this.appId, "5", req.miniProgramAppId};
        Cursor cursor = contentResolver.query(uri, null, null, arrstring, null);
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    @Override
    public void detach() {
        Log.d(TAG, "detach");
        this.detached = true;
        this.context = null;
    }

    @Override
    public int getWXAppSupportAPI() {
        if (!this.detached) {
            if (!this.isWXAppInstalled()) {
                Log.e(TAG, "open wx app failed, not installed or signature check failed");
                return 0;
            }
            int n = new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
            if (n == 0) {
                try {
                    int n2 = this.context.getPackageManager().getApplicationInfo((String)"com.tencent.mm", (int)128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                    return n2;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder("get from metaData failed : ");
                    stringBuilder.append(exception.getMessage());
                    Log.e(TAG, stringBuilder.toString());
                }
            }
            return n;
        }
        throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
    }

    /*
     * Exception decompiling
     */
    @Override
    public boolean handleIntent(Intent var1_1, IWXAPIEventHandler var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:358)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public boolean isWXAppInstalled() {
        if (!this.detached) {
            boolean bl;
            PackageInfo packageInfo;
            block4 : {
                bl = false;
                try {
                    packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                    if (packageInfo != null) break block4;
                    return false;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            }
            bl = WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            return bl;
        }
        throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean openWXApp() {
        String string;
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (!this.isWXAppInstalled()) {
            string = "open wx app failed, not installed or signature check failed";
        } else {
            try {
                this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                return true;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder("startActivity fail, exception = ");
                stringBuilder.append(exception.getMessage());
                string = stringBuilder.toString();
            }
        }
        Log.e(TAG, string);
        return false;
    }

    @Override
    public boolean registerApp(String string) {
        return this.registerApp(string, 0L);
    }

    @Override
    public boolean registerApp(String string, long l) {
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                Log.e(TAG, "register app failed for wechat app signature check failed");
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder("registerApp, appId = ");
            stringBuilder.append(string);
            Log.d(TAG, stringBuilder.toString());
            if (string != null) {
                this.appId = string;
            }
            StringBuilder stringBuilder2 = new StringBuilder("registerApp, appId = ");
            stringBuilder2.append(string);
            Log.d(TAG, stringBuilder2.toString());
            if (string != null) {
                this.appId = string;
            }
            StringBuilder stringBuilder3 = new StringBuilder("register app ");
            stringBuilder3.append(this.context.getPackageName());
            Log.d(TAG, stringBuilder3.toString());
            a.a a2 = new a.a();
            a2.a = "com.tencent.mm";
            a2.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
            StringBuilder stringBuilder4 = new StringBuilder("weixin://registerapp?appid=");
            stringBuilder4.append(this.appId);
            a2.content = stringBuilder4.toString();
            a2.b = l;
            return a.a(this.context, a2);
        }
        throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean sendReq(BaseReq baseReq) {
        block33 : {
            String string;
            block32 : {
                block31 : {
                    if (this.detached) {
                        throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
                    }
                    if (WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) break block31;
                    string = "sendReq failed for wechat app signature check failed";
                    break block32;
                }
                if (baseReq.checkArgs()) break block33;
                string = "sendReq checkArgs fail";
            }
            Log.e(TAG, string);
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder("sendReq, req type = ");
        stringBuilder.append(baseReq.getType());
        Log.i(TAG, stringBuilder.toString());
        Bundle bundle = new Bundle();
        baseReq.toBundle(bundle);
        if (baseReq.getType() == 5) {
            return this.sendPayReq(this.context, bundle);
        }
        if (baseReq.getType() == 7) {
            return this.sendJumpToBizProfileReq(this.context, bundle);
        }
        if (baseReq.getType() == 8) {
            return this.sendJumpToBizWebviewReq(this.context, bundle);
        }
        if (baseReq.getType() == 10) {
            return this.sendJumpToBizTempSessionReq(this.context, bundle);
        }
        if (baseReq.getType() == 9) {
            return this.sendAddCardToWX(this.context, bundle);
        }
        if (baseReq.getType() == 16) {
            return this.sendChooseCardFromWX(this.context, bundle);
        }
        if (baseReq.getType() == 11) {
            return this.sendOpenRankListReq(this.context, bundle);
        }
        if (baseReq.getType() == 12) {
            return this.sendOpenWebview(this.context, bundle);
        }
        if (baseReq.getType() == 25) {
            return this.sendOpenBusinessWebview(this.context, baseReq);
        }
        if (baseReq.getType() == 13) {
            return this.sendOpenBusiLuckyMoney(this.context, bundle);
        }
        if (baseReq.getType() == 14) {
            return this.createChatroom(this.context, bundle);
        }
        if (baseReq.getType() == 15) {
            return this.joinChatroom(this.context, bundle);
        }
        if (baseReq.getType() == 17) {
            return this.sendHandleScanResult(this.context, bundle);
        }
        if (baseReq.getType() == 18) {
            return this.sendSubscribeMessage(this.context, baseReq);
        }
        if (baseReq.getType() == 23) {
            return this.sendSubscribeMiniProgramMsg(this.context, baseReq);
        }
        if (baseReq.getType() == 19) {
            return this.sendLaunchWXMiniprogram(this.context, baseReq);
        }
        if (baseReq.getType() == 20) {
            return this.sendInvoiceAuthInsert(this.context, baseReq);
        }
        if (baseReq.getType() == 21) {
            return this.sendNonTaxPay(this.context, baseReq);
        }
        if (baseReq.getType() == 22) {
            return this.sendPayInSurance(this.context, baseReq);
        }
        if (baseReq.getType() == 24) {
            return this.sendJumpToOfflinePayReq(this.context, bundle);
        }
        if (baseReq.getType() == 2 && bundle.getInt("_wxapi_sendmessagetowx_req_media_type") == 36) {
            SendMessageToWX.Req req = baseReq;
            if (this.getWXAppSupportAPI() < 620756993) {
                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                req.message.mediaObject = wXWebpageObject;
            } else {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject)req.message.mediaObject;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(wXMiniProgramObject.userName);
                stringBuilder2.append("@app");
                wXMiniProgramObject.userName = stringBuilder2.toString();
                String string = wXMiniProgramObject.path;
                if (!d.b(string)) {
                    String string2;
                    StringBuilder stringBuilder3;
                    String[] arrstring = string.split("\\?");
                    if (arrstring.length > 1) {
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(arrstring[0]);
                        stringBuilder3.append(".html?");
                        string2 = arrstring[1];
                    } else {
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(arrstring[0]);
                        string2 = ".html";
                    }
                    stringBuilder3.append(string2);
                    wXMiniProgramObject.path = stringBuilder3.toString();
                }
            }
            if (req.scene != 3) {
                req.scene = 0;
            }
            baseReq.toBundle(bundle);
        }
        String string = this.getTokenFromWX(this.context);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        StringBuilder stringBuilder4 = new StringBuilder("weixin://sendreq?appid=");
        stringBuilder4.append(this.appId);
        args.content = stringBuilder4.toString();
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
        args.token = string;
        return MMessageActV2.send(this.context, args);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean sendResp(BaseResp baseResp) {
        String string;
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            string = "sendResp failed for wechat app signature check failed";
        } else {
            if (baseResp.checkArgs()) {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                StringBuilder stringBuilder = new StringBuilder("weixin://sendresp?appid=");
                stringBuilder.append(this.appId);
                args.content = stringBuilder.toString();
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return MMessageActV2.send(this.context, args);
            }
            string = "sendResp checkArgs fail";
        }
        Log.e(TAG, string);
        return false;
    }

    @Override
    public void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    @Override
    public void unregisterApp() {
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                Log.e(TAG, "unregister app failed for wechat app signature check failed");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("unregisterApp, appId = ");
            stringBuilder.append(this.appId);
            Log.d(TAG, stringBuilder.toString());
            String string = this.appId;
            if (string != null && string.length() != 0) {
                StringBuilder stringBuilder2 = new StringBuilder("unregister app ");
                stringBuilder2.append(this.context.getPackageName());
                Log.d(TAG, stringBuilder2.toString());
                a.a a2 = new a.a();
                a2.a = "com.tencent.mm";
                a2.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
                StringBuilder stringBuilder3 = new StringBuilder("weixin://unregisterapp?appid=");
                stringBuilder3.append(this.appId);
                a2.content = stringBuilder3.toString();
                a.a(this.context, a2);
                return;
            }
            Log.e(TAG, "unregisterApp fail, appId is empty");
            return;
        }
        throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
    }
}

