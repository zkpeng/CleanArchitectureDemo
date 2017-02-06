package demo.zkp.com.weixiaoclean.presenter;

import android.content.Context;
import android.content.Intent;

import demo.zkp.com.weixiaoclean.activity.UserListActivity;
import demo.zkp.com.weixiaoclean.view.MainView;

/**
 * Created by Administrator on 2017/1/6.
 */

public class MainPresenter implements BasePresenter {

    private MainView mainView;

    public void setLoginView(MainView mainView) {
        this.mainView = mainView;
    }

    public void doJumpToUserListActivity(Context context) {
        if (context != null) {
            Intent intent = UserListActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}
