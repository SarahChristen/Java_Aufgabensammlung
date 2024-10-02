import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean stopGame = false;

        try {
            while (!stopGame) {
                boolean foundNumber = false;
                Random rand = new Random();
                int max = 100, min = 1;
                int goal = rand.nextInt(max - min + 1) + min;
                int tries = 1;


                System.out.println("Deine Zahl (zwischen " + min + " und " + max + "): ");
                int number = s.nextInt();
                while (!foundNumber) {
                    if (number == goal) {
                        System.out.print("Die Zahl stimmt! Du hast " + tries + " Versuche benötigt. Noch einmal spielen? [y/n] ");
                        String again = s.next();
                        if (!Objects.equals(again, "y")) {
                            stopGame = true;
                        } else {
                            System.out.println();
                        }
                        foundNumber = true;
                    } else if (number > goal) {
                        System.out.println("Zahl ist zu gross! Nächster Versuch: ");
                        number = s.nextInt();
                    } else {
                        System.out.println("Zahl ist zu klein! Nächster Versuch: ");
                        number = s.nextInt();
                    }
                    tries++;
                }
            }
        } catch(NumberFormatException | InputMismatchException ex) {
            System.out.println("Eingabefehler. Bitte geben Sie eine Ganzzahl ein.");
        } catch(Exception ex){
            System.out.println("Unbekannter Fehler: " + ex);
        }
    }
}

