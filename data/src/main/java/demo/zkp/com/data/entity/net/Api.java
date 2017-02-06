package demo.zkp.com.data.entity.net;

import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;

/**
 * Created by zkp on 2017/1/9.
 */

public interface Api {

    String API_BASE_URL = "http://www.android10.org/myapi/";
    String API_URL_GET_USER_LIST = API_BASE_URL + "users.json";

    List<UserEntity> getUserList();
}
