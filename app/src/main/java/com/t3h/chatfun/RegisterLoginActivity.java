package com.t3h.chatfun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername, edtPassword, edtDisplayName;
    private ImageView ivAvatar;
    private View llAvatar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivyt_login_register);
        inits();
    }

    private void inits(){
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        edtDisplayName = findViewById(R.id.edt_display_name);
        llAvatar = findViewById(R.id.ll_avatar);
        llAvatar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
