package view.wrappers;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import view.boxes.QueryBox;
import view.components.DefaultButton;

public class Wrapper extends VBox {
	
	public Wrapper(Pos pos) {
		super(Constants.DEFAULT_PADDING);
		setPadding(new Insets(Constants.DEFAULT_PADDING));
		setAlignment(pos);
		setBorder(Border.EMPTY);

		if (pos == Pos.CENTER) {
			queryBoxCase(new DefaultButton(Constants.EXECUTE_BUTTON_LABEL));
		} else {
			tableWrapperCase(new DefaultButton(Constants.TABLE_BUTTON_LABEL), new TableWrapper());
		}
	}

	private void queryBoxCase(DefaultButton button) {
		button.setOnAction(event -> setExecuteButtonAction());
		getChildren().addAll(new QueryBox(), button);
	}

	private void tableWrapperCase(DefaultButton button, TableWrapper tableWrapper) {
		button.setOnMouseClicked(event -> setTableButtonAction(tableWrapper));
		tableWrapper.addFakeData();
		getChildren().addAll(button, tableWrapper);
	}

	private void setTableButtonAction(Node node) {
		if (node.isVisible()) {
			node.setVisible(false);
		} else {
			node.setVisible(true);
		}
	}

	private void setExecuteButtonAction() {

	}
}
