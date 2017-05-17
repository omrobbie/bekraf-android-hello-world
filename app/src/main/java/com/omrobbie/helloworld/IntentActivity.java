package com.omrobbie.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.data;

public class IntentActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        final EditText txtName = (EditText) findViewById(R.id.txtName);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        // deklarasi SharedPreferences
        pref = getBaseContext().getSharedPreferences("userprefs", MODE_PRIVATE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = txtName.getText().toString();

                // simpan data kedalam session (sharedpreference)
                pref.edit().putString("username", userName).commit();

                // jalankan fungsi gotoHome
                gotoHome(userName);
            }
        });

        // cek apakah ada userName di sharedpreference
        String datauser = pref.getString("username", null);

        if (datauser != null) {
            gotoHome(datauser);
        }
    }

    private void gotoHome(String userName) {
        // pindah ke layout yang lain dengan intent
        Intent intent = new Intent(IntentActivity.this, IntentTargetActivity.class);
        intent.putExtra("data", userName);
        startActivity(intent);
        finish();
    }
}