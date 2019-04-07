package com.t3h.chatfun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtEmail, edtPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        edtEmail = findViewById(R.id.tv_email);
        edtPassword = findViewById(R.id.tv_password);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://3.0.54.161:8080")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

//                localhost:8080/api/user/login

                break;
        }
    }
}
