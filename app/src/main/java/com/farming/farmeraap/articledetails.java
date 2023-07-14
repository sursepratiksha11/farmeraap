package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.farming.farmeraap.R;

public class articledetails extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articledetails); img = findViewById(R.id.imageview);
        btnback = findViewById(R.id.helthbtnback1);
        tv1= findViewById(R.id.textview_title);

        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int resid = bundle.getInt("text2");
            img.setImageResource(resid);
        }

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),article.class));
            }
        });

    }
}