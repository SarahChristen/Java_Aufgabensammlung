import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Zahl 1:");
                String input1 = scanner.nextLine();
                int number1 = Integer.parseInt(input1);

                System.out.println("Zahl 2:");
                String input2 = scanner.nextLine();
                int number2 = Integer.parseInt(input2);

                if (number1 < number2) {
                    System.out.println("-------------------------------------");
                    System.out.println("Zahl \t| Quersumme | Zahl/Quersumme");
                    System.out.println("-------------------------------------");

                    for (int zahl = number1; zahl <= number2; zahl++) {
                        if (zahl % berechneQuersumme(zahl) == 0) {
                            System.out.println(zahl + "\t\t| " + berechneQuersumme(zahl) + "\t\t\t| " + zahl / berechneQuersumme(zahl));
                        }
                    }
                    validInput = true;
                } else {
                    System.out.println("Zahl 1 muss kleiner sein als Zahl 2.");
                    System.out.println("");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Eingabefehler. Bitte geben Sie eine Ganzzahl ein.");
        } catch (Exception ex) {
            System.out.println("Unbekannter Fehler: " + ex);
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