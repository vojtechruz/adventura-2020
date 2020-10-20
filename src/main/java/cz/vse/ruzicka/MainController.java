package cz.vse.ruzicka;

import javafx.scene.Cursor;
import javafx.scene.control.Label;

public class MainController {

    public Label labelA;
    public Label labelB;
    public Label labelC;

    public void init() {
        labelA.setText("Jiny Text");
        labelB.setCursor(Cursor.HAND);
    }

}
