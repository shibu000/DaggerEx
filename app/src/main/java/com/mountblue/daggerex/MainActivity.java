package com.mountblue.daggerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mountblue.daggerex.api.TodoApi;
import com.mountblue.daggerex.entity.TodoBean;

import org.w3c.dom.Text;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textViewTitle;
    private TextView textViewCompleted;

    @Inject
    Retrofit retrofit;

    private TodoApi todoApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = findViewById(R.id.todo_title);
        textViewCompleted = findViewById(R.id.todo_completed);

        ((BaseApplication) getApplication()).getNetworkComponent().inject(this);
        todoApi = retrofit.create(TodoApi.class);
        todoApi.getTodos(1).enqueue(new Callback<TodoBean>() {
            @Override
            public void onResponse(Call<TodoBean> call, Response<TodoBean> response) {
                Log.d(TAG, "onResponse: "+response.body().getTitle());
                textViewTitle.setText(response.body().getTitle());
                textViewCompleted.setText(String.valueOf(response.body().isCompleted()));
            }

            @Override
            public void onFailure(Call<TodoBean> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

}
