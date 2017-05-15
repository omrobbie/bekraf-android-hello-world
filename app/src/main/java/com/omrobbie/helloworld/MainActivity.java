package com.omrobbie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_login);

        final EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sembunyikan fungsi Toast dan ganti dengan Intent
                // Toast.makeText(MainActivity.this, txtUsername.getText() + " | " + txtPassword.getText(), Toast.LENGTH_SHORT).show();

                // tampilkan hasil ke layout tujuan
                // Intent intent = new Intent(getApplicationContext(), RelativeLoginTarget.class);
                // intent.putExtra("data", txtUsername.getText().toString());
                // startActivity(intent);

                // refactoring
                startActivity(new Intent(getApplicationContext(), RelativeLoginTarget.class).putExtra("data", txtUsername.getText().toString()));
            }
        });
    }
}