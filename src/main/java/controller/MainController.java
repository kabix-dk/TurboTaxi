package controller;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowListener;
import com.googlecode.lanterna.input.KeyStroke;
import view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainController {

    private final View view;

    public MainController(View view) {
        this.view = view;
        addListeners();
    }

    public class ButtonListener implements Button.Listener {

        @Override
        public void onTriggered(Button button) {
            if(button == view.getMainMenuWindow().getOptionsButton()) {
                view.getMainMenuWindow().close();
                view.showWindow(view.getOptionsWindow());
            } else if (button == view.getOptionsWindow().getReturnButton()) {
                view.getOptionsWindow().close();
                view.showWindow(view.getMainMenuWindow());
            } else if (button == view.getMainMenuWindow().getExitGameButton()) {
                System.exit(0);
            } else if (button == view.getMainMenuWindow().getNewGameButton()) {
                view.getMainMenuWindow().close();
                view.showWindow(view.getNewGameWindow());
            } else if (button == view.getNewGameWindow().getReturnButton()) {
                view.getNewGameWindow().close();
                view.showWindow(view.getMainMenuWindow());
            } else if (button == view.getNewGameWindow().getNewGameButton()) {
                view.getNewGameWindow().close();
                view.showWindow(view.getGameWindow());
            }
        }
    }

    public class GameWindowListener implements WindowListener {

        @Override
        public void onResized(Window window, TerminalSize terminalSize, TerminalSize terminalSize1) {

        }

        @Override
        public void onMoved(Window window, TerminalPosition terminalPosition, TerminalPosition terminalPosition1) {

        }

        @Override
        public void onInput(Window window, KeyStroke keyStroke, AtomicBoolean atomicBoolean) {

        }

        @Override
        public void onUnhandledInput(Window window, KeyStroke keyStroke, AtomicBoolean atomicBoolean) {

        }
    }

    private void addListeners() {
        Button.Listener buttonListener = new ButtonListener();

        view.getMainMenuWindow().getOptionsButton().addListener(buttonListener);
        view.getMainMenuWindow().getExitGameButton().addListener(buttonListener);
        view.getMainMenuWindow().getNewGameButton().addListener(buttonListener);

        view.getOptionsWindow().getReturnButton().addListener(buttonListener);

        view.getNewGameWindow().getReturnButton().addListener(buttonListener);
        view.getNewGameWindow().getNewGameButton().addListener(buttonListener);
    }
}
