package com.t3h.chatfun;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @POST("/api/user/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET("/api/user/friends")
    Call<List<Friend>> getFriends(
            @Header("Authorization") String authorization
    );

    @GET("/api/friend/others")
    Call<List<AddFriend>> getOtherFriend(
            @Header("Authorization") String authorization
    );
}
