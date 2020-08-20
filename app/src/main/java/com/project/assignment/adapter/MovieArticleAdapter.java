package com.project.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.assignment.R;
import com.project.assignment.model.Article;


import java.util.ArrayList;

public class MovieArticleAdapter extends RecyclerView.Adapter<MovieArticleAdapter.ViewHolder> {

    private Context context;
    ArrayList<Article> articleArrayList;

    public MovieArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public MovieArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieArticleAdapter.ViewHolder viewHolder, int i) {
        Article article=articleArrayList.get(i);
        viewHolder.tvAuthorAndPublishedAt.setText("-"+article.getAuthor());
        Glide.with(context)
                .load(article.getDownload_url())
                .into(viewHolder.imgViewCover);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvAuthorAndPublishedAt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover=(ImageView) itemView.findViewById(R.id.imgViewCover);
            tvAuthorAndPublishedAt=(TextView) itemView.findViewById(R.id.tvAuthorAndPublishedAt);
        }
    }
}
