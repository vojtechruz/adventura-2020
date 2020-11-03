package cz.vse.ruzicka;

import cz.vse.ruzicka.logika.IHra;
import cz.vse.ruzicka.logika.Prostor;
import cz.vse.ruzicka.logika.Vec;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class MainController {

    public TextArea textOutput;
    public TextField textInput;
    private IHra hra;

    public Label locationName;
    public Label locationDescription;

    public VBox exits;
    public VBox items;


    public void init(IHra hra) {
        this.hra = hra;
        update();
    }

    private void update() {
        String location = getAktualniProstor().getNazev();
        locationName.setText(location);

        String description = getAktualniProstor().getPopis();
        locationDescription.setText(description);

        updateExits();
        updateItems();
    }

    private void updateItems() {
        Collection<Vec> itemList = getAktualniProstor().getSeznamVeci().values();
        items.getChildren().clear();

        for (Vec item : itemList) {
            String itemName = item.getJmeno();
            Label itemLabel = new Label(itemName);
            if(item.jePrenositelna()) {
                itemLabel.setCursor(Cursor.HAND);

                itemLabel.setOnMouseClicked(event -> {
                    String result = hra.zpracujPrikaz("seber " + itemName);
                    textOutput.appendText(result+"\n\n");
                    update();
                });
            } else {
                // TODO nastavime plovouci napovedu ze vec nelze prenaset
            }

            items.getChildren().add(itemLabel);
        }

    }

    private void updateExits() {
        Collection<Prostor> exitList = getAktualniProstor().getVychody();
        exits.getChildren().clear();

        for (Prostor prostor : exitList) {
            String exitName = prostor.getNazev();
            Label exitLabel = new Label(exitName);
            exitLabel.setCursor(Cursor.HAND);
            exitLabel.setOnMouseClicked(event -> {
                String result = hra.zpracujPrikaz("jdi " + exitName);
                textOutput.appendText(result+"\n\n");
                update();
            });

            exits.getChildren().add(exitLabel);
        }

    }

    private Prostor getAktualniProstor() {
        return hra.getHerniPlan().getAktualniProstor();
    }


}
