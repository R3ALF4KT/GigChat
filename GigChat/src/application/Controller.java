package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextFlow;
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
		
		ScrollPane ScrollPaneMSG = (ScrollPane) currentScene.lookup("#Scrl");
		
		ScrollPaneMSG.setPrefHeight(currentScene.getHeight() - tabbar.getHeight() - chatBox.getHeight() );
		ScrollPaneMSG.setPrefWidth( currentScene.getWidth() - righttab.getWidth() - lefttab.getWidth() );
		
		Pane MessagesBox = (Pane) currentScene.lookup("#MessagesBox");
		
		MessagesBox.setPrefHeight(currentScene.getHeight() - tabbar.getHeight() - chatBox.getHeight());
		MessagesBox.setPrefWidth( currentScene.getWidth() - righttab.getWidth() - lefttab.getWidth()  - righttab.getWidth() / 10.5);
		
		for(int i = 0; i < MessagesBox.getChildren().size(); i++) {
			
			((Pane) MessagesBox.getChildren().get(i)).setPrefWidth( currentScene.getWidth() - righttab.getWidth() - lefttab.getWidth() );
			
		}
		
		MessagesBox.setPrefHeight( ((Pane)MessagesBox.getChildren().get(MessagesBox.getChildren().size()-1)).getLayoutY() + ((Pane)MessagesBox.getChildren().get(MessagesBox.getChildren().size()-1)).getPrefHeight());

		for(int i = 0; i < MessagesBox.getChildren().size(); i++) {
			
			Pane messageContents = (Pane) MessagesBox.getChildren().get(i);
			
			TextFlow textflow = (TextFlow) messageContents.getChildren().get(0);
			
			textflow.setPrefWidth( MessagesBox.getPrefWidth() );
			
			
		}
		
	}

	@FXML
	public void minimize_window(MouseEvent event) {
		Pane thisButton = (Pane) event.getSource();
		
		Scene currentScene = (Scene) thisButton.getScene();
		
		Stage currentStage = (Stage) currentScene.getWindow();
		
		currentStage.setIconified(true);
		
	}
	
}
