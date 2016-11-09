package com.example.user.wordcounter;

import java.util.HashMap;

/**
 * Created by user on 08/11/2016.
 */

public class CountWords {

    String mWords;
    HashMap<String, Integer> mWordFrequencies;

    public CountWords(String words){
        this.mWords = words;
    }

    public Integer getWordCount(){
        return mWords.split(" ").length;
    }

    public HashMap<String, Integer> getWordFrequencies(){
        HashMap<String, Integer> mWordFrequencies = new HashMap<String, Integer>();
        int currentCount;
        for (String word: mWords.split(" ")){
            currentCount = 1;
            if (mWordFrequencies.containsKey(word)) {
                currentCount = mWordFrequencies.get(word);
                currentCount++;
            }
            mWordFrequencies.put(word, currentCount);
        }
        return mWordFrequencies;
    }
}

