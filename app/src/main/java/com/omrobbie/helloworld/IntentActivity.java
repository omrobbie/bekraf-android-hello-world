package com.omrobbie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        final EditText txtName = (EditText) findViewById(R.id.txtName);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = txtName.getText().toString();

                // pindah ke layout yang lain dengan intent
                Intent intent = new Intent(IntentActivity.this, IntentTargetActivity.class);
                intent.putExtra("data", userName);
                startActivity(intent);
            }
        });
    }
}