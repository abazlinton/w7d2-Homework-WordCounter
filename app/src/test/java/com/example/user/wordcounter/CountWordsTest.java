package com.example.user.wordcounter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 08/11/2016.
 */

public class CountWordsTest {

    CountWords countWords;

    @Before
    public void before(){
        countWords = new CountWords("This is is a a a test");
    }

    @Test
    public void canGetWordCount(){
        Integer i = 7;
        assertEquals(i, countWords.getWordCount());
    }

    @Test
    public void canGetWordFrequency(){
        assertEquals(3, countWords.getWordFrequencies().get("a").intValue());
    }


}
