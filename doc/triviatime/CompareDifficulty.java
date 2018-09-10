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

import java.util.Comparator;
/**
 * This class was created to make the comparison between the QA objects and	organize them by difficulty
 * @author Gabriel Cardoso Maia
 * @version 1
 * @see java.util.Comparator
 * @since Java 1.8.0_171
 */
public class CompareDifficulty implements Comparator<QA> {
	
	/**
	 * method used to compare the questions and return the object based on the difficulty
	 * @param o1	the first object of the type QA 
	 * @param o2	the second object of the type QA 
	 * @return 		the result of the comparison between o1 and o2 based on the difficulty of the QA objects
	 */
	@Override
	 public int compare(QA o1, QA o2) {
		    return o1.getDifficulty() - o2.getDifficulty();
		  }
}