/** File name: TriviaTimeLaunch.java
	• Author: Gabriel Cardoso Maia, 040891553
	• Course: CST8132 – OOP
	• Assignment: 02
	• Date: 13/04
	• Professor: Dave Houtman
	• Purpose: This class was created to initialize the program
*/

package cst8284.triviatime;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Class responsible for setting and initializing the initial screen of the program
 * @author Gabriel Cardoso Maia
 * @version 1
 * @see cst8284.triviatime
 * @since Java 1.8.0_171
 */
public class TriviaTimeLaunch extends Application {
	/**  @Copyright Dave Houtman 2018.  For use in Winter 2018 - CST8284 classes only */
	
	private static BorderPane rootPane;
	
	@Override
	public void start(Stage primaryStage){	
	   // Display Splash Screen
	   setRootPane("Welcome to Trivial Time");
	   getRootPane().setTop(Controls.getMenuBar(primaryStage));
	   Scene scene =  new Scene(getRootPane(), 1024, 512);
	   primaryStage.setTitle("Trivia Time");
	   primaryStage.setScene(scene);
	   primaryStage.show();	
	}
	
	/**
	 * method for setting the initial screen
	 * @param splashString the string that is being showed in the initial screen
	 */
	public static void setRootPane(String splashString) {
		rootPane= new BorderPane();
		Text text = new Text(splashString);
		text.setStyle("-fx-font: 40px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		
		// the glow, fade and rotate variables are used for adding special effects to the splashString
		Glow glow = new Glow();
		FadeTransition fade = new FadeTransition(Duration.millis(5000), text);
		RotateTransition rotate = new RotateTransition(Duration.millis(3000), text);
		
		glow.setLevel(1.0);
		text.setEffect(glow);
		
		fade.setFromValue(0.1);
		fade.setToValue(1.0);
		
		
		rotate.setByAngle(360f);
		rotate.setCycleCount(1);
		
		//the parallel variable is responsible for holding the animations together
		ParallelTransition parallel = new ParallelTransition();
		parallel.getChildren().addAll(fade, rotate);
		parallel.play();
	
		rootPane.setCenter(text);
		
	}
	/**
	 * method used to get the pane
	 * @return the rootPane
	 */
	public static BorderPane getRootPane() {return rootPane;}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
}