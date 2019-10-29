package view.windows;

import jdk.nashorn.internal.ir.Terminal;
import view.SampleWindow;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;

import java.awt.*;

public class EscapeGame extends SampleWindow {

    private final Button endOfGameButton;
    private final Button returnButton;

    public EscapeGame() {
        super();

        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new GridLayout(1).setLeftMarginSize(10).setRightMarginSize(10));
        mainPanel.addComponent(new Label("Chcesz zakończyć grę?"));
        mainPanel.addComponent(new EmptySpace(TerminalSize.ONE));

        Panel panel = new Panel();
        this.endOfGameButton = new Button("ZAKONCZ GRĘ");
        endOfGameButton.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER));
        panel.addComponent(endOfGameButton);
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        this.returnButton = new Button("POWRÓT");
        returnButton.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER));
        panel.addComponent(returnButton);

        panel.addTo(mainPanel);

        super.setComponent(mainPanel);
    }

    public Button getEndOfGameButton() {
        return endOfGameButton;
    }

    public Button getReturnButton() {
        return returnButton;
    }
}
