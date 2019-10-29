package view.windows;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;

import view.SampleWindow;
import view.ViewComponents;

public class MainMenuWindow extends SampleWindow {

    private Button newGameButton;
    private Button optionsButton;
    private Button exitGameButton;

    public MainMenuWindow() {
        super ("Menu główne");
        Panel panel = new Panel(new GridLayout(1));
        panel.addComponent(ViewComponents.generateGameLogo());
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

        this.newGameButton = new Button("NOWA GRA");
        newGameButton.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER));
        panel.addComponent(newGameButton);
//        this.optionsButton = new Button("OPCJE");
//        optionsButton.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER));
//        panel.addComponent(optionsButton);
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        this.exitGameButton = new Button("WYJDŹ Z GRY");
        exitGameButton.setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER));
        panel.addComponent(exitGameButton);

        super.setComponent(panel);
    }

    public Button getNewGameButton() {
        return newGameButton;
    }

    public Button getOptionsButton() {
        return optionsButton;
    }

    public Button getExitGameButton() {
        return exitGameButton;
    }
}
