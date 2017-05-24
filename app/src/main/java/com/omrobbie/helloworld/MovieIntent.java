package com.omrobbie.helloworld;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieIntent extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_preview);

        TextView movieTitlePreview = (TextView) findViewById(R.id.movieTitlePreview);
        TextView movieDescriptionPreview = (TextView) findViewById(R.id.movieDescriptionPreview);
        ImageView movieImgPreview = (ImageView) findViewById(R.id.movieImgPreview);

        String movieTitle = getIntent().getStringExtra("title");
        String movieDescription = getIntent().getStringExtra("overview");
        String movieImg = getIntent().getStringExtra("poster_path");

        movieTitlePreview.setText(movieTitle);
        movieDescriptionPreview.setText(movieDescription);

        Glide.with(getBaseContext())
                .load("https://image.tmdb.org/t/p/w500" + movieImg)
                .into(movieImgPreview);
    }
}