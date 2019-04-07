package com.t3h.chatfun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FriendActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Friend> friends;
    private RecyclerView rcFriend;
    private Api api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        inits();
        rcFriend = findViewById(R.id.rc_friend);
        FriendAdapter adapter = new FriendAdapter(friends);
        rcFriend.setLayoutManager(new LinearLayoutManager(this));
        rcFriend.setAdapter(adapter);

        findViewById(R.id.btn_add_friend).setOnClickListener(this);
        initApi();
    }

    private void inits() {
        friends = new ArrayList<>();


    }

    private void initApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.0.54.161:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);

        api.getFriends(
                "Bearer "
                        + ((MyApp) getApplicationContext())
                        .getLoginResponse()
                        .getToken()
        ).enqueue(new Callback<List<Friend>>() {
            @Override
            public void onResponse(Call<List<Friend>> call, Response<List<Friend>> response) {
                friends = response.body();
                ((FriendAdapter)rcFriend.getAdapter()).setFriends(friends);
                rcFriend.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Friend>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        //mo man hinh friend
        Intent intent = new Intent();
        intent.setClass(this, AddFriendActivity.class);
        startActivity(intent);
    }
}
