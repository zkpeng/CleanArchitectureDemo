package demo.zkp.com.domain.interactors.impl;

import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;
import demo.zkp.com.data.entity.net.Api;
import demo.zkp.com.domain.interactors.base.BaseInteractor;
import demo.zkp.com.domain.interactors.callback.GetUserListInteractorCallback;
import executor.Executor;
import executor.MainThread;

/**
 * Created by zkp on 2017/1/6.
 */

public class GetUserListInteractor extends BaseInteractor {

    private Api api;
    private GetUserListInteractorCallback callback;

    public GetUserListInteractor(Api api, Executor threadExecutor, MainThread mainThread, GetUserListInteractorCallback callback) {
        super(threadExecutor, mainThread);
        this.api = api;
        this.callback = callback;
    }

    @Override
    public void run() {
        List<UserEntity> userEntityList = api.getUserList();
        if (userEntityList == null) {
            notifyFail("");
            return;
        }
        notifySuccess(userEntityList);
    }

    private void notifySuccess(final List<UserEntity> userEntityList) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onGetUserListSuccess(userEntityList);
            }
        });
    }

    private void notifyFail(final String message) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onGetUserListFail(message);
            }
        });
    }
}
