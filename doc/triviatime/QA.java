/** File name: CompareDifficulty.java
	• Author: Gabriel Cardoso Maia, 040891553
	• Course: CST8132 – OOP
	• Assignment: 02
	• Date: 13/04
	• Professor: Dave Houtman
	• Purpose: This class was created to make the comparison between the QA objects and
	•			organize them by difficulty
*/
package cst8284.triviatime;

/**
 * This class was created to implement the methods provided by the abstract class QARequirements
 * @author Gabriel Cardoso Maia
 * @version 1
 * @see cst8284.triviatime
 * @since Oxygen.2 Release (4.7.2)
 */
@SuppressWarnings("serial")
public class QA extends QARequirements{
	
	private String question, category, explanation;
	private int correctAnswer, points, difficulty;
	private String[] answers;
	private boolean result;
	
	/**
	 * gets the question being hold by the QA object
	 * @return the question being hold 
	 */
	public String getQuestion(){return question;}
	/**
	 * sets the question that is going to be hold by the QA object
	 * @param question string that holds the question
	 */
	public void setQuestion(String question){this.question = question;}
	
	/**
	 * gets the group of possible answers for the QA objects
	 * @return group of possible answers
	 */
	public String[] getAnswers(){return answers;}
	
	/**
	 * sets the group of possible answers for the QA object
	 * @return group of possible answers to the question
	 */
	public void setAnswers(String[] answers){
		this.answers = answers;
	}
	
	/**
	 * gets the explanation for the QA object
	 * @return explanation for the QA object
	 */
	public String getExplanation() {return explanation;}
	
	/**
	 * sets the explanation for the QA object
	 * @param explanation string that holds the explanation for the question
	 */
	public void setExplanation(String explanation) {this.explanation = explanation;}
	
	/**
	 * gets the category of the QA object
	 * @return the category of the QA object
	 */
	public String getCategory(){return category;}
	
	/**
	 * set the category of the QA object
	 * @param category string that holds the category of the QA object
	 */
	public void setCategory(String category){this.category = category;}
	
	/**
	 * get the difficulty of the QA object
	 * @return the difficulty of the QA object
	 */
	public int getDifficulty(){return difficulty;}
	
	/**
	 * set the difficulty of the QA object
	 * @param difficulty int that holds the difficulty of the QA object
	 */
	public void setDifficulty(int difficulty){this.difficulty = difficulty;}
	
	/**
	 * get the amount of points of the QA object
	 * @return the amount of points of the QA object
	 */
	public int getPoints(){return points;}
	
	/**
	 * set the amount of points of the QA object
	 * @param points int that holds the amount of points of the QA object
	 */
	public void setPoints(int points){this.points = points;}
	
	/**
	 * get the correct answer for the QA object
	 * @return number of the correct answer for the QA object
	 */
	public int getCorrectAnswerNumber(){return correctAnswer;}
	
	/**
	 * set the correct answer for the QA object
	 * @param correctAnswer int that holds the number of the correct Answer for the QA object
	 */
	public void setCorrectAnswerNumber(int correctAnswer){this.correctAnswer = correctAnswer;}
	
	/**
	 * method used to set the result of the QA
	 * 
	 */
	public void setResult(boolean b){result = b;}
	
	/**
	 * method used to get result of the QA object
	 * @return answer to the question
	 */
	public boolean isCorrect(){return result;}
	
	/**
	 * Constructor of the QA object used to set all the attributes of the object
	 * @param q question of the QA 
	 * @param a array of answers of the QA
	 * @param category category of the QA
	 * @param explanation explanation for the question of the QA
	 * @param diff difficulty of the question of the QA
	 * @param points points received for getting the right choice of the QA
	 * @param correctAnswer number of the correct answer of the QA
	 */
	 public QA(String q, String[] a, String category, String explanation, int diff, int points, int correctAnswer){
		setQuestion(q);
		setAnswers(a);
		setCategory(category);
		setExplanation(explanation);
		setDifficulty(diff);
		setPoints(points);
		setCorrectAnswerNumber(correctAnswer);
	}

	
	
}
