package application;

import java.net.URL;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	Scene scene = null;
	
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("GigChat");
			primaryStage.initStyle(StageStyle.UNDECORATED);

	        URL fxmlfile = getClass().getResource("GUI.fxml");

	        Parent root = FXMLLoader.load( fxmlfile );
	        
	        scene = new Scene(root);
	        
	        primaryStage.setTitle("Guessing Game");
	        
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        
			primaryStage.setScene(scene);

			primaryStage.show();

			showMessage("W".repeat(20).repeat(20));
			showMessage("D".repeat(20).repeat(20));
	        //showMessage("DDDDDDDDDDDDDDDDDDDDDDDDDDDD");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showMessage( String content ) {
		
		Pane MessagesBox = (Pane) scene.lookup("#MessagesBox");
		
		Pane messageContents = new Pane();
		
		messageContents.setPrefHeight(scene.getHeight() / 20);
		messageContents.setPrefWidth(scene.getWidth() - ((Pane) (scene.lookup("#lefttab"))).getWidth() - ((Pane) (scene.lookup("#righttab"))).getWidth());
		
		// Text zum Content
		
		TextFlow textflow = new TextFlow();
		
		textflow.setMaxWidth(messageContents.getPrefWidth());
		
		textflow.setStyle("-fx-background-color: #202020");
		
		Text text = new Text(content);
		text.setStyle("-fx-fill: #ffffff;");
		
		textflow.getChildren().add(text);
		
		messageContents.applyCss();
		messageContents.layout();
		
		messageContents.getChildren().add(textflow);
		
		//messageContents.setPrefHeight( textflow.getPrefHeight() );

		
		MessagesBox.getChildren().add(messageContents);
		
		for(int i = 0; i < MessagesBox.getChildren().size(); ++i) {
			
			int result = 0;
			
			Pane messageC = ((Pane) MessagesBox.getChildren().get(i));
			
			for(int j = i - 1; j >= 0; j--) {
				//result += ((Pane) MessagesBox.getChildren().get(j)).getPrefHeight();
				
				Text t = ((Text) ((TextFlow) ((Pane) (MessagesBox.getChildren().get(j))).getChildren().get(0)).getChildren().get(0));
				
				result += Math.ceil(((Text) ((TextFlow) ((Pane) (MessagesBox.getChildren().get(j))).getChildren().get(0)).getChildren().get(0)).boundsInLocalProperty().getValue().getWidth() 
						/ 
						((Pane) MessagesBox.getChildren().get(i)).getPrefWidth()) 
						* 
						((Text) ((TextFlow) ((Pane) (MessagesBox.getChildren().get(j))).getChildren().get(0)).getChildren().get(0)).boundsInLocalProperty().getValue().getMaxY();
				
				result += 5;
			}
			
			((Pane) (MessagesBox.getChildren().get(i))).setLayoutY(result);
			//((Pane) (MessagesBox.getChildren().get(i))).setLayoutX(0);
			
		}
		
		MessagesBox.setPrefHeight( ((Pane)MessagesBox.getChildren().get(MessagesBox.getChildren().size()-1)).getLayoutY() + ((Pane)MessagesBox.getChildren().get(MessagesBox.getChildren().size()-1)).getPrefHeight());
		
		ScrollPane ScrollPaneMSG = (ScrollPane) scene.lookup("#Scrl");
		
		ScrollPaneMSG.vvalueProperty().bind(MessagesBox.heightProperty());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
