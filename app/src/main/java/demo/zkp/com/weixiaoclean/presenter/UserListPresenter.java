package demo.zkp.com.weixiaoclean.presenter;

import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;
import demo.zkp.com.domain.interactors.base.BaseInteractor;
import demo.zkp.com.domain.interactors.callback.GetUserListInteractorCallback;
import demo.zkp.com.domain.interactors.impl.GetUserListInteractor;
import demo.zkp.com.weixiaoclean.App;
import demo.zkp.com.weixiaoclean.view.UserListView;

/**
 * Created by Administrator on 2017/1/9.
 */

public class UserListPresenter implements BasePresenter, GetUserListInteractorCallback {

    private UserListView userListView;
    private BaseInteractor getUserListInteractor;

    public void setGetUserListView(UserListView userListView) {
        this.userListView = userListView;
    }

    @Override
    public void onCreate() {
        userListView.showLoading();
        getUserListInteractor = new GetUserListInteractor(App.api, App.executor, App.mainThread, this);
        getUserListInteractor.execute();
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

    @Override
    public void onGetUserListSuccess(List<UserEntity> userEntities) {
        userListView.hideLoading();
        userListView.refreshUserDatas(userEntities);
    }

    @Override
    public void onGetUserListFail(String message) {

    }
}
