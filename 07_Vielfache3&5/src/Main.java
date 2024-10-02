public class Main {
    public static void main(String[] args) {
        boolean first = true;

        System.out.println("Zahlen zwischen 1 und 30, die durch 5 und/oder 3 ohne Rest teilbar sind:");
        for (int number = 1; number <= 30; number++) {
            if (number % 5 == 0 || number % 3 == 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(number);
                first = false;
            }
        }
    }
}