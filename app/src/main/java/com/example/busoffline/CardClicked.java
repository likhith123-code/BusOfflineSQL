package com.example.busoffline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CardClicked extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_clicked);
        Intent in = getIntent();
        String data = in.getStringExtra("data");
        String display[] = data.split(",");
        String text="";
        for(String s:display){
            text = text+s+"\n\n";
        }
        int num = text.length();
        text = text.substring(1,num-3);
        t1= (TextView)findViewById(R.id.datadisplay);
        t1.setText(text);

    }
}