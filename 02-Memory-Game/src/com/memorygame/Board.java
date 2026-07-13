package com.memorygame;

import java.util.Arrays;

/**
 * Represents the row of card slots shown to the player.
 * A slot shows a blank space until it has been flipped, at which point
 * it shows the card's value.
 */
public class Board {

	private String[] cells;
    private boolean[] flipped;
 
    public Board(int size) {
        cells = new String[size];
        Arrays.fill(cells, " ");
        flipped = new boolean[size];
    }
 
    public int size() {
        return cells.length;
    }
 
    /** Returns true if the card at this index is currently face up. */
    public boolean isFlipped(int index) {
        return flipped[index];
    }
 
    /** Flips a card face up, showing its value. */
    public void reveal(int index, String value) {
        cells[index] = value;
        flipped[index] = true;
    }
 
    /** Flips a card back face down. */
    public void hide(int index) {
        cells[index] = " ";
        flipped[index] = false;
    }
 
    /** Prints the current state of the board to the console. */
    public void print() {
        for (String value : cells) {
            System.out.print("| " + value + " ");
        }
        System.out.println("|");
    }
    
}
