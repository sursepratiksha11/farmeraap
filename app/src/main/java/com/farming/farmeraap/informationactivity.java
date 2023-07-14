package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.farming.farmeraap.R;

public class informationactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationactivity);

        CardView exit = findViewById(R.id.cardback);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        CardView fruit = findViewById(R.id.fruit);
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),expertdetails.class);
                it.putExtra("title","Fruits");
                startActivity(it);
            }
        });

        CardView vegetable = findViewById(R.id.vegetable);
        vegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),expertdetails.class);
                it.putExtra("title","Vegetable");
                startActivity(it);
            }
        });

        CardView flower = findViewById(R.id.flower);
        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),expertdetails.class);
                it.putExtra("title","Flowers");
                startActivity(it);
            }
        });

        CardView grain = findViewById(R.id.grain);
        grain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),expertdetails.class);
                it.putExtra("title","Grain");
                startActivity(it);
            }
        });
        CardView other = findViewById(R.id.other);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),expertdetails.class);
                it.putExtra("title","Other");
                startActivity(it);
            }
        });
    }
}