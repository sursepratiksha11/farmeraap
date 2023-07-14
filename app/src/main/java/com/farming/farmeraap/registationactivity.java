package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.farming.farmeraap.R;

public class registationactivity extends AppCompatActivity {

    EditText rusername,rpassword,remail,rconpass;
    Button regbtn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registationactivity);

        rusername = findViewById(R.id.regusername);
        remail= findViewById(R.id.regemail);
        rpassword= findViewById(R.id.regpassword);
        rconpass= findViewById(R.id.regconpassword);

        regbtn= findViewById(R.id.regregister);
        tv= findViewById(R.id.regtextView3);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),loginactivity.class));
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = rusername.getText().toString();
                String email = remail.getText().toString();
                String password = rpassword.getText().toString();
                String conpassword = rconpass.getText().toString();
                database db = new database(getApplicationContext(),"farmer",null,1);
                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || conpassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Fill All Detail", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(conpassword) == 0) {
                        if(isvilid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),loginactivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password contains At least 8 charecters ",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm-password Didnt`t match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isvilid(String passwordhere){
        int f1=0,f2=0,f3=0;

        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter (passwordhere.charAt(p))) {
                    f1=1;
                }
            }

            for (int r = 8; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2=1;

                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c=passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64) {
                    f3 = 1;
                }
            }

            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}