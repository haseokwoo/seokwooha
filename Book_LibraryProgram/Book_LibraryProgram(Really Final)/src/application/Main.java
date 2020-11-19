package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class forms the basic interface.
 * 
 * @author Seokwoo Ha
 *
 */
public final class Main extends Application {
	@Override
	public void start(final Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Book_LibraryView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Book Searching Program");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method launches the interface.
	 * 
	 * @param args Default value for this method.
	 */
	public static void main(final String[] args) {
		launch(args);
	}
}
