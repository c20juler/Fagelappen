package com.example.fgelappen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//This activity is for displaying more info about a bird from a listview when clicking on a listview item.

public class SecondActivity extends AppCompatActivity {

    private String currentBirdName;
    private String currentBirdCategory;
    private String currentBirdSize;
    private String currentBirdImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        currentBirdName = getIntent().getExtras().get("birdName").toString();
        currentBirdCategory = getIntent().getExtras().get("birdCategory").toString();
        currentBirdSize = getIntent().getExtras().get("birdSize").toString();
        currentBirdImg = getIntent().getExtras().get("birdImg").toString();



        TextView bird_name = (TextView) findViewById(R.id.bird_name);
        bird_name.setText(currentBirdName);

        TextView bird_information = (TextView) findViewById(R.id.bird_information);
        bird_information.setText("Fågelfamilj: "+currentBirdCategory+"\nLängd: "+currentBirdSize+" cm");

        ImageView imageView = findViewById(R.id.bird_img);
        Picasso.get().load(currentBirdImg).into(imageView);

        //TextView bird_attribution - link to about page with cc attributions...

        // "Creative Commons 10th Birthday Celebration San Francisco" by tvol is licensed under CC BY 2.0

    }
}