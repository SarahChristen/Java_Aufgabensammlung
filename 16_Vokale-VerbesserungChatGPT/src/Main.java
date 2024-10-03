import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'ü', 'A', 'E', 'I', 'O', 'U', 'Ä', 'Ö', 'Ü'};
        int[] counts = new int[vowels.length];
        int totalVowels = 0;

        System.out.println("Deine Eingabe: ");
        String input = s.nextLine();

        for (int place = 0; place < input.length(); place++) {
            char currentChar = input.charAt(place);

            for (int i = 0; i < vowels.length; i++) {
                if (currentChar == vowels[i]) {
                    counts[i]++;
                    totalVowels++;
                    break;
                }
            }
        }

        System.out.println();
        System.out.println("Dein Text hat total " + totalVowels + " Vokale.");

        for (int i = 0; i < vowels.length; i++) {
            if (counts[i] > 0) {
                System.out.println("Der Buchstabe '" + vowels[i] + "' kommt " + counts[i] + " mal vor.");
            }
        }
    }
}