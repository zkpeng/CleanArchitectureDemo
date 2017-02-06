package demo.zkp.com.weixiaoclean.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.List;

import demo.zkp.com.data.entity.entity.UserEntity;
import demo.zkp.com.weixiaoclean.R;
import demo.zkp.com.weixiaoclean.adapter.UsersAdapter;
import demo.zkp.com.weixiaoclean.adapter.UsersLayoutManager;
import demo.zkp.com.weixiaoclean.presenter.UserListPresenter;
import demo.zkp.com.weixiaoclean.view.UserListView;

public class UserListActivity extends BaseActivity implements UserListView {

    private UserListPresenter userListPresenter;
    private ProgressDialog progressDialog;
    private UsersAdapter usersAdapter;

    RecyclerView rv_users;
    RelativeLayout rl_progress;
    RelativeLayout rl_retry;
    Button bt_retry;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        initView();
        initPresenter();
        userListPresenter.onCreate();
    }

    private void initView() {
        progressDialog = new ProgressDialog(this);
        rv_users = (RecyclerView) findViewById(R.id.rv_users);
        rl_progress = (RelativeLayout) findViewById(R.id.rl_progress);
        rl_retry = (RelativeLayout) findViewById(R.id.rl_retry);
        bt_retry = (Button) findViewById(R.id.bt_retry);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        usersAdapter = new UsersAdapter(this);
        this.usersAdapter.setOnItemClickListener(onItemClickListener);
        this.rv_users.setLayoutManager(new UsersLayoutManager(this));
        this.rv_users.setAdapter(usersAdapter);
    }

    private void initPresenter() {
        userListPresenter = new UserListPresenter();
        userListPresenter.setGetUserListView(this);
    }

    @Override
    public void showLoading() {
        progressDialog.setMessage("正在加载中...");
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.cancel();
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showFail() {

    }

    private UsersAdapter.OnItemClickListener onItemClickListener =
            new UsersAdapter.OnItemClickListener() {
                @Override
                public void onUserItemClicked(UserEntity userModel) {
                }
            };

    @Override
    public void refreshUserDatas(List<UserEntity> userEntities) {
        this.usersAdapter.setUsersCollection(userEntities);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userListPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        userListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        userListPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userListPresenter.onDestroy();
    }
}
