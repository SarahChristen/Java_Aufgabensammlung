import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib eine ganze Zahl ein: ");
        String input = scanner.nextLine();
        int n = Integer.parseInt(input);
        String bin = "";

        int nStart = n;
        int wert = 0;
        while (n != 0) {
            int rest = n % 2;
            bin = rest + bin;
            wert = n / 2;
            n = wert;
        }

        System.out.println("Die binäre Darstellung von " + nStart + " ist: " + bin);
    }
}