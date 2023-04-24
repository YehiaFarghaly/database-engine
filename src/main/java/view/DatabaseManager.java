package view;

import constants.Constants;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DatabaseManager extends Application {

	public void start(Stage primaryStage) {
		HBox titleBox = createTitleBox();
		HBox queryBox = createQueryBox();
		Button executeButton = createButton(Constants.EXECUTE_BUTTON_LABEL);
		VBox vbox = createWrapper(queryBox, executeButton, Pos.CENTER);
		VBox tableView = createTablesWrapper(Pos.CENTER);
		addFakeData(tableView);
		Button tableButton = createButton(Constants.TABLE_BUTTON_LABEL);
		setAction(tableButton, tableView);
		VBox tables = createWrapper(tableButton, tableView, Pos.TOP_CENTER);
		BorderPane borderPane = createAppBorder(titleBox, vbox, tables);
		Scene root = new Scene(borderPane, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
		primaryStage.setScene(root);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private HBox createTitleBox() {
		Label titleLabel = new Label(Constants.TITLE_LABEL);
		titleLabel.setFont(Font.font(Constants.TITLE_FONT, Constants.TITLE_FONT_SIZE));
		titleLabel.setTextFill(Color.WHITE);
		HBox titleBox = new HBox(titleLabel);
		titleBox.setBackground(
				new Background(new BackgroundFill(Color.web(Constants.HEADER_COLOR), CornerRadii.EMPTY, Insets.EMPTY)));
		addHboxStyle(titleBox);
		return titleBox;
	}
	
	private HBox createQueryBox() {
		Label queryLabel = new Label(Constants.QUERY_LABEL);
		queryLabel.setTextFill(Color.WHITE);
		TextArea queryField = new TextArea();
		queryField.setStyle(Constants.QUERY_BOX_STYLE);
		HBox queryBox = new HBox(Constants.DEFAULT_PADDING, queryLabel, queryField);
	    addHboxStyle(queryBox);
		return queryBox;
	}
	
	private void addHboxStyle(HBox hbox) {
		hbox.setPadding(new Insets(Constants.DEFAULT_PADDING));
		hbox.setAlignment(Pos.CENTER);
	}
	
	private void addFakeData(VBox tableView) {
		for (int i = 1; i <= 5; i++) {
			Label tableNameLabel = new Label("Table " + i);
			tableNameLabel.setStyle("-fx-text-fill: white;");
			tableView.getChildren().add(tableNameLabel);
		}
	}
	
	private void setAction(Button tableButton, VBox tableView) {
		tableButton.setOnMouseClicked(event -> {
			if (tableView.isVisible()) {
				tableView.setVisible(false);
			} else {
				tableView.setVisible(true);
			}
		});
	}

	private VBox createWrapper(Node child1, Node child2, Pos pos) {
		VBox vbox = new VBox(Constants.DEFAULT_PADDING, child1, child2);
		setVBoxStyle(vbox, pos);
		return vbox;
	}

	private VBox createTablesWrapper(Pos pos) {
		VBox vbox = new VBox();
		setVBoxStyle(vbox, pos);
		vbox.setSpacing(Constants.DEFAULT_PADDING);
		vbox.setVisible(false);
		return vbox;
	}

	private void setVBoxStyle(VBox vbox, Pos value) {
		vbox.setPadding(new Insets(Constants.DEFAULT_PADDING));
		vbox.setAlignment(value);
		vbox.setBorder(Border.EMPTY);
	}

	private Button createButton(String text) {
		Button button = new Button(text);
		button.setStyle(Constants.BUTTON_STYLE);
		return button;
	}

	private BorderPane createAppBorder(Node child1, Node child2, Node child3) {
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(child1);
		borderPane.setCenter(child2);
		borderPane.setRight(child3);
		borderPane.setBackground(
				new Background(new BackgroundFill(Color.web(Constants.BACKGROUND_COLOR), CornerRadii.EMPTY, Insets.EMPTY)));
		return borderPane;
	}

//	public static void main(String[] args) {
//		launch(args);
//	}
}
