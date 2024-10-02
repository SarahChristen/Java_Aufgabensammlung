import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Zahl zwischen 1 und 12: ");
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);

            if(number >= 1 && number <= 12) {
                String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};

                System.out.println(months[number - 1]);
            } else {
                System.out.println("Ungültige Eingabe, bitte geben Sie eine Zahl zwischen 1 und 12 ein.");
            }
        }

        catch (NumberFormatException ex) {
            System.out.println("Eingabefehler. Bitte geben Sie eine Ganzzahl ein.");
        }
    }
}