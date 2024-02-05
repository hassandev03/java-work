import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] nums = {6, 8, 10, 4, 2, 3, 12, 18, 16, 20, 14, 1, 7, 5, 9, 15, 13, 17, 11, 19};
        Arrays.sort(nums);

        System.out.println("\t --- Binary Search --- ");
        System.out.print("Enter integer: ");
        byte reqNum = inp.nextByte();
        inp.close();

        int index = BinSearch(reqNum, nums);
        if (index < 0) {
            System.out.printf("Element not found!\nInsertion Index - 1: %d", index);
        }
        else {
            System.out.printf("%d is present at index %d.", reqNum, index);
        }

    }
    static byte BinSearch(byte reqNum, int[] nums){
        byte start = 0;
        byte end = (byte) (nums.length - 1);
        byte mid;
        while (end >= start) {
            mid = (byte) ((start + end) / 2);
            if (reqNum > nums[mid]) {
                start = (byte) (start + 1);
            }
            else if (reqNum < nums[mid]) {
                end = (byte) (start - 1);
            }
            else {
                return mid;
            }
        }
        return (byte) (-start - 1);
    }
}