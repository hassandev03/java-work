import java.util.Scanner;

public class VowelConsonant {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Vowel\\Consonant Counter ---");
        System.out.print("Enter any Sentence: ");
        String sentence = inp.nextLine().strip();

        System.out.printf("No. of Vowels: %d\nNo. of Consonants: %d",
                countVowel(sentence), countConsonant(sentence));
    }

    private static int countConsonant(String sentence) {
        int consCount = 0;
        char ch;
        for (int i = 0; i < sentence.length(); i++){
            ch = sentence.charAt(i);
            if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == ' ')) {
                consCount++;
            }
        }
        return consCount;
    }

    private static int countVowel(String sentence) {
        int vowCount = 0;
        char ch;
        for (int i = 0; i < sentence.length(); i++) {
            ch = sentence.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowCount++;
            }
        }
        return vowCount;
    }
}