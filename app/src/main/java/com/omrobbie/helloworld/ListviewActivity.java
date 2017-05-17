package com.omrobbie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        // deklarasikan array data list
        final ArrayList<String> dataList = new ArrayList<>();

        // deklarasikan listview dari layout yang sudah dibuat
        ListView lvList = (ListView) findViewById(R.id.lvList);

        // masukkan data list
        dataList.add("kucing");
        dataList.add("anjing");
        dataList.add("musang");
        dataList.add("tupai");

        // deklarasikan adapter untuk array list
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList);

        // set adapter untuk listview
        lvList.setAdapter(adapter);

        // cek setiap ada item yang di klik
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ambil nilai dari array di posisi sesuai dengan parameter diatas
                String val = dataList.get(position);

                // tampilkan dengan toast
                Toast.makeText(getApplicationContext(), val, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
