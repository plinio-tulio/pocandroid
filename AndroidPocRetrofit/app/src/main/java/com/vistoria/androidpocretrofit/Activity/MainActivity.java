package com.vistoria.androidpocretrofit.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vistoria.androidpocretrofit.Model.Model;
import com.vistoria.androidpocretrofit.Model.dbModel;
import com.vistoria.androidpocretrofit.R;
import com.vistoria.androidpocretrofit.Repository.Methods;
import com.vistoria.androidpocretrofit.Repository.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData = findViewById(R.id.button);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                Call<dbModel> call = methods.getAllDataDb();

                call.enqueue(new Callback<dbModel>() {
                    @Override
                    public void onResponse(Call<dbModel> call, Response<dbModel> response) {
                        Log.e(TAG,"onResponse: code" + response.code());

                        ArrayList<dbModel.posts> data = response.body().getPosts();

                        for (dbModel.posts data1 : data) {
                            Log.e(TAG, "onResponse:Titulo: " + data1.getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<dbModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });

            }
        });


    }
}