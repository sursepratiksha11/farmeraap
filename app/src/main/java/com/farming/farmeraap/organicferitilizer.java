package com.farming.farmeraap;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.farming.farmeraap.R;

import java.util.ArrayList;

public class organicferitilizer extends AppCompatActivity {

   // String[] fertilizer = {"Cow Manure.NPK Ratio: 0.5-0.5-0.5.", "Corn Gluten Meal.NPK Ratio: 9-0-0.", "Earthworm Castings.NPK Ratio: 2-1-1..",
     //       "Poultry Manure NPK Ratio:5-3", "Greensand.NPK Ratio: 1-", "Alfalfa Meal.NPK Ratio: 2-0-1."};
ListView listView;
int[] arrno = new int[]{1,2,3,4,5};
ArrayList<String> arrname = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organicferitilizer);
        listView= findViewById(R.id.listview);
          arrname.add("Cow Manure.NPK Ratio: 0.5-0.5-0.5");
          arrname.add("Corn Gluten Meal.NPK Ratio: 9-0-0.");
          arrname.add("Earthworm Castings.NPK Ratio: 2-1-1..");
          arrname.add("Poultry Manure NPK Ratio:5-3");
          arrname.add("Greensand.NPK Ratio: 1-");
          arrname.add("Alfalfa Meal.NPK Ratio: 2-0-1.");

          ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrname);
          listView.setAdapter(adapter);
    }
}
