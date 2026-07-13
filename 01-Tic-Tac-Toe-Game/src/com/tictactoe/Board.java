package com.tictactoe;

/**
 * Represents the 3x3 Tic-Tac-Toe board.
 * Slots are numbered 1-9 until a player claims them with an "X" or "O".
 */

public class Board {

	private String[] cells;
	 
    public Board() {
        cells = new String[9];
        reset();
    }
 
    /** Resets the board so every slot shows its own number (1-9). */
    public void reset() {
        for (int i = 0; i < 9; i++) {
            cells[i] = String.valueOf(i + 1);
        }
    }
 
    /** Returns true if the given slot (1-9) has not been claimed yet. */
    public boolean isSlotAvailable(int slot) {
        return cells[slot - 1].equals(String.valueOf(slot));
    }
 
    /** Places the given mark ("X" or "O") in the given slot (1-9). */
    public void placeMark(int slot, String mark) {
        cells[slot - 1] = mark;
    }
 
    public String[] getCells() {
        return cells;
    }
 
    /** Prints the board to the console. */
    public void print() {
        System.out.println("|---|---|---|");
        System.out.println("| " + cells[0] + " | " + cells[1] + " | " + cells[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + cells[3] + " | " + cells[4] + " | " + cells[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + cells[6] + " | " + cells[7] + " | " + cells[8] + " |");
        System.out.println("|---|---|---|");
    }
    
}
