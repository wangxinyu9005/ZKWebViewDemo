package org.clisia.ksh.zkwebview.file;

import android.content.Intent;

public interface IFileUploadChooser {



    void openFileChooser();

    void fetchFilePathFromIntent(int requestCode, int resultCode, Intent data);
}
