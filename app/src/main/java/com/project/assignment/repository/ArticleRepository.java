package com.project.assignment.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.project.assignment.model.Article;
import com.project.assignment.retrofit.ApiRequest;
import com.project.assignment.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<List<Article>> getMovieArticles() {
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        apiRequest.getMovieArticles()
                .enqueue(new Callback<List<Article>>() {
                    @Override
                    public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Article>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
