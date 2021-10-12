package com.vistoria.androidpocretrofit.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vistoria.androidpocretrofit.Model.Model;
import com.vistoria.androidpocretrofit.Model.dbModel;
import com.vistoria.androidpocretrofit.Model.headlineModel;
import com.vistoria.androidpocretrofit.R;
import com.vistoria.androidpocretrofit.Repository.Methods;
import com.vistoria.androidpocretrofit.Repository.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity02 extends AppCompatActivity {

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
                Call<headlineModel> call = methods.getAllHeadline();

                call.enqueue(new Callback<headlineModel>() {
                    @Override
                    public void onResponse(Call<headlineModel> call, Response<headlineModel> response) {
                        Log.e(TAG,"onResponse: code" + response.code());

                        ArrayList<headlineModel.articles> data = response.body().getArticles();

                        for (headlineModel.articles data1 : data) {
                            Log.e(TAG, "onResponse: Título: " + data1.getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<headlineModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });

            }
        });

    }
}