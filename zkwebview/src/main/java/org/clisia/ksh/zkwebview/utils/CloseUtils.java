package org.clisia.ksh.zkwebview.utils;

import java.io.Closeable;

/**
 * close工具类
 */
public class CloseUtils {


    public static void closeIO(Closeable closeable){
        try {

            if(closeable!=null)
                closeable.close();
        }catch (Exception e){

            e.printStackTrace();
        }

    }
}
