package com.example.a10062376.netstatusdemo;

/**
 * Created by 10062376 on 2017/11/20.
 */

public class Application extends android.app.Application {
    private static android.app.Application mApplication;
    public static int mNetWorkState;

    public static synchronized android.app.Application getIncetance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        intData();
    }

    private void intData() {
        mNetWorkState = NetUtil.getNetworkState(this);
    }
}
