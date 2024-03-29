package view.windows;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import model.client.Client;
import model.Field;
import model.Game;
import model.Position;
import view.SampleWindow;
import view.ViewComponents;
import view.maps.Maps;

import java.util.HashMap;
import java.util.Map;

public class GameWindow extends SampleWindow {

    private Map<Position, Component> mapComponents;
    private final Game game;

    private Label petrolLeftLabel;
    private Label cashLeftLabel;
    private Label lastClient;

    public GameWindow(Game game) {
        super("Gra trwa");
        this.game = game;
        this.mapComponents = new HashMap<>();
        Panel mainPanel = new Panel();
        Panel gamePanel = new Panel();
        gamePanel.withBorder(Borders.singleLine());
        GridLayout layout = new GridLayout(30);
        layout.setBottomMarginSize(0).setHorizontalSpacing(0).setLeftMarginSize(0).setRightMarginSize(0).setTopMarginSize(0).setVerticalSpacing(0);
        gamePanel.setLayoutManager(layout);

        String[] map = Maps.generateSuperMap();
        Component field;

        for (int i = 0; i < Maps.sizeY; i++) {
            for (int j = 0; j < Maps.sizeX; j++){
                if(i == 9 && j == 1) {
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

        mainPanel.addComponent(gamePanel.withBorder(Borders.singleLine()));
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0,0)));
        Panel statsPanel = new Panel();
        statsPanel.setLayoutManager(new GridLayout(2));
        statsPanel.addComponent(new Label("Petrol left:"));
        petrolLeftLabel = new Label("70");
        statsPanel.addComponent(petrolLeftLabel);
        statsPanel.addComponent(new Label("Cash left:"));
        cashLeftLabel = new Label("50");
        statsPanel.addComponent(cashLeftLabel);
        statsPanel.addComponent(new Label("Actual client:"));
        lastClient = new Label("?");
        statsPanel.addComponent(lastClient);
        mainPanel.addComponent(statsPanel.withBorder(Borders.singleLine()));

        super.setComponent(mainPanel);
    }

    public void updateFields(Position actualPosition, Position newPosition) {
        Label newFirstLabel = (Label) ViewComponents.createField(Field.ROAD);
        Label oldFirstLabel = (Label) this.mapComponents.get(actualPosition);
        oldFirstLabel.setText(newFirstLabel.getText());
        oldFirstLabel.setForegroundColor(TextColor.ANSI.DEFAULT);

        Label newSecondLabel = (Label) ViewComponents.createPlayer();
        Label oldSecondLabel = (Label) this.mapComponents.get(newPosition);
        oldSecondLabel.setText(newSecondLabel.getText());
        oldSecondLabel.setForegroundColor(newSecondLabel.getForegroundColor());
    }

    public void updateStats() {
        petrolLeftLabel.setText(String.valueOf(game.getPlayer().getPetrolLeft()));
        cashLeftLabel.setText(String.valueOf(game.getPlayer().getCashLeft()));
    }

    public void updateClient(Client client) {
        Label clientLabel = (Label) ViewComponents.createField((char) (client.getType()+'0'));
        Label addHere = (Label) this.mapComponents.get(client.getPosition());
        addHere.setForegroundColor(clientLabel.getForegroundColor());
        addHere.setText(clientLabel.getText());
        lastClient.setForegroundColor(clientLabel.getForegroundColor());
        lastClient.setText(clientLabel.getText());
    }
}
