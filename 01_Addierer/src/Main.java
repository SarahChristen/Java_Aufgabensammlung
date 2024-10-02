import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zahl 1: ");
        String input1 = scanner.nextLine();
        int number1 = Integer.parseInt(input1);

        System.out.print("Zahl 2: ");
        String input2 = scanner.nextLine();
        int number2 = Integer.parseInt(input2);

        System.out.println(number1 + number2);
    }
}