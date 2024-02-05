import java.util.Scanner;

public class SpacedCharacter {
    public static void main(String[] args) {
        String inputString = "", modString = "";
        Scanner string = new Scanner(System.in);

        System.out.println("        --- Spaced Character in String ---");
        System.out.print("Enter any String: ");
        inputString = string.nextLine();
        string.close();

        for (int i = 0; i < inputString.length() ; i++) {
            modString += inputString.charAt(i) + " ";
        }
        System.out.print("The Spaced String is: " + modString.strip());
    }
}
