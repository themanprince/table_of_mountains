//This however isn't a complete mvc as there is no controller... but the view and model followed rules
//I did'nt have to bind model properties to view's so there was observable value that served to do the observing
//so no need for a listener to act as an observer

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.*;

public class Main extends Application {

	//the model and view
	Model theModel = new Model();
	View2 theView = new View2(theModel);

	//the Scene
	Scene theScene;

	public void start(Stage stage) {

		//adding shit to the model
		theModel.addMountain("Kilimanjaro", 2.0, "Tanzania");
		theModel.addMountain("Everest", 3.0, "Ukraine");
		theModel.addMountain("My Dick", 5.9, "Down There");
		theModel.addMountain("Your sense", 0.0, "Somewhere");
		theModel.addMountain("Lokoja", 30.9, "Kogi");

		//filling up the view
		theView.fillUp();

		Scene theScene = new Scene(theView);
		theScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
		stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
		stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
		stage.setResizable(false);
		stage.setScene(theScene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}