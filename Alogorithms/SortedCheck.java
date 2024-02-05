import java.util.Scanner;

public class SortedCheck {
    public static void main(String[] args) {
        System.out.println("\t --- Array Sorting Check ---");
        // test cases
        int[] numsArray = {6, 8, 10, 4, 2, 3, 12, 18, 16, 20, 14, 1, 7, 5, 9, 15, 13, 17, 11, 19 };
        int[] numsArray1 = {6, 8, 10, 12, 18, 19, 20};
        int[] numsArray2 = {20, 19,  18, 16, 15, 14, 7, 5};
        if (sortedCheck(numsArray2)) {
            System.out.println("Array is sorted.");
        } else {
            System.out.println("Array is not sorted.");
        }
    }

    private static boolean sortedCheck(int[] numsArray) {
        Scanner inp = new Scanner(System.in);
        boolean isSorted = false;
        char choice;

        System.out.println("Do you want to check in:\n Ascending Order (Enter \'A\')" +
                "\n Decending Order (Enter \'D\')");

        while (true) {
            System.out.print("Enter your choice: ");
            choice = Character.toLowerCase(inp.next().charAt(0));
            switch (choice) {
                case 'a':
                    isSorted = ascendingCheck(numsArray);
                    break;
                case 'd':
                    isSorted = descendingCheck(numsArray);
                    break;
                default:
                    System.out.println("Wrong Choice!");
                    continue;
            }
            return isSorted;
        }
    }

    private static boolean ascendingCheck(int[] numsArray) {
        for (int i = 0; i < numsArray.length - 1; i++) {
            if (numsArray[i] > numsArray[i + 1]){
                return false;
            }
        }
        return true;
    }

    private static boolean descendingCheck(int[] numsArray) {
        for (int i = 0; i < numsArray.length - 1; i++) {
            if (numsArray[i] < numsArray[i + 1]) {
                return false;
            }
        }
        return true;
    }
}