package org.clisia.ksh.zkwebview.client;

import androidx.collection.ArrayMap;

import com.tencent.smtt.sdk.WebView;

import org.clisia.ksh.zkwebview.SuperWebX5;


public interface WebSecurityCheckLogic {
    void dealHoneyComb(WebView view);

    void dealJsInterface(ArrayMap<String, Object> objects, SuperWebX5.SecurityType securityType);

}
