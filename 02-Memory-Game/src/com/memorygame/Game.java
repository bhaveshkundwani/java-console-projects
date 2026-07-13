package com.memorygame;

/**
 * Drives the Memory Game logic: validates flips, checks for matches,
 * and tracks how many pairs have been found.
 */
public class Game {

	private static final int TOTAL_PAIRS = 4;
	 
    private Deck deck;
    private Board board;
    private int pairsFound;
 
    public Game() {
        deck = new Deck();
        board = new Board(deck.size());
        pairsFound = 0;
    }
 
    public Board getBoard() {
        return board;
    }
 
    public boolean isWon() {
        return pairsFound >= TOTAL_PAIRS;
    }
 
    public boolean isIndexValid(int index) {
        return index >= 0 && index < board.size();
    }
 
    public boolean isCardAvailable(int index) {
        return !board.isFlipped(index);
    }
 
    /** Flips the card at the given index face up. */
    public void flip(int index) {
        board.reveal(index, deck.valueAt(index));
    }
 
    public boolean isMatch(int firstIndex, int secondIndex) {
        return deck.valueAt(firstIndex).equals(deck.valueAt(secondIndex));
    }
 
    public void confirmMatch() {
        pairsFound++;
    }
 
    /** Flips both cards back face down after a failed match attempt. */
    public void hideMismatch(int firstIndex, int secondIndex) {
        board.hide(firstIndex);
        board.hide(secondIndex);
    }
    
}
