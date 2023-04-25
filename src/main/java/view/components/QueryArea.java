package view.components;

import constants.Constants;
import javafx.scene.control.TextArea;

public class QueryArea extends TextArea {

	public QueryArea() {
		super();
		setStyle(Constants.QUERY_BOX_STYLE);
	}
}
