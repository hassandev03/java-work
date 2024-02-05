import java.util.Scanner;

public class LinearSearchAlgo {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] nums = {5, 8, 2, 7, 6, 9, 10};

        System.out.println("\t --- Linear Search --- ");
        System.out.print("Enter the integer: ");
        int reqNum = inp.nextInt();
        inp.close();
        
        if (LinSearch(reqNum, nums) == -1) {
            System.out.println("Element not found!");
        }
        else {
            System.out.printf("%d is at index %d", reqNum, LinSearch(reqNum, nums));
        }
    }
    static int LinSearch(int reqNum, int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == reqNum) {
                return index;
            }
        }
        return -1;
    }
}