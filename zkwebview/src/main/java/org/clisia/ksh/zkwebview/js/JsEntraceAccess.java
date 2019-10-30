package org.clisia.ksh.zkwebview.js;

import android.webkit.ValueCallback;


public interface JsEntraceAccess extends QuickCallJs {


    void callJs(String js, ValueCallback<String> callback);

    void callJs(String js);




}
