package studio8;

import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class Quiz {
	private Question[] Question;
	/**
	 * Constructor
	 * @param questions
	 */
	public Quiz(Question[] questions) {
	this.Question = questions;
		
		
	}
	
	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * @param in
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	/**
	 * Gets the number of points possible in the quiz.
	 * @return int number of total points
	 */
	public int getTotalPoints() {
		int totalPoints = 0;
		for (int i = 0; i<this.Question.length; i++) {
			totalPoints+=Question[i].getPoints();
		}
		return totalPoints;
	}
	
	/**
	 * Asks the user all question in the quiz, then prints out 
	 * the amount of points the user earned. This print statement
	 * should include "You earned ____ points"
	 * 
	 * @param in Scanner object to feed into getUserAnswer
	 */
	public void takeQuiz(Scanner in) {
		int totalPoints = 0;
		for (int i = 0; i< this.Question.length; i++) {
			totalPoints+=Question[i].checkAnswer(getUserAnswer(in));
		}
		System.out.println("You earned " + totalPoints + " points.");
	}
	
	
	public static void main(String[] args) {
		Question question1 = new Question("What is 1+1?", "2", 2);
		Question question2 = new Question("What is 1+2?", "2", 2);
		Question[] questions = {question1, question2};
		Quiz newQuiz = new Quiz(questions);
	}
}
