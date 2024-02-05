import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String inputString = "";
        Scanner string = new Scanner(System.in);

        System.out.println("        --- Palindrome Checker ---");
        System.out.print("Enter any String: ");
        inputString = string.nextLine();
        string.close();

        if (isPalindrome(inputString)) {
            System.out.print("The String '" + inputString + "' is Palindrome.");
        }
        else{
            System.out.print("The String '" + inputString + "' is not Palindrome.");
        }
    }

    static boolean isPalindrome(String check) {
        if (check.length() == 0 || check.length() == 1){
            return true;
        }

        check = check.toLowerCase();
        char start, end;

        for (int index = 0; index <= check.length() / 2; index++) {
            start = check.charAt(index);
            end = check.charAt(check.length() - 1 - index);

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}