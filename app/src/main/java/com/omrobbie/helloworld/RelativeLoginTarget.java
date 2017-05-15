package com.omrobbie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RelativeLoginTarget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_login_target);

        TextView txtLoginName = (TextView) findViewById(R.id.txtLoginName);

        // get data intent dari layout login
        String userName = getIntent().getStringExtra("data");
        txtLoginName.setText(userName);
    }
}
