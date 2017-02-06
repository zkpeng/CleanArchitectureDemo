package demo.zkp.com.domain.interactors.callback;


import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;

public interface GetUserListInteractorCallback {

    void onGetUserListSuccess(List<UserEntity> userEntities);

    void onGetUserListFail(String message);

}
