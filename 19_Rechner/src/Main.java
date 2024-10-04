import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int result = 0;
        boolean quit = false;
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        while (!quit) {
            boolean foundSymbol = false;
            char mathsymbol = '0';

            System.out.println("Make your calculation (or press Q to quit): ");
            String input = s.nextLine();
            if (Objects.equals(input, "q")) {
                quit = true;
            } else {
                input = input.replaceAll(" ", "");
                int num1 = 0;
                int num2 = 0;

                for (int i = 0; i < input.length(); i++) {
                    char symbol = input.charAt(i);
                    for (int j = 0; j < numbers.length; j++) {
                        int num = symbol - '0';
                        if (num == numbers[j]) {
                            if (!foundSymbol) {
                                num1 = num1 * 10 + num;
                            } else {
                                num2 = num2 * 10 + num;
                            }
                        }
                    }
                    if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                        mathsymbol = symbol;
                        foundSymbol = true;
                    }
                }
                switch (mathsymbol) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                System.out.println(result);
            }
        }
    }
}