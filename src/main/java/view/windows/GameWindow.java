package view.windows;

import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Panel;
import view.SampleWindow;
import view.ViewComponents;

public class GameWindow extends SampleWindow {

    public GameWindow() {
        super("Gra trwa");
        Panel mainPanel = new Panel();
        Panel gamePanel = new Panel();
        gamePanel.withBorder(Borders.singleLine());
        GridLayout layout = new GridLayout(15);
        layout.setBottomMarginSize(0).setHorizontalSpacing(0).setLeftMarginSize(0).setRightMarginSize(0).setTopMarginSize(0).setVerticalSpacing(0);
        gamePanel.setLayoutManager(layout);

        String[] map = ViewComponents.generateKlepaczeMap();
        Component field;
        boolean car = false;
        for (String mapa : map) {
            for (int i=0; i<mapa.length(); i++){
                if(!car) {
                    field = ViewComponents.createPlayer();
                    gamePanel.addComponent(field);
                    car = true;
                    continue;
                }
                field = ViewComponents.createField(mapa.charAt(i));
                gamePanel.addComponent(field);
            }
        }

        super.setComponent(gamePanel);
    }

}
