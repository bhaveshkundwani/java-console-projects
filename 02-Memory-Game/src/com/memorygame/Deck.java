package com.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Holds the hidden values of every card in the game, shuffled into a
 * random order. This is the "answer key" the Board reveals from.
 */
public class Deck {

	private List<String> cards;
	 
    public Deck() {
        cards = new ArrayList<>();
 
        // 4 matching pairs
        String[] values = {"A", "B", "C", "D"};
        for (String value : values) {
            cards.add(value);
            cards.add(value);
        }
 
        Collections.shuffle(cards);
    }
 
    public String valueAt(int index) {
        return cards.get(index);
    }
 
    public int size() {
        return cards.size();
    }
    
}
