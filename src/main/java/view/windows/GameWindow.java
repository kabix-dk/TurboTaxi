package view.windows;

import com.googlecode.lanterna.gui2.*;
import model.Field;
import model.Game;
import model.Position;
import view.SampleWindow;
import view.View;
import view.ViewComponents;
import view.maps.Maps;

import java.util.HashMap;
import java.util.Map;

public class GameWindow extends SampleWindow {

    private final Map<Position, Component> mapComponents;

    public GameWindow(Game game) {
        super("Gra trwa");
        this.mapComponents = new HashMap<>();
        Panel mainPanel = new Panel();
        Panel gamePanel = new Panel();
        gamePanel.withBorder(Borders.singleLine());
        GridLayout layout = new GridLayout(15);
        layout.setBottomMarginSize(0).setHorizontalSpacing(0).setLeftMarginSize(0).setRightMarginSize(0).setTopMarginSize(0).setVerticalSpacing(0);
        gamePanel.setLayoutManager(layout);

        String[] map = Maps.generateMap();
        Component field;

        for (int i = 0; i < Maps.sizeY; i++) {
            for (int j = 0; j < Maps.sizeX; j++){
                if(i == 0 && j == 0) {
                    field = ViewComponents.createPlayer();
                    gamePanel.addComponent(field);
                    this.mapComponents.put(new Position(j, i), field);
                    continue;
                }
                field = ViewComponents.createField(map[i].charAt(j));
                gamePanel.addComponent(field);
                this.mapComponents.put(new Position(j, i), field);
            }
        }
        super.setComponent(gamePanel);
    }

    public void updateFields(Position actualPosition, Position newPosition) {
        Label label = (Label) this.mapComponents.get(actualPosition);
        label.setText(" ");

        Label label1 = (Label) this.mapComponents.get(newPosition);
        label1.setText("!");
    }

}
