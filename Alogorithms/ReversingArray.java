import java.util.Arrays;

public class ReversingArray {
    public static void main(String[] args) {
        byte[] arr = {5 ,6 ,4 ,3, 54, 7 ,3};
        System.out.println("Original Array is: " + Arrays.toString(arr));

        byte start = 0, end = (byte) (arr.length - 1);
        byte temp;
        for (; start < end; start++, end--) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        System.out.println("Reversed Array is: " + Arrays.toString(arr));
    }
}