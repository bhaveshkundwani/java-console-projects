# Tic-Tac-Toe (Java Console Game)

A simple two-player Tic-Tac-Toe game that runs in the console, built in Java.
Players take turns placing **X** and **O** on a 3x3 grid and try to get
three marks in a row — horizontally, vertically, or diagonally.

This is the first project in my console-java-projects repository.

## Features

- 3x3 board, with slots numbered 1-9 for easy position selection
- Two players take turns entering a slot number to place their mark
- Board reprints after every move
- Detects a win on any row, column, or diagonal
- Detects a draw when the board fills up with no winner
- Handles invalid input (out-of-range numbers, non-numeric input, taken slots)

## Game Board Layout

```
|---|---|---|
| 1 | 2 | 3 |
|-----------|
| 4 | 5 | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
```

## How to Play

1. Player **X** always goes first.
2. On your turn, enter the number of the slot where you want to place your mark.
3. Players alternate turns (X, then O, then X, ...) until either:
    - One player fills a full row, column, or diagonal with their mark — they win, or
    - The board fills up with no winner — the game ends in a draw.

### Sample turn

**Input:** `3`

```
|---|---|---|
| 1 | 2 | X |
|-----------|
| 4 | 5 | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
```

**Input:** `5`

```
|---|---|---|
| 1 | 2 | X |
|-----------|
| 4 | O | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
```

...and so on until someone wins or the board fills up.

## Project Structure

```
01-Tic-Tac-Toe/
├── README.md
└── src/
    └── com.tictactoe/
        ├── Board.java   # Board state, mark placement, printing
        ├── Game.java    # Turn tracking, move validation, win/draw detection
        └── Main.java    # Console entry point (I/O loop)
```

The game logic is split into three focused classes:

- **`Board`** – Owns the 9-cell grid and knows how to place marks and print itself.
- **`Game`** – Owns the current turn, validates moves, and checks for a winner.
- **`Main`** – Wires everything together and handles reading input from the console.

## Concepts Used

- **Arrays** – The board is stored as a `String[9]`, initialized with slot numbers `1`-`9`.
- **Conditionals (`if`, `switch`/loop over win lines)** – Used to validate moves,
  alternate turns, and check all 8 possible winning combinations (3 rows, 3
  columns, 2 diagonals).

## Sample Output

```
Welcome to 3x3 Tic Tac Toe.
|---|---|---|
| 1 | 2 | 3 |
|-----------|
| 4 | 5 | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
X will play first. Enter a slot number to place X in:
3
|---|---|---|
| 1 | 2 | X |
|-----------|
| 4 | 5 | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
O's turn; enter a slot number to place O in:
5
|---|---|---|
| 1 | 2 | X |
|-----------|
| 4 | O | 6 |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
X's turn; enter a slot number to place X in:
6
|---|---|---|
| 1 | 2 | X |
|-----------|
| 4 | O | X |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
O's turn; enter a slot number to place O in:
1
|---|---|---|
| O | 2 | X |
|-----------|
| 4 | O | X |
|-----------|
| 7 | 8 | 9 |
|---|---|---|
X's turn; enter a slot number to place X in:
9
|---|---|---|
| O | 2 | X |
|-----------|
| 4 | O | X |
|-----------|
| 7 | 8 | X |
|---|---|---|
Congratulations! Player X wins! Thanks for playing.
```