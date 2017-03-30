package com.zhaopengfei.myapplication.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaopengfei.myapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_longin)
    TextView tvLongin;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.iv_tupian1)
    ImageView ivTupian1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_user_pwd)
    EditText etUserPwd;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initListener() {

        etUserPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ivTupian1.setImageResource(R.drawable.ic_22_hide);

                    imageView2.setImageResource(R.drawable.ic_33_hide);
                }else {
                    ivTupian1.setImageResource(R.drawable.ic_22 );

                    imageView2.setImageResource(R.drawable.ic_33);
                }
            }
        });

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(String json, String error) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.tv_back, R.id.tv_longin, R.id.tv_forget_pwd, R.id.et_username, R.id.et_user_pwd, R.id.btn_register, R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_longin:
                break;
            case R.id.tv_forget_pwd:
                break;
            case R.id.et_username:
                break;
            case R.id.et_user_pwd:
                break;
            case R.id.btn_register:
                break;
            case R.id.login_btn:
                break;
        }
    }

}
