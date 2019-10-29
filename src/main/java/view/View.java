package view;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import model.Game;
import view.windows.*;

import java.io.IOException;

public class View extends BasicWindow {

    private Terminal terminal;
    private Screen screen;
    private WindowBasedTextGUI textGUI;
    private MainMenuWindow mainMenuWindow;
    private OptionsWindow optionsWindow;
    private NewGameWindow newGameWindow;
    private GameWindow gameWindow;
    private EscapeGame escapeGame;

    public View() {
        try {
            this.terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.textGUI = new MultiWindowTextGUI(screen);
            this.mainMenuWindow = new MainMenuWindow();
            this.optionsWindow = new OptionsWindow();
            this.newGameWindow = new NewGameWindow();
            this.escapeGame = new EscapeGame();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initScreen() {
        try {
            this.screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createGameWindow(Game game) {
        this.gameWindow = new GameWindow(game);
    }

    public MessageDialogButton showMessageDialog(String title, String text, MessageDialogButton... buttons) {
        return MessageDialog.showMessageDialog(this.textGUI, title, text, buttons);
    }

    public void showWindow(SampleWindow window) { this.textGUI.addWindowAndWait(window.show()); }

    public MainMenuWindow getMainMenuWindow() {
        return mainMenuWindow;
    }

    public OptionsWindow getOptionsWindow() {
        return optionsWindow;
    }

    public NewGameWindow getNewGameWindow() {
        return newGameWindow;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public EscapeGame getEscapeGame() {
        return escapeGame;
    }
}
