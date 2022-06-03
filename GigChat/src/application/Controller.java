package application;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	public void exit_window(MouseEvent event) {
		
		Pane thisButton = (Pane) event.getSource();
		
		Scene currentScene = (Scene) thisButton.getScene();
		
		Stage currentStage = (Stage) currentScene.getWindow();
		
		currentStage.close();
		
	}

	@FXML
	public void screen_window(MouseEvent event) {
		Pane thisButton = (Pane) event.getSource();
		
		Scene currentScene = (Scene) thisButton.getScene();
		
		Stage currentStage = (Stage) currentScene.getWindow();
		
		currentStage.setMaximized(!currentStage.isMaximized());
		
		Rectangle tabbar = (Rectangle) currentScene.lookup("#tabbar");
		
		tabbar.setWidth( currentStage.getWidth() );
		
		Pane taskbar = (Pane) currentScene.lookup("#taskbar");
		taskbar.setLayoutX( currentStage.getWidth() - taskbar.getWidth() );
		
		Pane righttab = (Pane) currentScene.lookup("#righttab");
		
		righttab.setLayoutX(currentStage.getWidth() - taskbar.getWidth());
		
		righttab.setPrefHeight(currentScene.getHeight() - tabbar.getHeight());
		
		Pane lefttab = (Pane) currentScene.lookup("#lefttab");
		
		lefttab.setPrefHeight(currentScene.getHeight() - tabbar.getHeight());
		
		Pane chatBox = (Pane) currentScene.lookup("#chatBox");
		
		chatBox.setLayoutY( currentScene.getHeight() - chatBox.getHeight() );
		chatBox.setPrefWidth( currentScene.getWidth() - righttab.getWidth() - lefttab.getWidth() );
		
	}

	@FXML
	public void minimize_window(MouseEvent event) {
		Pane thisButton = (Pane) event.getSource();
		
		Scene currentScene = (Scene) thisButton.getScene();
		
		Stage currentStage = (Stage) currentScene.getWindow();
		
		currentStage.setIconified(true);
		
	}
	
}
