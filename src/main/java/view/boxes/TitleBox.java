package view.boxes;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import view.components.HeaderLabel;

public class TitleBox extends HBox {

	public TitleBox() {
		super(new HeaderLabel(Constants.TITLE_LABEL));
		setBackground(
				new Background(new BackgroundFill(Color.web(Constants.HEADER_COLOR), CornerRadii.EMPTY, Insets.EMPTY)));
		setPadding(new Insets(Constants.DEFAULT_PADDING));
		setAlignment(Pos.CENTER);
	}
}
