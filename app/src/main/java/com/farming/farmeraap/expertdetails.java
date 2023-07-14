package com.farming.farmeraap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.farming.farmeraap.R;

import java.util.ArrayList;
import java.util.HashMap;

public class expertdetails extends AppCompatActivity {
    public String[][] farmer_details1 ={
            {"Expert Name: Ajit deste","Expert Address:Pimpri","Exp 5yer","Mobile No:9898984898","800"},
            {"Expert  Name: Prasad Pasar", "Expert Address: Miod", "Exp: 15yrs", "Mobile No:7898989890", "900"},
            {"Expert  Name: Smounds Rate", "Expert Adress: Puna", "Exp 5yrs", "Mobile No:9898984898", "300"},
            {"Expert  name: Deepak Destimakh", "Expert Address:  thinchaad", "Exp Aves","Mobile No:9998584808","500"},
            {"Expert  Name: Ashow Panda", "Expert Address:Natraj", "Exp 7yrs", "Mobile No:7798989898", "800"}
    };

    public String[][] farmer_details2 ={
            {"Expert  Name: Ajit deste","Expert Address:Pimpri","Exp 5yer","Mobile No:9898984898","800"},
            {"Expert  Name: Prasad Pasar", "Expert Address: Miod", "Exp: 15yrs", "Mobile No:7898989890", "900"},
            {"Expert  Name: Smounds Rate", "Expert Adress: Puna", "Exp 5yrs", "Mobile No:9898984898", "300"},
            {"Expert  name: Deepak Destimakh", "Expert Address:  thinchaad", "Exp Aves","Mobile No:9998584808","500"},
            {"Expert  Name: Ashow Panda", "Expert Address:Natraj", "Exp 7yrs", "Mobile No:7798989898", "800"}

    };

    public String[][] farmer_details3 ={
            {"Expert  Name: Ajit deste","Expert Address:Pimpri","Exp 5yer","Mobile No:9898984898","800"},
            {"Expert  Name: Prasad Pasar", "Expert Address: Miod", "Exp: 15yrs", "Mobile No:7898989890", "900"},
            {"Expert  Name: Smounds Rate", "Expert Adress: Puna", "Exp 5yrs", "Mobile No:9898984898", "300"},
            {"Expert  name: Deepak Destimakh", "Expert Address:  thinchaad", "Exp Aves","Mobile No:9998584808","500"},
            {"Expert  Name: Ashow Panda", "Expert Address:Natraj", "Exp 7yrs", "Mobile No:7798989898", "800"}

    };
    public String[][] farmer_details4 ={
            {"Expert  Name: Ajit deste","Expert Address:Pimpri","Exp 5yer","Mobile No:9898984898","800"},
            {"Expert  Name: Prasad Pasar", "Expert Address: Miod", "Exp: 15yrs", "Mobile No:7898989890", "900"},
            {"Expert  Name: Smounds Rate", "Expert Adress: Puna", "Exp 5yrs", "Mobile No:9898984898", "300"},
            {"Expert  name: Deepak Destimakh", "Expert Address:  thinchaad", "Exp Aves","Mobile No:9998584808","500"},
            {"Expert  Name: Ashow Panda", "Expert Address:Natraj", "Exp 7yrs", "Mobile No:7798989898", "800"}

    };
    public String[][] farmer_details5 ={
            {"Expert  Name: Ajit deste","Expert Address:Pimpri","Exp 5yer","Mobile No:9898984898","800"},
            {"Expert  Name: Prasad Pasar", "Expert Address: Miod", "Exp: 15yrs", "Mobile No:7898989890", "900"},
            {"Expert  Name: Smounds Rate", "Expert Adress: Puna", "Exp 5yrs", "Mobile No:9898984898", "300"},
            {"Expert  name: Deepak Destimakh", "Expert Address:  thinchaad", "Exp Aves","Mobile No:9998584808","500"},
            {"Expert  Name: Ashow Panda", "Expert Address:Natraj", "Exp 7yrs", "Mobile No:7798989898","800"}

    };
    TextView tv;
    Button btn;
    String[][] Farmer_details={};
    HashMap<String,String> item;
    ArrayList list;
    ListView lst;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expertdetails);
        tv= findViewById(R.id.textviewDDtitle);
        btn =findViewById(R.id.buttonDDBack);
        lst = findViewById(R.id.listviewdd);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            Farmer_details=farmer_details1;
        else
        if(title.compareTo("Dietician")==0)
            Farmer_details =farmer_details2;
        else
        if(title.compareTo("Dentist")==0)
            Farmer_details=farmer_details3;
        else
        if(title.compareTo("Surgeon")==0)
            Farmer_details=farmer_details4;
        else
            Farmer_details=farmer_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),informationactivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<Farmer_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",Farmer_details[i][0]);
            item.put("line2",Farmer_details[i][1]);
            item.put("line3",Farmer_details[i][2]);
            item.put("line4",Farmer_details[i][3]);
            item.put("line5","Cons fees "+Farmer_details[i][4]+"/-");
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,R.layout.multi_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(getApplicationContext(),bookexpert.class);
                it.putExtra("text1",title);
                it.putExtra("text2",Farmer_details[i][0]);
                it.putExtra("text3",Farmer_details[i][1]);
                it.putExtra("text4",Farmer_details[i][3]);
                it.putExtra("text5",Farmer_details[i][4]);
                startActivity(it);
            }
        });

    }
}