import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String yes = "ja";
        String no = "nein";
        boolean validInput = false;

        try {
            System.out.print("Wie viele Kilometer möchtest du rennen? ");
            String input = scanner.nextLine();
            int distance = Integer.parseInt(input);

            if (distance > 42) {
                System.out.print("Das schaffst du nicht!");
            } else {
                int rounds = distance * 1000 / 400;
                System.out.print("Das sind " + rounds + " Runden. ");
                while (!validInput) {
                    System.out.print("Bereit für den Lauf? (ja/nein) ");
                    String ready = scanner.nextLine();

                    if (ready.equals(yes)) {
                        int round = 1;

                        while (round <= rounds) {
                            System.out.println("Du läufst Runde " + round);
                            round++;
                        }
                        System.out.print("Du hast es geschafft!");
                        validInput = true;
                    } else if (ready.equals(no)) {
                        validInput = true;
                    } else {
                        System.out.println("Ungültige Eingabe. Gib 'ja' oder 'nein' ein.");
                    }
                }


            }
        } catch (NumberFormatException ex) {
            System.out.println("Eingabefehler. Bitte gib eine Ganzzahl ein.");
        } catch (Exception ex) {
            System.out.println("Unbekannter Fehler: " + ex);
        }
    }
}