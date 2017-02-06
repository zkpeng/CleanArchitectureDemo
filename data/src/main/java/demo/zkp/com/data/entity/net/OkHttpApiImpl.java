package demo.zkp.com.data.entity.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zkp on 2017/1/9.
 */

public class OkHttpApiImpl implements Api {

    private static OkHttpApiImpl okHttpApiImpl;
    private OkHttpClient okHttpClient;
    private Gson gson;

    public static OkHttpApiImpl Instance() {
        if (okHttpApiImpl == null) {
            synchronized (OkHttpApiImpl.class) {
                if (okHttpApiImpl == null) {
                    okHttpApiImpl = new OkHttpApiImpl();
                }
            }
        }
        return okHttpApiImpl;
    }

    private OkHttpApiImpl() {
        okHttpClient = new OkHttpClient();
        gson = new Gson();
    }

    @Override
    public List<UserEntity> getUserList() {
        Request request = new Request.Builder()
                .url(Api.API_URL_GET_USER_LIST)
                .build();
        List<UserEntity> userEntities = new ArrayList<>();
        try {
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                userEntities = gson.fromJson(response.body().string(),
                        new TypeToken<List<UserEntity>>() {
                        }.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userEntities;
    }
}
