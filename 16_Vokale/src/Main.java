import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int vowels = 0;
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int ae = 0;
        int oe = 0;
        int ue = 0;
        int A = 0;
        int E = 0;
        int I = 0;
        int O = 0;
        int U = 0;
        int AE = 0;
        int OE = 0;
        int UE = 0;

        System.out.println("Deine Eingabe: ");
        String input = s.nextLine();

        for (int place = 0; place < input.length(); place++) {
            char searchedChar = input.charAt(place);
            switch (searchedChar) {
                case 'a':
                    a++;
                    vowels++;
                    break;
                case 'e':
                    e++;
                    vowels++;
                    break;
                case 'i':
                    i++;
                    vowels++;
                    break;
                case 'o':
                    o++;
                    vowels++;
                    break;
                case 'u':
                    u++;
                    vowels++;
                    break;
                case 'ä':
                    ae++;
                    vowels++;
                    break;
                case 'ö':
                    oe++;
                    vowels++;
                    break;
                case 'ü':
                    ue++;
                    vowels++;
                    break;
                case 'A':
                    A++;
                    vowels++;
                    break;
                case 'E':
                    E++;
                    vowels++;
                    break;
                case 'I':
                    I++;
                    vowels++;
                    break;
                case 'O':
                    O++;
                    vowels++;
                    break;
                case 'U':
                    U++;
                    vowels++;
                    break;
                case 'Ä':
                    AE++;
                    vowels++;
                    break;
                case 'Ö':
                    OE++;
                    vowels++;
                    break;
                case 'Ü':
                    UE++;
                    vowels++;
                    break;
            }
        }

        System.out.println("Dein Text hat total " + vowels + " Vokale.");
        if (a != 0) {
            System.out.println("Der Buchstabe 'a' kommt " + a + " mal vor.");
        }
        if (e != 0) {
            System.out.println("Der Buchstabe 'e' kommt " + e + " mal vor.");
        }
        if (i != 0) {
            System.out.println("Der Buchstabe 'i' kommt " + i + " mal vor.");
        }
        if (o != 0) {
            System.out.println("Der Buchstabe 'o' kommt " + o + " mal vor.");
        }
        if (u != 0) {
            System.out.println("Der Buchstabe 'u' kommt " + u + " mal vor.");
        }
        if (ae != 0) {
            System.out.println("Der Buchstabe 'ä' kommt " + ae + " mal vor.");
        }
        if (oe != 0) {
            System.out.println("Der Buchstabe 'ö' kommt " + oe + " mal vor.");
        }
        if (ue != 0) {
            System.out.println("Der Buchstabe 'ü' kommt " + ue + " mal vor.");
        }
        if (A != 0) {
            System.out.println("Der Buchstabe 'A' kommt " + A + " mal vor.");
        }
        if (E != 0) {
            System.out.println("Der Buchstabe 'E' kommt " + E + " mal vor.");
        }
        if (I != 0) {
            System.out.println("Der Buchstabe 'I' kommt " + I + " mal vor.");
        }
        if (O != 0) {
            System.out.println("Der Buchstabe 'O' kommt " + O + " mal vor.");
        }
        if (U != 0) {
            System.out.println("Der Buchstabe 'U' kommt " + U + " mal vor.");
        }
        if (AE != 0) {
            System.out.println("Der Buchstabe 'Ä' kommt " + AE + " mal vor.");
        }
        if (OE != 0) {
            System.out.println("Der Buchstabe 'Ö' kommt " + OE + " mal vor.");
        }
        if (UE != 0) {
            System.out.println("Der Buchstabe 'Ü' kommt " + UE + " mal vor.");
        }
    }
}