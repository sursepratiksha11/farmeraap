package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.farming.farmeraap.R;

import java.util.ArrayList;
import java.util.HashMap;

public class article extends AppCompatActivity {
    private  String[][] farmerdetails = {
            {"INFORMATION 1","","","","click More"},
            {"INFORMATION 2","","","","click More"},
            {"INFORMATION 3","","","","click More"},
            {"INFORMATION 4","","","","click More"},
            {"INFORMATION 5","","","","","click More"},
            {"INFORMATION 6","","","","","click More"}

    };

    private int[] image={
            R.drawable.one,
            R.drawable.six,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.seven
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnback;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        lst= findViewById(R.id.helthcartlistviewd);
        btnback= findViewById(R.id.helthbtnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        list= new ArrayList();
        for(int i=0;i<farmerdetails.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",farmerdetails[i][0]);
            item.put("line2",farmerdetails[i][1]);
            item.put("line3",farmerdetails[i][2]);
            item.put("line4",farmerdetails[i][3]);
            item.put("line5",farmerdetails[i][4]);
            list.add(item);
        }


        sa = new SimpleAdapter(this,list,R.layout.multi_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it = new Intent(getApplicationContext(),articledetails.class);
                it.putExtra("text1",farmerdetails[i][0]);
                it.putExtra("text2",image[i]);
                startActivity(it);
            }
        });


    }
}