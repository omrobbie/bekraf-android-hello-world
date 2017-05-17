package com.omrobbie.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentTargetActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_target);

        TextView txtIntentTarget = (TextView) findViewById(R.id.txtIntentTarget);

        // tampilkan data kiriman dari layout pertama
        String userName = getIntent().getStringExtra("data");
        txtIntentTarget.setText(userName);

        // logout, dan kembali meminta username
        Button btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pref = getBaseContext().getSharedPreferences("userprefs", MODE_PRIVATE);
                // pref.edit().putString("username", null).commit();

                // menggunakan editor untuk menyimpan data sharedpreferences
                SharedPreferences.Editor editor = getSharedPreferences("username", MODE_PRIVATE).edit();
                editor.putString("username", null);
                editor.putString("a", null);
                editor.putString("b", null);
                editor.commit();

                finish();

                // tampilkan layout dari class IntentActivity
                Intent intent = new Intent(getApplicationContext(), IntentActivity.class);
                startActivity(intent);
            }
        });
    }
}
