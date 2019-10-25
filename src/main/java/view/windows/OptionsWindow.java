package view.windows;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Panel;
import view.SampleWindow;

public class OptionsWindow extends SampleWindow {

    private Button returnButton;

    public OptionsWindow() {
        super("Opcje");
        Panel panel = new Panel(new GridLayout(1));
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

        this.returnButton = new Button("POWRÓT");
        panel.addComponent(returnButton);

        super.setComponent(panel);
    }

    public Button getReturnButton() {
        return returnButton;
    }
}
