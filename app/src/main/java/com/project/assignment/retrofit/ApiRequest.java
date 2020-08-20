package com.project.assignment.retrofit;

import com.project.assignment.model.Article;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("v2/list?page=2&limit=20")
    Call<List<Article>> getMovieArticles();
}
