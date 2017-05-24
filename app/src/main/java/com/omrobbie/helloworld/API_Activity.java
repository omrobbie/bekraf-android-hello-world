package com.omrobbie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class API_Activity extends AppCompatActivity implements API_Adapter.ItemClickListener {

    private API_Adapter adapter;
    private ArrayList<HashMap<String, String>> myArray;

    private RequestQueue queue;
    private String url;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);
        url = "http://jsonplaceholder.typicode.com/posts";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        // mTextView.setText("Response is: "+ response.substring(0,500));

                        // get data JSON dari Internet, dan tampilkan ke TextView
                        try {
                            JSONArray result = new JSONArray(response);

                            // Deklarasi array
                            myArray = new ArrayList<>();

                            // Konversi ke array
                            for (int i=0; i<result.length(); i++) {
                                JSONObject item = (JSONObject)result.get(i);
                                HashMap<String, String> temp = new HashMap<>();
                                temp.put("title", item.get("title").toString());
                                temp.put("body", item.get("body").toString());
                                myArray.add(temp);
                            }

                            // masukkan data animal kedalam adapter
                            adapter = new API_Adapter(API_Activity.this, myArray);
                            adapter.setClickListener(API_Activity.this);

                            // set adapternya
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(API_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}