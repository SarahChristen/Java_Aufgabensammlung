import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Breite des Stamms: ");
            int width = Integer.parseInt(scanner.nextLine());
            System.out.print("Höhe des Stamms: ");
            int height = Integer.parseInt(scanner.nextLine());
            System.out.print("Höhe der Krone: ");
            int crown = Integer.parseInt(scanner.nextLine());

            for (int crownheight = 1; crownheight <= crown; crownheight++) { //Krone zeichnen
                for (int crownwidth = 1; crownwidth <= crown * 2 - 1; crownwidth++) {
                    if (crown - crownheight < crownwidth && crown + crownheight > crownwidth) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            for (int heightdraw = 1; heightdraw <= height; heightdraw++) { //Stamm zeichnen
                for (int widthdraw = 1; widthdraw <= crown + width / 2; widthdraw++) {
                    if (widthdraw >= crown - width / 2) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

        } catch (NumberFormatException ex) {
            System.out.println("Eingabefehler. Bitte geben Sie eine Ganzzahl ein.");
        } catch (Exception ex) {
            System.out.println("Unbekannter Fehler: " + ex);
        }
    }
}