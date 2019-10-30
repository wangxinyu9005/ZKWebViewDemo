package org.clisia.ksh.zkwebview.progress;


import com.tencent.smtt.sdk.WebView;

public interface IndicatorController {

    void progress(WebView v, int newProgress);

    BaseProgressSpec offerIndicator();
}
