package demo.zkp.com.weixiaoclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import demo.zkp.com.weixiaoclean.R;
import demo.zkp.com.weixiaoclean.presenter.MainPresenter;
import demo.zkp.com.weixiaoclean.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initPresenter();
        mainPresenter.onCreate();
    }

    private void initView() {
        btn_login = (Button) findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.doJumpToUserListActivity(MainActivity.this);
            }
        });
    }

    private void initPresenter() {
        mainPresenter = new MainPresenter();
        mainPresenter.setLoginView(this);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showFail() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
