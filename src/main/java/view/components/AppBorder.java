package view.components;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class AppBorder extends BorderPane {

	public AppBorder(Node child1, Node child2, Node child3) {
		super();
		setTop(child1);
		setCenter(child2);
		setRight(child3);
		setBackground(new Background(
				new BackgroundFill(Color.web(Constants.BACKGROUND_COLOR), CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
