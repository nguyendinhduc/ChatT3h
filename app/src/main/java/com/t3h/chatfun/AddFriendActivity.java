package com.t3h.chatfun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddFriendActivity extends AppCompatActivity {
    private AddFriendAdapter friendAdapter;
    private RecyclerView rcFriend;
    private List<AddFriend> addFriends = new ArrayList<>();
    private Api api;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_add_friend);
        rcFriend = findViewById(R.id.rc_add_friend);
        rcFriend.setLayoutManager(new LinearLayoutManager(this));
        friendAdapter = new AddFriendAdapter(addFriends);
        rcFriend.setAdapter(friendAdapter);
        inits();
    }

    private void inits(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.0.54.161:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);

        api.getOtherFriend(
                "Bearer "
                        + ((MyApp) getApplicationContext())
                        .getLoginResponse()
                        .getToken()
        ).enqueue(new Callback<List<AddFriend>>() {
            @Override
            public void onResponse(Call<List<AddFriend>> call, Response<List<AddFriend>> response) {
                addFriends.addAll(response.body());
                friendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AddFriend>> call, Throwable t) {

            }
        });
    }
}
