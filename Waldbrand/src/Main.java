import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.print("Wie hoch soll der Wald sein? "); //Benutzereingabe für die grösse vom wald
        int heightForest = s.nextInt();
        System.out.print("Wie breit soll der Wald sein? ");
        int widthForest = s.nextInt();

        drawForest(heightForest, widthForest);


        //Benutzereingabe für Wahrscheinlichkeiten Blitz und neuer Baum
        //Timer t
        //schauen, ob baum
        //schauen welche Bäume sich entzünden und diese mit Feuer ersetzen
        //if baum neben Feuer steht, diesen mit Feuer ersetzen
        //if alle nachbarn brennen → verglüht
        //if verglüht → waldboden
        //simulation beenden, wenn Taste gedrückt wird
    }

    static void drawForest(int heightForest, int widthForest) { //zufällige erstellung vom Wald
        String[] emojis = {"🌳", "🪨", "🟫"};

        String[][] forest = new String[heightForest][widthForest];
        for (int row = 0; row < heightForest; row++) {
            for (int col = 0; col < widthForest; col++) {
                Random rand = new Random();
                int max = emojis.length - 1, min = 0;
                int symbol = rand.nextInt(max - min + 1) + min;
                forest[row][col] = emojis[symbol];
                //System.out.print(emojis[symbol]);
            }
        }
        for (int row = 0; row < heightForest; row++) {
            for (int col = 0; col < widthForest; col++) {
                System.out.print(forest[row][col]);
            }
            System.out.println();
        }
    }
}
