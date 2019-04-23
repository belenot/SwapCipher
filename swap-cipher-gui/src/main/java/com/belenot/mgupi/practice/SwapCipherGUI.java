package com.belenot.mgupi.practice;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SwapCipherGUI extends Application {
	public static final String RESOURCES="/home/belenot/programming/projects/java/mgupi/practice/swap-cipher-gui/src/main/resources/";
	
	public static void main(String[] args) {;
		launch(args);
	}

	@Override
	public void start (Stage stage) {
		try {
			if (Files.exists(Paths.get("SimpleNothing.fxml"))) {
				System.out.println("NONONONONONONONONONONONONONONONONONO");
			}
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Swap cipher demo.");
			stage.show();
		} catch (IOException exc) {
			System.out.println(exc);
			exc.printStackTrace();
		}
	}
}
