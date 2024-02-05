import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CommonElements {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\t --- Common Elements ---");
        System.out.println("Which data-type arrays you want to create? ");
        System.out.println(" Integer (Enter \'I\')");
        System.out.println(" Floating Point\\Decimal (Enter \'F\')");
        System.out.println(" Character (Enter \'C\')");
        System.out.println(" String (Enter \'S\')");
        char choice;
        while (true) {
            System.out.print("Enter your choice: ");
            choice = Character.toLowerCase(inp.next().charAt(0));

            switch (choice) {
                case 'i', 'f', 'c', 's':
                    break;

                default:
                    System.out.println("Wrong Choice!");
                    continue;
            }
            break;
        }
        System.out.print("Enter the number (of arrays to be created): ");
        short numOfArrays = inp.nextShort();

        System.out.print("Enter the length (of each array): ");
        short lengthofArray = inp.nextShort();

        switch (choice) {
            case 'i':
                intArrayIntersection(numOfArrays, lengthofArray);
                break;

            case 'f':
                floatArrayIntersection(numOfArrays, lengthofArray);
                break;

            case 'c':
                charArrayIntersection(numOfArrays, lengthofArray);
                break;

            default:
                strArrayIntersection(numOfArrays, lengthofArray);
                break;
        }
    }

    public static void intArrayIntersection(short numOfArrays, short lengthofArray) {
        long[][] intArrays = new long[numOfArrays][lengthofArray];
        short arrayCount = 1;

        // taking input
        for (long[] array : intArrays) {
            for (int i = 0; i < lengthofArray; i++) {
                System.out.printf("Enter integer value for Array %d: ", arrayCount);
                array[i] = inp.nextLong();
            }
            arrayCount++;
        }

        ArrayList<Long> checkingList = new ArrayList<>();
        for (long num: intArrays[0]) {
            checkingList.add(num);
        }
        ArrayList<Long> commonElements = new ArrayList<>();
        for (int i = 1; i < numOfArrays; i++) {
            for (long num: checkingList) {
                for (int j = 0; j < lengthofArray; j++)
                    if (num != intArrays[i][j]) {
                        if (commonElements.contains(num)) {
                            commonElements.remove(commonElements.indexOf(num));
                            break;
                        }
                    }
                    else {
                        if (!commonElements.contains(num)) {
                            commonElements.add(num);
                    }
            }
            checkingList = commonElements;
        }
    }
        System.out.printf("Common elements in %d Arrays:\n", numOfArrays);
        for (long num: commonElements) {
                System.out.println(num);
            
        }
    }

    public static void floatArrayIntersection(short numOfArrays, short lengthofArray) {
    }

    public static void charArrayIntersection(short numOfArrays, short lengthofArray) {
    }

    private static void strArrayIntersection(short numOfArrays, short lengthofArray) {
    }
}
