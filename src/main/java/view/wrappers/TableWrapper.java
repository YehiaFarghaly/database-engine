package view.wrappers;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

public class TableWrapper extends VBox {

	public TableWrapper() {
		super();
		setPadding(new Insets(Constants.DEFAULT_PADDING));
		setAlignment(Pos.CENTER);
		setBorder(Border.EMPTY);
		setSpacing(Constants.DEFAULT_PADDING);
		setVisible(false);
	}
	
	public void addFakeData() {
		for (int i = 1; i <= 5; i++) {
			Label tableNameLabel = new Label("Table " + i);
			tableNameLabel.setStyle("-fx-text-fill: white;");
			this.getChildren().add(tableNameLabel);
		}
	}
}
