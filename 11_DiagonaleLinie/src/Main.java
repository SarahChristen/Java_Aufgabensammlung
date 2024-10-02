import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;


        while (!validInput) {
            try {
                System.out.println("Wie lange soll die Linie sein?");
                System.out.print("Deine Eingabe: ");
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                for (int row = 1; row <= number; row++) {
                    for (int col = 1; col <= number; col++) {
                        if (row == col) {
                            System.out.print(" ");
                        } else {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                validInput = true;

            } catch (NumberFormatException ex) {
                System.out.println("Eingabefehler. Bitte geben Sie eine Ganzzahl ein.");
                System.out.println();
            } catch (Exception ex) {
                System.out.println("Unbekannter Fehler: " + ex);
                System.out.println();
            }
        }
    }
}