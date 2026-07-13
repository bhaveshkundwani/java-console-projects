package com.tictactoe;

/**
 * Drives the Tic-Tac-Toe game logic: whose turn it is, whether a move
 * is legal, and whether the game has been won or drawn.
 */

public class Game {

	private Board board;
    private String turn;
 
    // All 8 winning combinations: 3 rows, 3 columns, 2 diagonals.
    private static final int[][] WIN_LINES = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
        {0, 4, 8}, {2, 4, 6}             // diagonals
    };
 
    public Game() {
        board = new Board();
        turn = "X";
    }
 
    public Board getBoard() {
        return board;
    }
 
    public String getTurn() {
        return turn;
    }
 
    /** Returns true if the slot number is within the 1-9 range. */
    public boolean isSlotValid(int slot) {
        return slot > 0 && slot <= 9;
    }
 
    public boolean isSlotAvailable(int slot) {
        return board.isSlotAvailable(slot);
    }
 
    /** Places the current player's mark and passes the turn to the other player. */
    public void playMove(int slot) {
        board.placeMark(slot, turn);
        turn = turn.equals("X") ? "O" : "X";
    }
 
    /**
     * Checks the board for a winner.
     *
     * @return "X" or "O" if that player has won, "draw" if the board is
     *         full with no winner, or null if the game should continue.
     */
    public String checkWinner() {
        String[] cells = board.getCells();
 
        for (int[] line : WIN_LINES) {
            String combo = cells[line[0]] + cells[line[1]] + cells[line[2]];
            if (combo.equals("XXX")) return "X";
            if (combo.equals("OOO")) return "O";
        }
 
        for (int i = 0; i < 9; i++) {
            if (cells[i].equals(String.valueOf(i + 1))) {
                return null; // an empty slot remains, game continues
            }
        }
 
        return "draw";
    }
    
}
