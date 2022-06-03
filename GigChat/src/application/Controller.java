package application;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	public void exit_window(MouseEvent event) {
		
		Rectangle thisButton = (Rectangle) event.getSource();
		
		Scene currentScene = (Scene) thisButton.getScene();
		
		Stage currentStage = (Stage) currentScene.getWindow();
		
		currentStage.close();
		
	}

	@FXML
	public void screen_window(MouseEvent event) {
		Rectangle thisButton = (Rectangle) event.getSource();
		
		Scene currentScene = (Scene) thisButton.getScene();
		
		Stage currentStage = (Stage) currentScene.getWindow();
		
		currentStage.setMaximized(!currentStage.isMaximized());
		
		Rectangle tabbar = (Rectangle) currentScene.lookup("#tabbar");
		
		tabbar.setWidth( currentStage.getWidth() );
		
		String[] rectangles = {"#closeButton", "#screenButton", "#minimizeButton"};
		
		for(int i = 0; i < rectangles.length; ++i) {
			
			Rectangle closeButton = (Rectangle) currentScene.lookup(rectangles[i]); 
			
			closeButton.setTranslateX( currentStage.getWidth() - closeButton.getWidth() * (i+1) - closeButton.getLayoutX() );
			
		}
		
		String[] images = {"#closeImage", "#screenImage", "#minimizeImage"};
		
		for(int i = 0; i < images.length; ++i) {
			
			ImageView imgButton = (ImageView) currentScene.lookup(images[i]); 
			
			System.out.println(imgButton.getFitWidth());
			
			imgButton.setTranslateX(currentStage.getWidth() - imgButton.getFitWidth() * (i) - imgButton.getLayoutX());
		}
	}

	@FXML
	public void minimize_window(MouseEvent event) {
		Rectangle thisButton = (Rectangle) event.getSource();
		
		Scene currentScene = (Scene) thisButton.getScene();
		
		Stage currentStage = (Stage) currentScene.getWindow();
		
		currentStage.setIconified(true);
		
	}
	
}
