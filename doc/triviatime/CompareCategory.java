/** File name: CompareCategory.java
	• Author: Gabriel Cardoso Maia, 040891553
	• Course: CST8132 – OOP
	• Assignment: 02
	• Date: 13/04
	• Professor: Dave Houtman
	• Purpose: This class was created to make the comparison between the QA objects and
	•			organize them by category
*/
package cst8284.triviatime;

import java.util.Comparator;
/**
 * This class was created to make the comparison between the QA objects and	organize then by category
 * @author Gabriel Cardoso Maia
 * @version 1
 * @see java.util.Comparator
 * @since Java 1.8.0_171
 */
public class CompareCategory implements Comparator<QA> { 
	 
	/**
	 * method used to compare the questions and return the object based on the category
	 * @param o1	the first object of the type QA 
	 * @param o2	the second object of the type QA 
	 * @return 		the result of the comparison between o1 and o2 based on the category of the objects
	 */
	@Override
	public int compare(QA o1, QA o2) {
		return o1.getCategory().compareTo(o2.getCategory());
	}
}