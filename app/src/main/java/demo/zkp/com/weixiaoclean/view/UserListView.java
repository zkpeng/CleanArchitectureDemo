package demo.zkp.com.weixiaoclean.view;

import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface UserListView extends BaseView {

    void refreshUserDatas(List<UserEntity> userEntities);
}
