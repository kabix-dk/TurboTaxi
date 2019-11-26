package view.windows;

import com.googlecode.lanterna.TextColor;
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
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));

        panel.addTo(mainPanel);

        Panel helpPanel = new Panel();
        helpPanel.setLayoutManager(new GridLayout(2));
        helpPanel.addComponent(new Label("Stacja benzynowa:"));
        Label label = new Label("  ");
        label.setBackgroundColor(TextColor.ANSI.YELLOW);
        helpPanel.addComponent(label);

        helpPanel.addComponent(new Label("Agresywny klient:"));
        Label label1 = new Label("! ");
        label1.setForegroundColor(TextColor.ANSI.RED);
        helpPanel.addComponent(label1);

        helpPanel.addComponent(new Label("Anonimowy klient:"));
        Label label2 = new Label("# ");
        label2.setForegroundColor(TextColor.ANSI.CYAN);
        helpPanel.addComponent(label2);

        helpPanel.addComponent(new Label("Zwykły klient:"));
        Label label3 = new Label("@ ");
        label3.setForegroundColor(TextColor.ANSI.BLUE);
        helpPanel.addComponent(label3);

        helpPanel.addComponent(new Label("Bogaty klient:"));
        Label label4 = new Label("$ ");
        label4.setForegroundColor(TextColor.ANSI.GREEN);
        helpPanel.addComponent(label4);

        helpPanel.addComponent(new Label("Dom agresywnego klienta:"));
        Label label5 = new Label("  ");
        label5.setBackgroundColor(TextColor.ANSI.RED);
        helpPanel.addComponent(label5);

        helpPanel.addComponent(new Label("Dom anonimowego klienta:"));
        Label label6 = new Label("  ");
        label6.setBackgroundColor(TextColor.ANSI.CYAN);
        helpPanel.addComponent(label6);

        helpPanel.addComponent(new Label("Dom zwykłego klienta:"));
        Label label7 = new Label("  ");
        label7.setBackgroundColor(TextColor.ANSI.BLUE);
        helpPanel.addComponent(label7);

        helpPanel.addComponent(new Label("Dom bogatego klienta:"));
        Label label8 = new Label("  ");
        label8.setBackgroundColor(TextColor.ANSI.GREEN);
        helpPanel.addComponent(label8);

        helpPanel.addTo(mainPanel);

        super.setComponent(mainPanel);
    }

    public Button getEndOfGameButton() {
        return endOfGameButton;
    }

    public Button getReturnButton() {
        return returnButton;
    }
}
