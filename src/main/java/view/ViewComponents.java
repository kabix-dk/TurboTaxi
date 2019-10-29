package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.Label;
import model.Field;

public class ViewComponents {

    public static Component createField(char fieldType) {
        Label label;
        switch (fieldType) {
            case Field.ROAD:
                label = new Label("  ");
                return label;
            case Field.BUILDING:
                label = new Label("██");
                return label;
            case Field.HOUSE_AGRESOR:
                label = new Label("  ");
                label.setBackgroundColor(TextColor.ANSI.RED);
                return label;
            case Field.HOUSE_ANONYMOUS:
                label = new Label("  ");
                label.setBackgroundColor(TextColor.ANSI.CYAN);
                return label;
            case Field.HOUSE_CASUAL:
                label = new Label("  ");
                label.setBackgroundColor(TextColor.ANSI.BLUE);
                return label;
            case Field.HOUSE_REACH:
                label = new Label("  ");
                label.setBackgroundColor(TextColor.ANSI.GREEN);
                return label;
            case Field.CLIENT_AGRESOR:
                label = new Label("! ");
                label.addStyle(SGR.BOLD);
                label.setForegroundColor(TextColor.ANSI.RED);
                return label;
            case Field.CLIENT_ANONYMOUS:
                label = new Label("# ");
                label.addStyle(SGR.BOLD);
                label.setForegroundColor(TextColor.ANSI.CYAN);
                return label;
            case Field.CLIENT_CASUAL:
                label = new Label("@ ");
                label.addStyle(SGR.BOLD);
                label.setForegroundColor(TextColor.ANSI.BLUE);
                return label;
            case Field.CLIENT_REACH:
                label = new Label("$ ");
                label.addStyle(SGR.BOLD);
                label.setForegroundColor(TextColor.ANSI.GREEN);
                return label;
            case Field.PETROL_STATION:
                label = new Label("  ");
                label.setBackgroundColor(TextColor.ANSI.YELLOW);
                return label;
            default:
                break;
        }
        label = new Label("?");
        return label;
    }

    public static Component createPlayer() {
        Label label = new Label("▀");
        label.setForegroundColor(TextColor.ANSI.MAGENTA);
        return label;
    }

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
