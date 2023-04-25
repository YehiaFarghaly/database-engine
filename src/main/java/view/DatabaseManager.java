package view;

import constants.Constants;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.boxes.TitleBox;
import view.components.AppBorder;
import view.wrappers.Wrapper;

public class DatabaseManager extends Application {
	TitleBox titleBox = new TitleBox();
	Wrapper queryWrapper = new Wrapper(Pos.CENTER);
	Wrapper tableWrapper = new Wrapper(Pos.TOP_CENTER);

	public void start(Stage primaryStage) {
		AppBorder border = new AppBorder(titleBox, queryWrapper, tableWrapper);
		Scene root = new Scene(border, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
		primaryStage.setScene(root);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
