/** File name: Controls.java
	• Author: Gabriel Cardoso Maia, 040891553
	• Course: CST8132 – OOP
	• Assignment: 02
	• Date: 13/04
	• Professor: Dave Houtman
	• Purpose: This class was created to hold all the buttons and their functions for the quiz  
*/


package cst8284.triviatime;

import java.io.File;
import java.util.Collections;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This class was created to hold all the buttons and their functions for the quiz  
 * @author Gabriel Cardoso Maia
 * @version 1
 * @see import javafx.application.Platform;
 * @see javafx.event.ActionEvent;
 * @see javafx.scene.control.Alert;
 * @see javafx.scene.control.Alert.AlertType;
 * @see javafx.scene.control.Menu;
 * @see javafx.scene.control.MenuBar;
 * @see javafx.scene.control.MenuItem;
 * @see javafx.scene.input.KeyCode;
 * @see javafx.scene.input.KeyCodeCombination;
 * @see javafx.scene.input.KeyCombination;
 * @see javafx.scene.layout.BorderPane;
 * @see javafx.scene.layout.HBox;
 * @see javafx.scene.layout.VBox;
 * @see javafx.stage.FileChooser;
 * @see javafx.stage.Stage;
 * @since Java 1.8.0_171
 */
public class Controls {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;
	private static Stage stage;
	
	/**
	 * field used to keep the track of the QA position into the array
	 */
	private static int currentQuestion = 0;

	/***************** MenuBar *****************/
	/**
	 * method used to get the menu bar and it's divisions
	 * @param primaryStage stage where the menu bar is being set
	 * @return the menu bar
	 */
	public static MenuBar getMenuBar(Stage primaryStage) {
		setStage(primaryStage);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(getMnuFile(), getMnuSettings(), getMnuHelp());
		return menuBar;
	}
	
	/******************* Menu ******************/
	/**
	 * method used to create the File division of the menu
	 * @return the File division holding two menu item child
	 */
	private static Menu getMnuFile() {
		
		mnu = new Menu("_File");
		
		mnu.getItems().addAll(
			getMnuItmNewGame(), 
			getMnuItmExit());
		
		
		mnu.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));
		
		return mnu;
		
	}

	/**
	 * method used to create the Settings division of the menu
	 * @return the File division holding three menu item child
	 */
	private static Menu getMnuSettings() {
		mnu = new Menu("_Settings");
		mnu.getItems().addAll(
				getRandomQuestions(),
				getIncreaseDifficulty(), 
				getByTopic());
		return mnu;   
	} 

	/**
	 * method used to create the Help division of the menu
	 * @return the File division holding one menu item child
	 */
	private static Menu getMnuHelp() {
		mnu = new Menu("_Help");
		mnu.getItems().addAll(getMnuItmAbout());
		return mnu;
	}
	
	/***************** MenuItems *****************/
	
	/**
	 * method used for the action of clicking on the button new game
	 * @return the child new game button that stays inside the file division on the menu 
	 */
	private static MenuItem getMnuItmNewGame() {
		
		mnuItm = new MenuItem("_New Game");
		mnuItm.setOnAction((ActionEvent e) -> {
			currentQuestion=0;
			BorderPane bp = (BorderPane)getStage().getScene().getRoot();
			bp.setStyle("-fx-font: 16px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
			
			
			FileChooser chooser = new FileChooser();
			chooser.setTitle("Choose the .trivia file");
			chooser.setInitialDirectory(new File("C:/TriviaTime"));
			File helper = chooser.showOpenDialog(getStage());
			
			FileUtils.setQAArrayList(helper.getAbsolutePath());
			
			QAPane qa = new QAPane(Controls.getNextQA());
			
			VBox rBuf = new VBox(); rBuf.setPrefWidth(100); bp.setRight(rBuf);
		 	VBox lBuf = new VBox(); lBuf.setPrefWidth(100);	bp.setLeft(lBuf);
		    HBox tBuf = new HBox(); tBuf.setPrefHeight(100); bp.setTop(tBuf);
		    bp.setTop(getMenuBar(getStage()));
		    bp.setCenter(qa.getQAPane());	
		});
		
		mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		
		return mnuItm;
	}


	/**
	 * method used for the action of exiting the game on the button exit
	 * @return the child exit button that stays inside the file division on the menu 
	 */
	private static MenuItem getMnuItmExit() {
		mnuItm = new MenuItem("_Exit");
		mnuItm.setOnAction((ActionEvent e) -> Platform.exit());
		
		mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
		
		return mnuItm;
	}
	
	/**
	 * method used for the action of looking for the information the game on the button about
	 * @return the child about button that stays inside the help division on the menu 
	 */
	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		mnuItm = new MenuItem("_About");
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("About Trivia Time");
			alert.setContentText(
					"Gabriel Cardoso Maia from sample code provided by Prof. Dave Houtman, ©2018");
			alert.showAndWait();
		});
		
		mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
		
		return mnuItm;
	}
	
	/**
	 * method used for the action of sorting the game by topic on the button "By Topic"
	 * @return the child by Topic button that stays inside the Settings division on the menu 
	 */
	private static MenuItem getByTopic() {
		mnuItm = new MenuItem("_By Topic");
		mnuItm.setOnAction((ActionEvent e) ->{
			currentQuestion=0;
			Collections.sort(FileUtils.getQAArrayList(), new CompareCategory());
		});
		
		mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN));
		
		return mnuItm;
	}
	
	/**
	 * method used for the action of sorting the game by difficulty level on the button "Increase Difficulty"
	 * @return the child increase difficulty button that stays inside the Settings division on the menu 
	 */
	private static MenuItem getIncreaseDifficulty() {
		mnuItm = new MenuItem("_Increase Difficulty");
		mnuItm.setOnAction((ActionEvent e) ->{
			currentQuestion=2;
			Collections.sort(FileUtils.getQAArrayList(), new CompareDifficulty());
		});
		
		mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
		
		return mnuItm;
	}
	
	/**
	 * method used for the action of randomizing the game on the button "Randomize"
	 * @return the child randomize button that stays inside the Settings division on the menu 
	 */
	private static MenuItem getRandomQuestions() {
		mnuItm = new MenuItem("_Randomize");
		mnuItm.setOnAction((ActionEvent e) ->{
			currentQuestion=0;
			Collections.shuffle(FileUtils.getQAArrayList());
			
		});
		
		mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
		
		return mnuItm;
	}
	
	
	private static void setStage(Stage s) {stage= s;}
	public static Stage getStage() {return stage;}

	/**
	 * method used to compare the currentQuestion field with the size of the array to determine the next
	 * question
	 * @return the next question in the game
	 */
	public static QA getNextQA() {
		if (currentQuestion < FileUtils.getQAArrayList().size())
		   return FileUtils.getQAArrayList().get(currentQuestion++);
		else
		   return null;
	}

}
