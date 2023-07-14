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

public class chemicalferllizer extends AppCompatActivity {

    private String[][] packages={

            {"1: Cow Manure.NPK Ratio: 0.5-0.5","","","","399"},
            {"2: Corn Gluten Meal.NPK Ratio: 9-0-0.","","","","499"},
            {"3: Earthworm Castings.NPK Ratio: 2-1-1..","","","","899"},
            {"4: Poultry Manure NPK Ratio:5-3","","","","499"},
            {"5: Alfalfa Meal.NPK Ratio: 2-0-1.","","","","699"}

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemicalferllizer);

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
                Intent it = new Intent(getApplicationContext(),workshopbook.class);
                startActivity(it);
            }
        });

    }
}
