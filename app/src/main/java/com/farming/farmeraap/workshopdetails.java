package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.farming.farmeraap.R;

public class workshopdetails extends AppCompatActivity {

    TextView tvpackagename, tvtotalcost;
    EditText eddetails;
    Button btnaddtocart, btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshopdetails);

        tvtotalcost = findViewById(R.id.texttotalcost);
        eddetails = findViewById(R.id.edittextmultiline);
        tvpackagename = findViewById(R.id.lbdtextviewpachage);
        btnback = findViewById(R.id.lbdbtnBack);
        btnaddtocart = findViewById(R.id.lbdgotocheck);


        eddetails.setKeyListener(null);
        Intent intent = getIntent();
        tvpackagename.setText(intent.getStringExtra("text1"));
        eddetails.setText(intent.getStringExtra("text2"));
        tvtotalcost.setText("Total Cost : " + intent.getStringExtra("text3") + "/-");


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), workshop.class));
            }
        });
        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), workshopbook.class);
                startActivity(it);
            }

        });

    }
}
