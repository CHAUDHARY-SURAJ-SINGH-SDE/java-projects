module com.example.javafxapp {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.SurajSingh.javafxapp to javafx.fxml;
	exports com.SurajSingh.javafxapp;
}