import java.util.Scanner;

public class LeapYear{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = inp.nextInt();

        String isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ?
                         "Leap Year" : "Not Leap Year";

        System.out.print(year + "is " + isLeap);
    }
}