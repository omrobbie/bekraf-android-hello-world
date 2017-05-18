package com.omrobbie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecyclerviewActivity extends AppCompatActivity implements RecyclerviewAdapter.ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
    }
}