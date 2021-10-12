package com.vistoria.androidpocretrofit.Repository;


import com.vistoria.androidpocretrofit.Model.Model;
import com.vistoria.androidpocretrofit.Model.dbModel;
import com.vistoria.androidpocretrofit.Model.headlineModel;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("api/users?page=2")
    Call<Model> getAllData();

    @GET("db")
    Call<dbModel> getAllDataDb();

    @GET("top-headlines?country=us&apiKey=c1972b968b87466fb2a04e8c4d12b80f")
    Call<headlineModel> getAllHeadline();
}
