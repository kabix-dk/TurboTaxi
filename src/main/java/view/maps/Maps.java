package view.maps;

public class Maps {

    public static int sizeX = 30;
    public static int sizeY = 20;

    public static String[] generateMap() {
        String[] map = {"   **          ",
                        "**  *          ",
                        "** **  **  * **",
                        "               ",
                        "** * * ** **   "};
        return map;
    }

    public static String[] generateSuperMap() {
        String[] map = {"******* **  **  ****** *******",
                        "*** ***  *  **  *    * ** $ **",
                        "*!    *  *  **  *    * ** * **",
                        "** * ** **  **  **  ** **   **",
                        "*     * *              **** **",
                        "*** *** *                     ",
                        "*** *** *  ****  ***** ** ** *",
                        "           ****  *** *  * *   ",
                        "** * * **  ****  *   * ** ** *",
                        "*  * *  *  ****  *** * ** ** *",
                        "** * * **                     ",
                        "   * *           ** ^ ** **** ",
                        "**     ***  **  ******** ** * ",
                        "** *** ***  **                ",
                        "** *** ***  **  ** ** ** ** **",
                        "** *** ***  **  **************",
                        "** *** ***  **  ** ** **#** **",
                        "**     ***  **                ",
                        "**@** ****  **  ** ** ** ** **",
                        "***** ****  **  **************"};
        return map;
    }
}
