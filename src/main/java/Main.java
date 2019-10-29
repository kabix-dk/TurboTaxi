import controller.MainController;
import model.Game;
import view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new View();
        Game game = new Game();
        MainController controller = new MainController(view, game);
        view.initScreen();
        view.showWindow(view.getMainMenuWindow());
    }

}
