package view.components;

import constants.Constants;
import javafx.scene.control.Button;

public class DefaultButton extends Button {

	public DefaultButton(String text) {
		super(text);
		setStyle(Constants.BUTTON_STYLE);
	}
}
