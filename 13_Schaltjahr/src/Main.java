import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
        int year = 0;

        while (programRunning) {
            try {
                System.out.print("Eingabe Jahr (q to quit): ");
                String input = scanner.nextLine();
                if (Objects.equals(input, "q")) {
                    programRunning = false;
                } else {
                    year = Integer.parseInt(input);

                    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                        System.out.println("Das Jahr " + year + " ist ein Schaltjahr.");
                    } else {
                        System.out.println("Das Jahr " + year + " ist KEIN Schaltjahr.");
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
}