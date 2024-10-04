import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        boolean quitSimulation = false;

        System.out.print("Wie hoch soll der Wald sein? "); //Benutzereingabe für die grösse vom wald
        int heightForest = s.nextInt();
        System.out.print("Wie breit soll der Wald sein? ");
        int widthForest = s.nextInt();

        System.out.print("Wie hoch soll die Chance für einen Blitzeinschlag sein? (in %) ");
        int oddsFire = s.nextInt();

        String[][] forest = new String[heightForest][widthForest];
        drawForest(forest);

        while (!quitSimulation) {
            checkLightning(forest, oddsFire);
            //checkFire(forest);
            updateForest(forest);

            System.out.println();
            try {
                System.in.read();
                s.nextLine();
            } catch (Exception e) {
            }


            //Benutzereingabe für Wahrscheinlichkeiten Blitz und neuer Baum
            //while schleife für immer neuen wald (timer t)

            //if baum neben Feuer steht, diesen mit Feuer ersetzen
            //if alle nachbarn brennen → verglüht
            //if verglüht → waldboden
            //simulation beenden, wenn Taste gedrückt wird
        }
    }

    static void drawForest(String[][] forest) { //zufällige erstellung vom Wald
        String[] emojis = {"🌳", "🪨", "🟫"};


        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                Random rand = new Random();
                int max = emojis.length - 1, min = 0;
                int symbol = rand.nextInt(max - min + 1) + min;
                forest[row][col] = emojis[symbol];
            }
        }
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                System.out.print(forest[row][col]);
            }
            System.out.println();
        }
    }

    static void checkLightning(String[][] forest, int oddsFire) { //schauen welche Bäume vom Blitz getroffen werden und diese mit Feuer ersetzen
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (Objects.equals(forest[row][col], "🌳")) {
                    Random rand = new Random();
                    int max = 100 / oddsFire, min = 1;
                    int lightning = rand.nextInt(max - min + 1) + min;

                    if (lightning == 1) {
                        forest[row][col] = "🔥";
                    }
                }
            }
        }
    }

    /*static void checkFire(String[][] forest) { //schauen welche bäume von anderen bäumen entzündet werden und diese mit feuer ersetzen
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (Objects.equals(forest[row][col], "🌳")) {
                    int h = forest.length - 1 + row;
                    int w = forest[0].length - 1 + col;
                    if (forest.length > h && h >= 0 && w >= 0 && forest[0].length > w) {
                        if (Objects.equals(forest[row - 1][col - 1], "🔥") || Objects.equals(forest[row - 1][col], "🔥") || Objects.equals(forest[row - 1][col + 1], "🔥") || Objects.equals(forest[row][col - 1], "🔥") || Objects.equals(forest[row][col + 1], "🔥") || Objects.equals(forest[row + 1][col - 1], "🔥") || Objects.equals(forest[row + 1][col], "🔥") || Objects.equals(forest[row + 1][col + 1], "🔥")) {
                            forest[row][col] = "🔥";
                        }
                    }
                }
            }
        }
    }*/

    static void updateForest(String[][] forest) {
        System.out.println();
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                System.out.print(forest[row][col]);
            }
            System.out.println();
        }
    }
}
