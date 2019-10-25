package controller;

import com.googlecode.lanterna.gui2.Button;
import view.View;

public class MainController {

    private final View view;
    private Button.Listener buttonListener;

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
            }
        }
    }

    private void addListeners() {
        buttonListener = new ButtonListener();

        view.getMainMenuWindow().getOptionsButton().addListener(buttonListener);
        view.getMainMenuWindow().getExitGameButton().addListener(buttonListener);

        view.getOptionsWindow().getReturnButton().addListener(buttonListener);
    }
}
