import java.util.Scanner;

public class StringCapitalize {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- String Capitalize ---");
        System.out.print("Enter any String: ");
        String str = inp.nextLine();

        System.out.printf("Capitalized String is: %s", capitalizeString(str.strip()));
    }

    private static String capitalizeString(String str) {
        String capitalized = "", word = "";
        int initial = 0, last = 0, spaceIndex = 0;
        while (true) {
            // check space index after intial index of every word
            spaceIndex = str.indexOf(" ", initial);
            // if space not found, means after the last space, indexOf returns -1
            if (spaceIndex == -1) {
                last = str.length();
            
            } 
            // else if space found
            else {
                last = spaceIndex;
            }
            word = str.substring(initial, last);
            capitalized += capitalizeWord(word) + " ";
            // as from spaceIndex + 1, check the next space, and next word starting index
            // bcz indexOf starts checking index of a substring including the index we gave
            initial = last + 1;
            if (last == str.length()) {
                break;
            }
        }
        return capitalized;
    }

    private static String capitalizeWord(String word) {
        String capital = Character.toUpperCase(word.charAt(0)) + word.substring(1);
        return capital;
    }
}
