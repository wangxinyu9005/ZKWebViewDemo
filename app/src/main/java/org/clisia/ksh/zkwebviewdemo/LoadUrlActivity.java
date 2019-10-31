package org.clisia.ksh.zkwebviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.KeyEvent;

import org.clisia.ksh.zkwebview.fragment.FragmentKeyDown;
import org.clisia.ksh.zkwebview.fragment.SuperWebX5Fragment;

public class LoadUrlActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private SuperWebX5Fragment mSuperWebX5Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_url);

        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        mFragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();

        openWebFragment(ft);
    }

    private void openWebFragment(FragmentTransaction ft) {
        Bundle mBundle = null;
        ft.add(R.id.container_framelayout, mSuperWebX5Fragment = SuperWebX5Fragment.getInstance(mBundle = new Bundle()), SuperWebX5Fragment.class.getName());
        mBundle.putString(SuperWebX5Fragment.KEY_UTL, "http://news.baidu.com/");
        mBundle.putBoolean(SuperWebX5Fragment.KEY_TOOLBAR_VISIBLE, false);
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mSuperWebX5Fragment.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        SuperWebX5Fragment mAgentWebX5Fragment = this.mSuperWebX5Fragment;
        if (mAgentWebX5Fragment != null) {
            FragmentKeyDown mFragmentKeyDown = mAgentWebX5Fragment;
            if (mFragmentKeyDown.onFragmentKeyDown(keyCode, event)) {
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
