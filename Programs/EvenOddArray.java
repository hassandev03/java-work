import java.util.Arrays;

public class EvenOddArray {
    public static void main(String[] args) {
        int[] list1 = { 5, 7, 0, 10, 54, 66 };
        int[] list2 = { 65, 33, 0, 71, 5, 83, 45, 1, 8, 12, 86 };
        int[] newArray = evenOdd(list1, list2);
        System.out.println("Modified array is: " + Arrays.toString(newArray));
    }

    private static int[] evenOdd(int[] list1, int[] list2) {
        int[] list3;
        if (list2.length % 2 != 0 && list1.length % 2 == 0) {
            list3 = new int[(list1.length + list2.length) / 2 + 1];
        } else {
            list3 = new int[(list1.length + list2.length) / 2];
        }

        int list3Index = 0, list2Index = 0, list1Index = 1;
        do {
            if (list2Index < list2.length) {
                list3[list3Index] = list2[list2Index];
                list2Index += 2;
                list3Index++;
            }
            if (list1Index < list1.length) {
                list3[list3Index] = list1[list1Index];
                list1Index += 2;
                list3Index++;
            }
        } while (list3Index < list3.length);
        return list3;
    }
}