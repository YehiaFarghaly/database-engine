package view.components;

import constants.Constants;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HeaderLabel extends Label {

	public HeaderLabel(String text) {
		super(text);
		setFont(Font.font(Constants.TITLE_FONT, Constants.TITLE_FONT_SIZE));
		setTextFill(Color.WHITE);
	}
}
