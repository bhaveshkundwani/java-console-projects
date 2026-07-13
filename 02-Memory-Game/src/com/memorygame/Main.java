package com.memorygame;

import java.util.Scanner;

/**
* Console entry point for the Memory Game.
*/
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        Game game = new Game();
 
        System.out.println("Welcome to the Memory Game!");
 
        while (!game.isWon()) {
            game.getBoard().print();
 
            int firstIndex = getCardIndex(scanner, game, "Enter index of first card to flip:");
            game.flip(firstIndex);
            game.getBoard().print();
 
            int secondIndex = getCardIndex(scanner, game, "Enter index of second card to flip:");
            game.flip(secondIndex);
            game.getBoard().print();
 
            if (game.isMatch(firstIndex, secondIndex)) {
                System.out.println("You found a pair!");
                game.confirmMatch();
            } else {
                System.out.println("Sorry, those cards don't match.");
                game.hideMismatch(firstIndex, secondIndex);
            }
        }
 
        System.out.println("Congratulations, you won!");
        scanner.close();
    }
 
    private static int getCardIndex(Scanner scanner, Game game, String prompt) {
        int index;
        while (true) {
            System.out.println(prompt);
            index = scanner.nextInt();
 
            if (!game.isIndexValid(index)) {
                System.out.println("Invalid index, try again.");
            } else if (!game.isCardAvailable(index)) {
                System.out.println("Card already flipped, try again.");
            } else {
                break;
            }
        }
        return index;	
	}

}
