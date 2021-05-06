package com.example.fgelappen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//This activity is for displaying more info about a bird from a listview when clicking on a listview item.

public class SecondActivity extends AppCompatActivity {

    private String currentBirdName;
    private String currentBirdCategory;
    private String currentBirdSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        currentBirdName = getIntent().getExtras().get("birdName").toString();
        currentBirdCategory = getIntent().getExtras().get("birdCategory").toString();
        currentBirdSize = getIntent().getExtras().get("birdSize").toString();

        TextView bird_information = (TextView) findViewById(R.id.bird_information);

        bird_information.setText("Namn: "+currentBirdName + "\nFågelfamilj: "+currentBirdCategory+"\nLängd: "+currentBirdSize+" cm");
    }
}