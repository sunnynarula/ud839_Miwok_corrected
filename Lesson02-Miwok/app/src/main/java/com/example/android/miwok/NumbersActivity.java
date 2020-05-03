package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        String[] words = new String[10];
        words[0] = "One";
        words[1] = "Two";
        words[2] = "Three";
        words[3] = "Four";
        words[4] = "Five";
        words[5] = "Six";
        words[6] = "Seven";
        words[7] = "Eight";
        words[8] = "Nine";
        words[9] = "Ten";
    }
}
