package com.omrobbie.helloworld;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class MovieActivity extends AppCompatActivity implements MovieAdapter.ItemClickListener {

    private MovieAdapter adapter;
    private ArrayList<HashMap<String, String>> myArray;

    private RequestQueue queue;
    private String url;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);

        recyclerView = (RecyclerView) findViewById(R.id.rvMovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);
        url = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=9c04c6a25d15c5a8a20e1c0a16133557";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        // mTextView.setText("Response is: "+ response.substring(0,500));

                        // get data JSON dari Internet, dan tampilkan ke TextView
                        try {
                            JSONObject respons = new JSONObject(response);
                            JSONArray result = (JSONArray) respons.get("results");

                            // Deklarasi array
                            myArray = new ArrayList<>();

                            // Konversi ke array
                            for (int i=0; i<result.length(); i++) {
                                JSONObject item = (JSONObject)result.get(i);

                                HashMap<String, String> temp = new HashMap<>();

                                temp.put("title", item.get("title").toString());
                                temp.put("overview", item.get("overview").toString());
                                temp.put("poster_path", item.get("poster_path").toString());
                                myArray.add(temp);
                            }

                            // masukkan data animal kedalam adapter
                            adapter = new MovieAdapter(MovieActivity.this, myArray);
                            adapter.setClickListener(MovieActivity.this);

                            // set adapternya
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MovieActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void onItemClick(View view, int position) {
        // Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        HashMap<String, String> item = adapter.getItem(position);

        Intent intent = new Intent(MovieActivity.this, MovieIntent.class);
        intent.putExtra("title", item.get("title"));
        intent.putExtra("overview", item.get("overview"));
        intent.putExtra("poster_path", item.get("poster_path"));
        startActivity(intent);
    }
}