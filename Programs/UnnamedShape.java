import java.util.Scanner;

public class UnnamedShape {
    public static void main(String[] args) {
        int length;
        Scanner size = new Scanner(System.in);

        System.out.println("        --- Unnamed Shape ---");
        System.out.print("Enter the length of pattern: ");
        length = size.nextInt();
        size.close();

        for (int row = 1; row <= length ; row++){

            for (int j = 1; j <= length ; j++) {

                if (row == 1 || row == length)
                    System.out.print("*");

                else {

                    if (j == 1 || j == length)
                        System.out.print(" ");
                        
                    else
                        System.out.print("*");
                }
            } 
        System.out.println(); 
        }
    }
}
