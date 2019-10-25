import controller.MainController;
import view.View;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        View view = new View();
        MainController controller = new MainController(view);
        view.initScreen();
        view.showWindow(view.getMainMenuWindow());
    }

}
