package com.example.user.wordcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 08/11/2016.
 */

public class Frequencies extends AppCompatActivity{

    HashMap<String, Integer> listItems;
    String[] words;
    int[] counts;
    HashMap<String, TextView> textViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_frequencies);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.testing).getParent();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        words = extras.getStringArray("columnWord");
        counts = extras.getIntArray("columnCount");
        textViews = new HashMap<>();
        int wordsLength = words.length;
        for (int i = 0; i < wordsLength; i++){
            TextView tempTextView = new TextView(Frequencies.this);
            tempTextView.setPaddingRelative(20, 0, 0, 0);
            String countString = words[i] + " - " + Integer.toString(counts[i]);
            tempTextView.setText(countString);
            linearLayout.addView(tempTextView);
        }




//        for (String word : columns){
//            textViews.put(word, new TextView(Frequencies.this));
//        }
//        for (TextView tv: textViews.keySet()) {
//            tv.setText("a");
//            linearLayout.addView(tv);
//        }

    }


}
