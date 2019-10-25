package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.Label;

public class ViewComponents {
    public static Component generateGameLogo() {
        Label label = new Label(" ________                     __                        ________                    __  \n"
                + " |        \\                   |  \\                      |        \\                  |  \\ \n"
                + "  \\$$$$$$$$__    __   ______  | $$____    ______         \\$$$$$$$$______   __    __  \\$$ \n"
                + "    | $$  |  \\  |  \\ /      \\ | $$    \\  /      \\          | $$  |      \\ |  \\  /  \\|  \\ \n"
                + "    | $$  | $$  | $$|  $$$$$$\\| $$$$$$$\\|  $$$$$$\\         | $$   \\$$$$$$\\ \\$$\\/  $$| $$ \n"
                + "    | $$  | $$  | $$| $$   \\$$| $$  | $$| $$  | $$         | $$  /      $$  >$$  $$ | $$ \n"
                + "    | $$  | $$__/ $$| $$      | $$__/ $$| $$__/ $$         | $$ |  $$$$$$$ /  $$$$\\ | $$ \n"
                + "    | $$   \\$$    $$| $$      | $$    $$ \\$$    $$         | $$  \\$$    $$|  $$ \\$$\\| $$ \n"
                + "     \\$$    \\$$$$$$  \\$$       \\$$$$$$$   \\$$$$$$           \\$$   \\$$$$$$$ \\$$   \\$$ \\$$ \n"
                + "                                                                                        ");
        label.addStyle(SGR.BOLD);
        label.addStyle(SGR.BLINK);
        label.setForegroundColor(TextColor.ANSI.YELLOW);
        return label.withBorder(Borders.doubleLine());
    }
}
