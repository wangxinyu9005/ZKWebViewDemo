package org.clisia.ksh.zkwebviewdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.clisia.ksh.zkwebview.file.FileReaderView;


public class FileDisplayActivity extends AppCompatActivity {

    private FileReaderView mDocumentReaderView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_display);
        init();
    }


    public void init() {
        mDocumentReaderView = findViewById(R.id.documentReaderView);
        mDocumentReaderView.show(getIntent().getStringExtra("path"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDocumentReaderView != null) {
            mDocumentReaderView.stop();
        }
    }


    public static void show(Context context, String url) {
        Intent intent = new Intent(context, FileDisplayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("path", url);
        intent.putExtras(bundle);
        context.startActivity(intent);

    }
}
