package com.omrobbie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        // deklarasikan array data list
        ArrayList<String> dataList = new ArrayList<>();

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
    }
}
