package com.project.assignment.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.project.assignment.model.Article;
import com.project.assignment.repository.ArticleRepository;

import java.util.List;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<List<Article>> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles();
    }

    public LiveData<List<Article>> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
}
