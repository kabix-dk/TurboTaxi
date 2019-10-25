package view.windows;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Panel;
import view.SampleWindow;
import view.ViewComponents;

public class NewGameWindow extends SampleWindow {

    private Button returnButton;
    private Button newGameButton;

    public NewGameWindow() {
        super("Nowa gra");
        Panel panel = new Panel(new GridLayout(1));
        panel.addComponent(ViewComponents.generateGameLogo());
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

        this.newGameButton = new Button("ROZPOCZNIJ NOWĄ GRĘ");
        newGameButton.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER));
        panel.addComponent(newGameButton);
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        this.returnButton = new Button("POWRÓT");
        returnButton.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER));
        panel.addComponent(returnButton);

        super.setComponent(panel);
    }

    public Button getReturnButton() {
        return returnButton;
    }

    public Button getNewGameButton() {
        return newGameButton;
    }
}
