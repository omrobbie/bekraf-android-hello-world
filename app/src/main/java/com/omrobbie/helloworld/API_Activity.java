package com.omrobbie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

public class API_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_);

        final TextView mTextView = (TextView) findViewById(R.id.txtAPI);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://jsonplaceholder.typicode.com/posts";

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
                            JSONObject data = (JSONObject)result.get(0);
                            String title = data.getString("title");
                            mTextView.setText(title);

                            // Deklarasi array
                            ArrayList<HashMap<String, String>> myArray = new ArrayList<>();

                            // Konversi ke array
                            for (int i=0; i<result.length(); i++) {
                                JSONObject item = (JSONObject)result.get(i);
                                HashMap<String, String> temp = new HashMap<>();
                                temp.put("title", item.get("title").toString());
                                temp.put("body", item.get("body").toString());
                                myArray.add(temp);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
