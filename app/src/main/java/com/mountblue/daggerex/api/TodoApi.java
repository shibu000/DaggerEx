package com.mountblue.daggerex.api;

import com.mountblue.daggerex.entity.TodoBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoApi {
    @GET("/todos/{id}")
    Call<TodoBean> getTodos(
            @Path("id") int id
    );

}
