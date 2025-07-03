import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static volatile boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.print("Wie hoch soll der Wald sein? "); //Benutzereingabe für die grösse vom wald
        int heightForest = s.nextInt();
        System.out.print("Wie breit soll der Wald sein? ");
        int widthForest = s.nextInt();

        System.out.print("Wie hoch soll die Chance für einen Blitzeinschlag sein? (in %) ");
        int oddsFire = s.nextInt();
        System.out.print("Wie hoch soll die Chance sein, dass auf leerem Waldboden ein neuer Baum wächst? (in %) ");
        int oddsGrowth = s.nextInt();
        clearConsole();

        String[][] forest = new String[heightForest][widthForest];
        drawForest(forest);

        //im Hintergrund darauf warten, dass Enter gedrückt wird
        Thread inputThread = new Thread(() -> {
            try {
                System.in.read();
                stopRequested = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        inputThread.setDaemon(true); //Thread beendet sich automatisch, wenn Hauptprogramm endet
        inputThread.start();

        //Hauptprogramm → läuft, solange nicht Enter gedrückt wird
        double t = 0;
        while (!stopRequested) {
            clearConsole();
            System.out.println("Zeit: " + (t += 2));
            String[][] newForest = new String[heightForest][widthForest];
            checkLightning(forest, oddsFire, newForest);
            checkFire(forest, newForest);
            fillSpecificSpaces(forest, newForest, "🌳");
            checkAsh(forest, newForest);
            checkGrowth(forest, oddsGrowth, newForest);
            fillAllSpaces(forest, newForest);
            forest = updateForest(newForest);

            System.out.println("\nDrück Enter zum Beenden...");
            Thread.sleep(2000); // Update alle 2 Sekunden
        }

        System.out.println("Simulation beendet.");
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
        for (String[] rows : forest) {
            for (int col = 0; col < forest[0].length; col++) {
                System.out.print(rows[col]);
            }
            System.out.println();
        }
    }

    static void checkLightning(String[][] forest, int oddsFire, String[][] newForest) { //schauen welche Bäume vom Blitz getroffen werden und diese mit Feuer ersetzen
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (Objects.equals(forest[row][col], "🌳")) {
                    Random rand = new Random();
                    int max = 100 / oddsFire, min = 1;
                    int lightning = rand.nextInt(max - min + 1) + min;

                    if (lightning == 1) {
                        newForest[row][col] = "🔥";
                    }
                }
            }
        }
    }

    static void checkFire(String[][] forest, String[][] newForest) { //schauen welche bäume von anderen bäumen entzündet werden und diese mit feuer ersetzen
        var rowLimit = forest.length - 1;
        var colLimit = forest[0].length - 1;

        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (Objects.equals(forest[row][col], "🌳")) {
                    for (int x = Math.max(0, row - 1); x <= Math.min(row + 1, rowLimit); x++) {
                        for (int y = Math.max(0, col - 1); y <= Math.min(col + 1, colLimit); y++) {
                            if (forest[x][y].equals("🔥")) {
                                newForest[row][col] = "🔥";
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    static void checkAsh(String[][] forest, String[][] newForest) { //schauen welche bäume verglühen und diese mit boden ersetzen
        var rowLimit = forest.length - 1;
        var colLimit = forest[0].length - 1;

        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (Objects.equals(forest[row][col], "🔥")) {
                    boolean ash = true;
                    for (int x = Math.max(0, row - 1); x <= Math.min(row + 1, rowLimit); x++) {
                        for (int y = Math.max(0, col - 1); y <= Math.min(col + 1, colLimit); y++) {
                            if (newForest[x][y] != null && newForest[x][y].equals("🌳")) {
                                ash = false;
                                break;
                            }
                        }
                    }
                    if (ash) {
                        newForest[row][col] = "⚫";
                    }
                } else if (Objects.equals(forest[row][col], "⚫")) {
                    newForest[row][col] = "🟫";
                }
            }
        }
    }

    static void checkGrowth(String[][] forest, int oddsGrowth, String[][] newForest) { //schauen auf welchen Erd-Feldern ein neuer Baum wächst
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (Objects.equals(forest[row][col], "🟫")) {
                    Random rand = new Random();
                    int max = 100 / oddsGrowth, min = 1;
                    int newTree = rand.nextInt(max - min + 1) + min;

                    if (newTree == 1) {
                        newForest[row][col] = "🌳";
                    }
                }
            }
        }
    }

    static void fillSpecificSpaces(String[][] forest, String[][] newForest, String symbol) {
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (Objects.equals(forest[row][col], symbol) && newForest[row][col] == null) {
                    newForest[row][col] = symbol;
                }
            }
        }
    }

    static void fillAllSpaces(String[][] forest, String[][] newForest) {
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (newForest[row][col] == null) {
                    newForest[row][col] = forest[row][col];
                }
            }
        }
    }

    static String[][] updateForest(String[][] forest) {
        System.out.println();
        for (String[] rows : forest) {
            for (int col = 0; col < forest[0].length; col++) {
                System.out.print(rows[col]);
            }
            System.out.println();
        }
        return forest;
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J"); // ANSI-Escape-Sequenz
        System.out.flush();
    }
}
