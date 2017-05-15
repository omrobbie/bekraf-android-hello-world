package com.omrobbie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentTargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_target);

        TextView txtIntentTarget = (TextView) findViewById(R.id.txtIntentTarget);

        // tampilkan data kiriman dari layout pertama
        String userName = getIntent().getStringExtra("data");
        txtIntentTarget.setText(userName);
    }
}
