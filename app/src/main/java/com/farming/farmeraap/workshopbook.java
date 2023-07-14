package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.farming.farmeraap.R;

public class workshopbook extends AppCompatActivity {

    EditText edname,edaddress,edcontact,edpincode;
    Button btnbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshopbook);
        edname = findViewById(R.id.cartname);
        edaddress = findViewById(R.id.cartaddress);
        edcontact = findViewById(R.id.cartcontact);
        edpincode = findViewById(R.id.cartpin);
        btnbook= findViewById(R.id.cartbtnbook);


        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = getSharedPreferences ("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username", "").toString();
                database db = new database(getApplicationContext(), "healthcare", null, 1);
                db.addorder(edname.getText().toString(), username, edaddress.getText().toString(), edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()),"lab");
                db.removecart(username, "lab");
                Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }
}