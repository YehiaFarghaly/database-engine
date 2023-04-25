package view.boxes;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import view.components.QueryArea;

public class QueryBox extends HBox {
	private static Label label = new Label(Constants.QUERY_LABEL);

	public QueryBox() {
		super(Constants.DEFAULT_PADDING, label, new QueryArea());
		label.setTextFill(Color.WHITE);
		setPadding(new Insets(Constants.DEFAULT_PADDING));
		setAlignment(Pos.CENTER);
	}
}
