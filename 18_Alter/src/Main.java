import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            System.out.print("Bitte gib ein Geburtsdatum ein: ");
            String input = s.nextLine();

            LocalDate birthday = LocalDate.parse(input, formatter);
            LocalDate today = LocalDate.now();

            findDifference(birthday, today);

        } catch (DateTimeParseException ex) {
            System.out.println("Dies ist ein ungültiges Datum oder das Format dd.mm.yyyy wurde nicht eingehalten");
        } catch (Exception ex) {
            System.out.println("Unbekannter Fehler: " + ex);
        }
    }

    static void findDifference (LocalDate birthday, LocalDate today) {
        Period difference = Period.between(birthday, today);
        int years = difference.getYears();
        int months = difference.getMonths() + years * 12;
        long weeks = ChronoUnit.WEEKS.between(birthday, today);
        long days = difference.getDays() + weeks * 7;

        System.out.println("Alter in Jahren: " + years);
        System.out.println("Alter in Monaten: " + months);
        System.out.println("Alter in Wochen: " + weeks);
        System.out.println("Alter in Tagen: " + days);
    }
}