package com.quiz.interfaces;

/**
 * Defines what a quiz should be able to do: start, accept answers,
 * and show results.
 */
public interface Quiz {

	void start();
    void submitAnswer(int questionIndex, String answer);
    void showResults();
    
}
