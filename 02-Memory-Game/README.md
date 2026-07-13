# Memory Game (Java Console Game)

A simple two-player Memory (card-matching) game that runs in the console,
built in Java. Cards are laid face down; players flip two at a time trying
to find matching pairs. The game continues until all pairs are found.

This is the second project in my console-java-projects repository.

## Features

- 8 cards (4 matching pairs), randomly shuffled every game
- Cards are shown as a row of numbered slots (0-7)
- Flip two cards per turn — matches stay face up, mismatches flip back down
- Board reprints after every flip so you can track progress
- Handles invalid input (out-of-range index, re-flipping an already-revealed card)

## Game Board Layout

Cards start face down, shown as blank slots:

```
|   |   |   |   |   |   |   |   |
```

As cards are flipped, their values appear in place. Matched pairs stay
visible; unmatched pairs flip back to blank.

## How to Play

1. The board has 4 pairs of cards (8 total), shuffled at the start of the game.
2. On your turn, enter the index of the first card to flip, then the index
   of the second card to flip.
3. If the two values match, they stay face up and count toward your pairs found.
4. If they don't match, both cards flip back down.
5. The game ends once all 4 pairs have been found.

### Sample turn

**Input:** `0`

```
| B |   |   |   |   |   |   |   |
```

**Input:** `1`

```
| B | A |   |   |   |   |   |   |
```
```
Sorry, those cards don't match.
|   |   |   |   |   |   |   |   |
```

...and so on until all 4 pairs are found.

## Project Structure

```
02-Memory-Game/
├── README.md
└── src/
    └── com.memorygame/
        ├── Deck.java    # Shuffled card values (the "answer key")
        ├── Board.java   # Visible board state, flip/hide, printing
        ├── Game.java    # Move validation, match checking, win tracking
        └── Main.java    # Console entry point (I/O loop)
```

The game logic is split into four focused classes:

- **`Deck`** – Builds the 4 pairs of cards and shuffles them once at startup.
- **`Board`** – Owns what's currently shown on screen (blank, or a revealed value).
- **`Game`** – Owns the rules: valid indices, match checking, and pairs-found tracking.
- **`Main`** – Wires everything together and handles reading input from the console.

## Key Concepts Used

- **`ArrayList<String>`** – Stores and shuffles the 8 card values (`Deck`).
- **`String[]` array** – Represents the visible board state (`Board`).
- **`boolean[]` array** – Tracks which cards are currently flipped (`Board`).
- **`Collections.shuffle()`** – Randomizes card positions at the start of each game.

## Sample Output

```
Welcome to the Memory Game!
|   |   |   |   |   |   |   |   |
Enter index of first card to flip:
0
| B |   |   |   |   |   |   |   |
Enter index of second card to flip:
1
| B | A |   |   |   |   |   |   |
Sorry, those cards don't match.
|   |   |   |   |   |   |   |   |
Enter index of first card to flip:
6
|   |   |   |   |   |   | D |   |
Enter index of second card to flip:
5
|   |   |   |   |   | D | D |   |
You found a pair!
|   |   |   |   |   | D | D |   |
...
Congratulations, you won!
```