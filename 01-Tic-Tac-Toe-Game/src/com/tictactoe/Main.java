package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Console entry point for the 3x3 Tic-Tac-Toe game.
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        Game game = new Game();
        String winner = null;
 
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        game.getBoard().print();
        System.out.println("X will play first. Enter a slot number to place X in:");
 
        while (winner == null) {
            int slot;
 
            try {
                slot = in.nextInt();
 
                if (!game.isSlotValid(slot)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
 
                if (!game.isSlotAvailable(slot)) {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
 
                game.playMove(slot);
                game.getBoard().print();
 
                winner = game.checkWinner();
                if (winner == null) {
                    System.out.println(game.getTurn() + "'s turn; enter a slot number to place "
                        + game.getTurn() + " in:");
                }
 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter slot number:");
                in.nextLine(); // consume the invalid token to prevent an infinite loop
            }
        }
 
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
        	System.out.println("Congratulations! Player " + winner + " wins! Thanks for playing.");
        }
 
        in.close();
    }

}
