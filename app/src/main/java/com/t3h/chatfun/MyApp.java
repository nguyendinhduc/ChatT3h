package com.t3h.chatfun;

import android.app.Application;

public class MyApp extends Application {
    private LoginResponse loginResponse;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }
}
