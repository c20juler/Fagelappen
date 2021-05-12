package com.example.fgelappen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Bird> listData;
    private ArrayAdapter<Bird> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Welcome splash screen...
        Intent welcome_intent = new Intent (this, WelcomeSplashActivity.class);
        startActivity(welcome_intent);

        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=c20juler");

        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, listData);

        ListView my_listView=(ListView) findViewById(R.id.list_view);
        my_listView.setAdapter(adapter);
        my_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String currentBirdName = listData.get(position).getName();
                String currentBirdCategory = listData.get(position).getCategory();
                int currentBirdSize = listData.get(position).getSize();
                String currentBirdImg = listData.get(position).getAuxdata().getImg();

                Intent birdIntent = new Intent(MainActivity.this, SecondActivity.class);
                birdIntent.putExtra("birdName", currentBirdName);
                birdIntent.putExtra("birdCategory", currentBirdCategory);
                birdIntent.putExtra("birdSize", currentBirdSize);
                birdIntent.putExtra("birdImg", currentBirdImg);

                startActivity(birdIntent);
            }
        });


        Button button = findViewById(R.id.about_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            Log.d("TAG", json);

            Log.d("TAG ==>", json);
            Gson gson = new Gson();
            Bird[] temporary = gson.fromJson(json,Bird[].class);

            for (int i = 0; i < temporary.length; i++) {
                Bird bird = temporary[i];
                Log.d("AsyncTask ==>", "Found a bird!: "+bird);
                listData.add(bird);

            }
            adapter.notifyDataSetChanged();


        }
    }

}