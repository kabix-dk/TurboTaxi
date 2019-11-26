package controller;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowListener;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.*;
import view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainController {

    private final View view;
    private final Game game;
    private GameWindowListener gameWindowListener;

    public MainController(View view, Game game) {
        this.view = view;
        this.game = game;
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
                prepareNewGame(70, 50);
                view.getNewGameWindow().close();
                view.showWindow(view.getGameWindow());
            } else if (button == view.getEscapeGame().getEndOfGameButton()) {
                view.getEscapeGame().close();
                view.getGameWindow().close();
                view.showWindow(view.getMainMenuWindow());
            } else if(button == view.getEscapeGame().getReturnButton()) {
                view.getEscapeGame().close();
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
            Position oldPosition = game.getPlayer().getPosition();
            boolean updateFields = false;
            if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                updateFields = game.move(game.getPlayer(), Direction.UP);
            } else if (keyStroke.getKeyType() == KeyType.ArrowDown) {
                updateFields = game.move(game.getPlayer(), Direction.DOWN);
            } else if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
                updateFields = game.move(game.getPlayer(), Direction.LEFT);
            } else if (keyStroke.getKeyType() == KeyType.ArrowRight) {
                updateFields = game.move(game.getPlayer(), Direction.RIGHT);
            } else if (keyStroke.getKeyType() == KeyType.Escape) {
                view.showWindow(view.getEscapeGame());
            }

            if(game.updateClient()){
                view.getGameWindow().updateClient(game.getClient());
            }

            if(updateFields) {

                if(game.getPlayer().getPetrolLeft() == -1) {
                    MessageDialogButton answer = view.showMessageDialog("Przegrałeś :(", "Czy chcesz powrócić do menu głównego?", MessageDialogButton.Yes, MessageDialogButton.No);

                    if(answer == MessageDialogButton.Yes) {
                        view.getGameWindow().close();
                        view.showWindow(view.getMainMenuWindow());
                    } else {
                        System.exit(0);
                    }

                }

                view.getGameWindow().updateFields(oldPosition, game.getPlayer().getPosition());
                view.getGameWindow().updateStats();
            }
        }
    }

    private void addListeners() {
        gameWindowListener = new GameWindowListener();
        Button.Listener buttonListener = new ButtonListener();

        view.getMainMenuWindow().getExitGameButton().addListener(buttonListener);
        view.getMainMenuWindow().getNewGameButton().addListener(buttonListener);

        view.getOptionsWindow().getReturnButton().addListener(buttonListener);

        view.getNewGameWindow().getReturnButton().addListener(buttonListener);
        view.getNewGameWindow().getNewGameButton().addListener(buttonListener);

        view.getEscapeGame().getEndOfGameButton().addListener(buttonListener);
        view.getEscapeGame().getReturnButton().addListener(buttonListener);
    }

    private void prepareNewGame(int petrol, int cash) {
        game.setClient();
        game.setPlayer(new Player(petrol, cash));
        view.createGameWindow(game);
        view.getGameWindow().addWindowListener(gameWindowListener);
    }
}
