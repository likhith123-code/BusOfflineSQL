package com.example.busoffline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String placesNames[] = new String[]{
            "Five Star Chowrangi",
            "UP Mor",
            "Hydri Market",
            "Power House",
           " Surjani Town",
            "Mazar-e-Quaid",
           " Nagan Chowrangi",
            "Business Recorder Road",
            "Nazimabad Board",
            "Golimar",
            "Guru Mandar",
            "Nagan Chowrangi",
            "Nazimabad Board Office",
           " Jama Cloth Market",
            "Numaish"
    };
    AutoCompleteTextView e1,e2;
    RecyclerView recyclerView;
    ArrayList<String> busnumb;
    ArrayList<String> froms;
    ArrayList<String> tos;
    ArrayList<String> routes;
    BusDataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (AutoCompleteTextView) findViewById(R.id.source);
        e2 = (AutoCompleteTextView) findViewById(R.id.destination);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        busnumb = new ArrayList<>();
        froms = new ArrayList<>();
        tos = new ArrayList<>();
        routes= new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,placesNames
                );
        e1.setAdapter(arrayAdapter);
        e2.setAdapter(arrayAdapter);
    }

    public void getroutes(View view) {
            DatabaseAccess databaseAccess =DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess.open();

             String from = e1.getText().toString().trim();
            String to = e2.getText().toString().trim();
            Cursor busdata = databaseAccess.getBusData(from,to);
            if(busdata.getCount()==0){
                Toast.makeText(this, "Not Found", Toast.LENGTH_LONG).show();
            }
            else{
                while(busdata.moveToNext()){
                    busnumb.add(busdata.getString(0));
                    froms.add(busdata.getString(1));
                    tos.add(busdata.getString(2));
                    routes.add(busdata.getString(3));
                }
            }
            adapter = new BusDataAdapter(MainActivity.this,busnumb,froms,tos,routes);
            recyclerView.setAdapter(adapter);
            e1.setText("");
            e2.setText("");
            databaseAccess.close();
    }
}