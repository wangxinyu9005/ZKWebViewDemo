package org.clisia.ksh.zkwebview;

import android.os.Handler;
import android.os.Looper;

import com.tencent.smtt.sdk.WebView;

import org.clisia.ksh.zkwebview.utils.SuperWebX5Utils;

import java.util.Map;

/**
 * 加载URL
 */
public class LoaderImpl implements ILoader {


    private Handler mHandler = null;
    private WebView mWebView;

    private Map<String, String> headers = null;

    LoaderImpl(WebView webView, Map<String, String> map) {
        this.mWebView = webView;
        if (this.mWebView == null)
            new NullPointerException("webview is null");

        this.headers = map;
        mHandler = new Handler(Looper.getMainLooper());
    }

    private void safeLoadUrl(final String url) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                loadUrl(url);
            }
        });
    }

    private void safeReload() {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                reload();
            }
        });
    }

    @Override
    public void loadUrl(String url) {


        if (!SuperWebX5Utils.isUIThread()) {
            safeLoadUrl(url);
            return;
        }
        //|| ((!url.startsWith("http")&&(!url.startsWith("javascript:"))))
        /*if (TextUtils.isEmpty(url))
            throw new UrlCommonException("url is null or '' or not startsWith http ,javascript , file , please check url format");*/

        if (!SuperWebX5Utils.isEmptyMap(this.headers))
            this.mWebView.loadUrl(url, headers);
        else
            this.mWebView.loadUrl(url);
    }

    @Override
    public void reload() {
        if (!SuperWebX5Utils.isUIThread()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    reload();
                }
            });
            return;
        }
        this.mWebView.reload();


    }

    @Override
    public void loadData(final String data, final String mimeType, final String encoding) {

        if (!SuperWebX5Utils.isUIThread()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    loadData(data, mimeType, encoding);
                }
            });
            return;
        }
        this.mWebView.loadData(data, mimeType, encoding);

    }

    @Override
    public void stopLoading() {

        if (!SuperWebX5Utils.isUIThread()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    stopLoading();
                }
            });
            return;
        }
        this.mWebView.stopLoading();

    }

    @Override
    public void loadDataWithBaseURL(final String baseUrl, final String data, final String mimeType, final String encoding, final String historyUrl) {

        if (!SuperWebX5Utils.isUIThread()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
                }
            });
            return;
        }
        this.mWebView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);

    }
}
