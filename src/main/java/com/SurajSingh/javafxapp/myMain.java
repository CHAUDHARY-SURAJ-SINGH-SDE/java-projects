package com.SurajSingh.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class myMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void init() throws Exception {
		System.out.println("start");
		super.init();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_Layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar  menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ENGINEER SURAJ SINGH");
		primaryStage.show();
	}
	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		fileMenu.getItems().addAll(newMenuItem,quitMenuItem);
		quitMenuItem.setOnAction(actionEvent -> Platform.exit());
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(actionEvent -> aboutApp());
		MenuItem helpMenuItem = new MenuItem("Help");
		helpMenu.getItems().addAll(aboutApp,separatorMenuItem, helpMenuItem);
		Menu quitMenu = new Menu("Quit");
		MenuItem Quit = new MenuItem("Quit");
		quitMenu.getItems().addAll(Quit);
		Quit.setOnAction(actionEvent -> {
			Alert quiteAlert = new Alert(Alert.AlertType.CONFIRMATION);
			quiteAlert.setTitle("CHAUDHARY SURAJ SINGH");
			quiteAlert.setHeaderText("Do You Really Want to Quit");
			ButtonType yesBtn= new ButtonType("Yes");
			ButtonType noBtn = new ButtonType("No");
			quiteAlert.getButtonTypes().setAll(yesBtn,noBtn);
			Optional<ButtonType> clickButton=quiteAlert.showAndWait();
			if (clickButton.isPresent()&&clickButton.get()== yesBtn){
				Platform.exit();
			}
		});
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu,quitMenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("CHAUDHARY SURAJ SINGH");
		alertDialog.setHeaderText("My first Desktop Application");
		alertDialog.setContentText("Hey there i am engineer SURAJ SINGH." +
				" this is my first Desktop Application" +
				" and I am in learning mode");
		ButtonType yesBtn= new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
		Optional<ButtonType> clickButton=alertDialog.showAndWait();
		if (clickButton.isPresent()&&clickButton.get()== yesBtn){
			System.out.println("yes button clicked");

		}
		else {
			System.out.println("no button clicked");
		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
