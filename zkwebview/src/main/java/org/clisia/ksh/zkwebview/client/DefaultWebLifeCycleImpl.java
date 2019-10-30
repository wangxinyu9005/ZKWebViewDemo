package org.clisia.ksh.zkwebview.client;

import android.os.Build;

import com.tencent.smtt.sdk.WebView;

import org.clisia.ksh.zkwebview.utils.SuperWebX5Utils;


/**
 * 默认web的生命周期
 */

public class DefaultWebLifeCycleImpl implements WebLifeCycle {
    private WebView mWebView;

    public DefaultWebLifeCycleImpl(WebView webView) {
        this.mWebView = webView;
    }

    @Override
    public void onResume() {
        if (this.mWebView != null) {

            if (Build.VERSION.SDK_INT >= 11)
                this.mWebView.onResume();

            this.mWebView.resumeTimers();

        }


    }

    @Override
    public void onPause() {

        if (this.mWebView != null) {
            this.mWebView.pauseTimers();
            if (Build.VERSION.SDK_INT >= 11)
                this.mWebView.onPause();
        }
    }

    @Override
    public void onDestroy() {
        if(this.mWebView!=null){
            this.mWebView.resumeTimers();
        }
        SuperWebX5Utils.clearWebView(this.mWebView);
    }
}
