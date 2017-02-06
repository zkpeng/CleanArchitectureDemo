package demo.zkp.com.weixiaoclean;

import android.app.Application;

import demo.zkp.com.data.entity.net.Api;
import demo.zkp.com.data.entity.net.OkHttpApiImpl;
import executor.Executor;
import executor.MainThread;
import executor.impl.MainThreadImpl;
import executor.impl.ThreadExecutor;

/**
 * Created by Administrator on 2017/1/9.
 */

public class App extends Application {
    public static Api api;
    public static MainThread mainThread;
    public static Executor executor;

    @Override
    public void onCreate() {
        super.onCreate();

        api = OkHttpApiImpl.Instance();
        mainThread = MainThreadImpl.getInstance();
        executor = ThreadExecutor.getInstance();
    }
}
