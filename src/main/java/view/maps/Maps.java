package view.maps;

public class Maps {

    public static int sizeX = 15;
    public static int sizeY = 5;

    public static String[] generateMap() {
        String[] map = {"   **          ",
                        "**  *          ",
                        "** **  **  * **",
                        "               ",
                        "** * * ** **   "};
        return map;
    }
}
