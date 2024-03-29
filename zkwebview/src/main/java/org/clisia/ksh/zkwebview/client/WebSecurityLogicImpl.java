package org.clisia.ksh.zkwebview.client;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.collection.ArrayMap;

import com.tencent.smtt.sdk.WebView;

import org.clisia.ksh.zkwebview.SuperWebX5;
import org.clisia.ksh.zkwebview.SuperWebX5Config;


public class WebSecurityLogicImpl implements WebSecurityCheckLogic {
    public static WebSecurityLogicImpl getInstance() {
        return new WebSecurityLogicImpl();
    }

    public WebSecurityLogicImpl(){}

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void dealHoneyComb(WebView view) {
        if (Build.VERSION_CODES.HONEYCOMB > Build.VERSION.SDK_INT || Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1)
            return;
        view.removeJavascriptInterface("searchBoxJavaBridge_");
        view.removeJavascriptInterface("accessibility");
        view.removeJavascriptInterface("accessibilityTraversal");
    }

    @Override
    public void dealJsInterface(ArrayMap<String, Object> objects, SuperWebX5.SecurityType securityType) {

        if (securityType== SuperWebX5.SecurityType.strict&& SuperWebX5Config.WEBVIEW_TYPE!= SuperWebX5Config.WEBVIEW_SUPERWEB_SAFE_TYPE&& Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            objects.clear();
            objects = null;
            System.gc();
        }

    }
}
