package org.clisia.ksh.zkwebview.progress;


public interface ProgressLifeCyclic {

    void showProgressBar();

    void setProgressBar(int newProgress);

    void finish();
}
