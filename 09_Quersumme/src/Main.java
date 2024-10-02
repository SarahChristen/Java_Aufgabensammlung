import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Zahl: ");
            String input = scanner.nextLine();
            int zahl = Integer.parseInt(input);

            System.out.print("Die Quersumme von " + input + " ist: " + berechneQuersumme(zahl));
        } catch (NumberFormatException ex) {
            // NumberFormatException occured -> parseInt failed
            System.out.println("Eingabefehler. Bitte geben Sie eine Ganzzahl ein.");
        }
    }


    static int berechneQuersumme(int zahl) {
        int sum = 0;
        while (zahl != 0) {
            sum = sum + (zahl % 10);
            zahl = zahl / 10;
        }
        return sum;
    }
}