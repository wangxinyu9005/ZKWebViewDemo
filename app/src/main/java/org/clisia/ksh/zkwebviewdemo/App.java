package org.clisia.ksh.zkwebviewdemo;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

public class App extends Application {
    private static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.e("TestZKWebView", "TestZKWebView.Application.onCreate");
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("TestZKWebView", "TestZKWebView onViewInitFinished is " + arg0);


            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };

        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.e("TestZKWebView", "TestZKWebView onDownloadFinish ======" + i);
            }

            @Override
            public void onInstallFinish(int i) {
                Log.e("TestZKWebView", "TestZKWebView onInstallFinish ======" + i);
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.e("TestZKWebView", "TestZKWebView onDownloadProgress ======" + i);
            }
        });
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}
