/** File name: FileUtils.java
	• Author: Gabriel Cardoso Maia, 040891553
	• Course: CST8132 – OOP
	• Assignment: 02
	• Date: 13/04
	• Professor: Dave Houtman
	• Purpose: This class was created to make to get the file selected by the user and put the information
	•	inside an ArrayList of type QA
*/
package cst8284.triviatime;

import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * This class was created to get the user's selected .trivia file and separate the question
 * @author Gabriel Cardoso Maia
 * @version 1
 * @see javafx.stage.Stage;
 * @see javafx.stage.FileChooser;
 * @see javafx.stage.FileChooser.ExtensionFilter;
 * @see java.io.File;
 * @see java.io.FileInputStream;
 * @see java.io.IOException;
 * @see java.io.ObjectInputStream;
 * @see java.util.ArrayList;
 * @since Java 1.8.0_171
 */
public class FileUtils {
	/**
	 * Holds all the QA objects created by .trivia file
	 */
	private static ArrayList<QA> qaAL;

	/**
	 * method used to select the file that is going to be used in the game
	 * @param primaryStage window used by the user to select the file
	 * @return file that is going to be used in the game
	 */
	public static File getFileHandle(Stage primaryStage) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Open Trivia File");
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Trivia Files", "*.trivia"),
				new ExtensionFilter("All Files", "*.*")
		);
		File trivFile = fc.showOpenDialog(primaryStage);
		return (trivFile);
	}

	/**
	 * method used to initialize the ArrayList with the QA objects
	 * @param absPath the full address of where the file is located
	 */
	public static void setQAArrayList(String absPath) {
		qaAL = new ArrayList<QA>();
		if (fileExists(absPath)) {
			try {
				FileInputStream fis = new FileInputStream(absPath);
				
				@SuppressWarnings("resource")
				ObjectInputStream ois = new ObjectInputStream(fis);
				while(true) {
					qaAL.add((QA) (ois.readObject()));
					
				}
				
			} catch (IOException | ClassNotFoundException e) {} 
			
		}
		else { 
			qaAL = null;
		}
		
	}
	
	/**
	 * method used to retrieve the list of QA objects
	 * @return the list of QA objects
	 */
	public static ArrayList<QA> getQAArrayList() {return qaAL;}
	
	/**
	 * method used to check if the file exists
	 * @param f file that is going to be checked
	 * @return boolean that shows if all the basic properties of are good for the program
	 */
	public static boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead() && (f.length() > 2));
	}

	/**
	 * method used to check if the file exists
	 * @param s name of the file that is going to be checked
	 * @return boolean that shows if the file exists or not
	 */
	public static boolean fileExists(String s) {
		return (fileExists(new File(s)));
	}
	
	/**
	 * method used to return the full address of the file
	 * @param f file that is going to be used
	 * @return the full address of the file
	 */
	public static String getAbsPath(File f) {
		return f.getAbsolutePath();
	}

}
