package org.clisia.ksh.zkwebview.progress;

public interface ProgressManager<T extends BaseProgressSpec> {


    T offer();
}
