package com.example.fgelappen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Bird> listData;
    private ArrayAdapter<Bird> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add welcome splash screen...(with welcome msg and bird picture...)

        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, listData);

        ListView my_listView=(ListView) findViewById(R.id.list_view);
        my_listView.setAdapter(adapter);





        Button button = findViewById(R.id.about_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}