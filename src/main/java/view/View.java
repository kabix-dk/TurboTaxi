package view;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import view.windows.MainMenuWindow;
import view.windows.OptionsWindow;

import java.io.IOException;

public class View extends BasicWindow {

    private Terminal terminal;
    private Screen screen;
    private WindowBasedTextGUI textGUI;
    private MainMenuWindow mainMenuWindow;
    private OptionsWindow optionsWindow;

    public View() {
        try {
            this.terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.textGUI = new MultiWindowTextGUI(screen);
            this.mainMenuWindow = new MainMenuWindow();
            this.optionsWindow = new OptionsWindow();
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

    public void showWindow(SampleWindow window) { this.textGUI.addWindowAndWait(window.show()); }

    public MainMenuWindow getMainMenuWindow() {
        return mainMenuWindow;
    }

    public OptionsWindow getOptionsWindow() {
        return optionsWindow;
    }
}
