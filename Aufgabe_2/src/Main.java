import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.print("Wie viele Tage hat der Monat, für den Sie die Sekunden berechnen wollen? ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);

            if (number >= 28 && number <= 31) {
                System.out.println("Ein Monat mit " + number + " Tagen hat " + number * 86400 + " Sekunden.");
            } else {
                System.out.println("Ungültige Eingabe. Einen Monat mit " + number + " Tagen gibt es bei uns nicht.");
            }
        } catch (NumberFormatException ex) {
            // NumberFormatException occured -> parseInt failed
            System.out.println("Eingabefehler. Bitte geben Sie eine Ganzzahl ein.");
        } catch (Exception ex) {
            // unknown Exception occured
            System.out.println("Unbekannter Fehler: " + ex.toString());
        }
    }
}

