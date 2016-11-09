package com.example.user.wordcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 08/11/2016.
 */

public class WordCounter extends AppCompatActivity {

    EditText mWordsEditText;
    TextView mWordsCountTextView;
    Button mCalculate, mFrequencies;
    CountWords countWords;


    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWordsEditText = (EditText) findViewById(R.id.words_edit);
        mWordsCountTextView = (TextView) findViewById(R.id.words_count);
        mCalculate = (Button) findViewById(R.id.calculate);
        mFrequencies = (Button) findViewById(R.id.frequencies);

        Log.d("WordCounter", mWordsEditText.getText().toString());
        createCalculateListener();
        createFrequenciesListener();
    }

    protected void createCalculateListener(){
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToCount = mWordsEditText.getText().toString();
                countWords = new CountWords(textToCount);
                mWordsCountTextView.setText(countWords.getWordCount().toString());
            }
        });
    }

    protected void createFrequenciesListener(){
        mFrequencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] columnWord = new String[countWords.getWordFrequencies().size()];
                int[] columnCount = new int[countWords.getWordFrequencies().size()];

                int counter = 0;
                for (String word : countWords.getWordFrequencies().keySet()) {
                    columnWord[counter] = word;
                    counter++;
                }
                counter = 0;
                for (Integer count: countWords.getWordFrequencies().values()){
                    columnCount[counter] = count;
                    counter++;
                }
                Intent intent = new Intent(WordCounter.this, Frequencies.class);
                intent.putExtra("columnWord", columnWord);
                intent.putExtra("columnCount", columnCount);
                startActivity(intent);

            }
        });
    }




}
