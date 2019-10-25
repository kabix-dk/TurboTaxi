import controller.MainController;
import view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new View();
        MainController controller = new MainController(view);
        view.initScreen();
        view.showWindow(view.getMainMenuWindow());
    }

}
