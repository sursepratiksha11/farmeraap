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

public class workshop extends AppCompatActivity {

    private String[][] packages={

            {"Package 1: Krishi Seeva","","","","299"},
            {"Package 2: Krishi Jagran","","","","299"},
            {"Package 3: AgriFarming","","","","899"},
            {"Package 4: Organic Farming Session","","","","499"},
            {"Package 5: Krishi Yatra","","","","699"}

    };
    private  String[] package_details={
            "purchases agricultural produce directly from farmers\n"+
                    "We help farmers to make more informed decisions\n"+
                    "focus on precision farming\n" +
                    "We envision making the lives of \n farmers easier and self-dependent.",
            "The captured and shared technical information is \n" +
                    "critical for farmers who are looking to mitigate \n" +
                    "the impact of climate change while maintaining sustainable\n" +
                    " and profitable agricultural practices.",
            "provides farmers with opportunities to network with \n" +
                    " other farmers, agriculture experts, and policymakers,\n" +
                    " and to share knowledge and best practices",
            "We are on a mission to drive the mass adoption of Digital Agriculture.\n" +
                    " We help farmers to make more informed decisions and focus on precision \n" +
                    "farming. We envision making the lives of farmers easier and self-dependent.\n",
            "we can help farmers manage their resources more efficiently \n" +
                    " and make informed decisions about planting, harvesting,\n and marketing their crops"


    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        btnback= findViewById(R.id.lbbtnBack);
        listView = findViewById(R.id.lblistviewdd);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost: "+packages[i][4]+"/-");
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,R.layout.multi_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});


        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(getApplicationContext(),workshopdetails.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}