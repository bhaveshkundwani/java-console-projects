# Online Quiz System (Java Console App)

A console-based multiple-choice quiz application built in Java. The quiz asks a series of questions, records the user's answers, checks them against the correct answers, and displays a final score.

This is the fourth project in my console-java-projects repository.

## How It Works

- The quiz contains multiple-choice questions, each with four options.

- The user selects an option (by number) as their answer.

- The program records each answer, checks it against the correct answer, and calculates a final score.

- At the end, it displays the total score out of the number of questions.


## Project Structure

The project follows a simple interface → model → service → main layering:

```

04-Online-Quiz-System/
├── README.md
└── src/
    └── com.quiz/
        ├── interfaces/
        │   └── Quiz.java           # Contract: start, submitAnswer, showResults
        ├── models/
        │   └── Question.java       # A single question: text, options, correct answer
        ├── services/
        │   └── QuizService.java    # Implements Quiz — runs the quiz and scores it
        └── Main.java               # Program entry point
```

## Key Concepts Used

- \*\*Interfaces\*\* – `Quiz` defines the contract that `QuizService` implements, keeping the "what" (start a quiz, submit an answer, show results) separate from the "how."

- \*\*Packages\*\* – code is organized into `quiz.interfaces`, `quiz.models`, and `quiz.services` to keep responsibilities separated.

- \*\*Arrays\*\* – each question's options are stored in a `String\[]`, and all questions are stored in a `Question\[]`.

- \*\*Exception handling\*\* – `Integer.parseInt()` is wrapped in a `try/catch` to gracefully handle non-numeric input.


## Sample Output

```

Welcome to the Online Quiz!
Q1: What is the size of an int data type in Java??

1. 8 bit
2. 16 bit
3. 32 bit
4. 64 bit
Enter your answer (1-4): 3


Q2: Which method is the entry point of a Java program?

1. start()
2. main()
3. run()
4. init()
Enter your answer (1-4): 2


Q3: Which of these is NOT a valid access modifier in Java?

1. public
2. private
3. protected
4. package
Enter your answer (1-4): 1


Quiz Completed!
Your score: 2 out of 3

```

### Handling invalid input

If the user enters something out of range or non-numeric (e.g. `5` or `"five"`), the app records a blank answer for that question instead of crashing:

```
Enter your answer (1-4): fiv
Invalid input, answer recorded as blank.

```

```
Enter your answer (1-4): 9
Invalid option, answer recorded as blank.

```

A blank answer never matches a correct answer, so that question is simply scored as wrong rather than stopping the quiz.