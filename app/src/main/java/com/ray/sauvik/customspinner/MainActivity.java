package com.ray.sauvik.customspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CountryItem> mcountryList;
    private CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        Spinner spinnerCountries = findViewById(R.id.Spinner_countries);

        mAdapter = new CountryAdapter(this, mcountryList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CountryItem clickedItem = (CountryItem) adapterView.getItemAtPosition(i);
                String ClickedCountryname = clickedItem.getCountryName();
                Toast.makeText(MainActivity.this, ClickedCountryname +"selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void initList(){
        mcountryList = new ArrayList<>();
        mcountryList.add(new CountryItem("Canada", R.drawable.canada));
        mcountryList.add(new CountryItem("India", R.drawable.india));
        mcountryList.add(new CountryItem("USA", R.drawable.usa));
        mcountryList.add(new CountryItem("China", R.drawable.china));
    }
}
