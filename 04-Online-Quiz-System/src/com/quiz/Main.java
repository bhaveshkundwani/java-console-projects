package com.quiz;

import com.quiz.models.Question;
import com.quiz.services.QuizService;

/**
 * Console entry point for the Online Quiz System.
 */
public class Main {

	public static void main(String[] args) {
		
		Question[] questions = new Question[] {
                new Question("What is the size of an int data type in Java??",
                        new String[] {"8 bit", "16 bit", "32 bit", "64 bit"}, "32 bit"),

                new Question("Which method is the entry point of a Java program?",
                        new String[] {"start()", "main()", "run()", "init()"}, "main()"),

                new Question("Which of these is NOT a valid access modifier in Java?",
                        new String[] {"public", "private", "protected", "package"}, "package"),
        };

        QuizService quiz = new QuizService(questions);

        quiz.start();
        quiz.showResults();
        
	}

}
