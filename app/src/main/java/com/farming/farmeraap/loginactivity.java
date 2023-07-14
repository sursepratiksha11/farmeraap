package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.farming.farmeraap.R;

public class loginactivity extends AppCompatActivity {
    EditText usename,password1;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        usename = findViewById(R.id.username);
        password1= findViewById(R.id.password);
        tv= findViewById(R.id.textView3);
        btn = findViewById(R.id.loginbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(loginactivity.this,homeactivity.class));
                String username = usename.getText().toString();
                String password = password1.getText().toString();
                database db = new database(getApplicationContext(),"farmer",null,1);
                if (username.length() == 0 | password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Fill All details", Toast.LENGTH_SHORT).show();
                } else {
                   if(db.login(username,password)==1) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("share=prefrence", Context.MODE_PRIVATE);
                        SharedPreferences .Editor editor= sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(loginactivity.this,MainActivity.class));
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this,registationactivity.class));
            }
        });
    }
}