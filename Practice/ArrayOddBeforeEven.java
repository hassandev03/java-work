import java.util.Arrays;

public class ArrayOddBeforeEven {
    public static void main(String[] args) {
        int origArray[] = {5, 7, -3, 6, 31, 56, 29, 12, 19, 42, 10};
        int[] copyArray = oddBeforeEven(origArray);

        modifyOrigArray(copyArray, origArray);
        System.out.println(Arrays.toString(origArray));
    }

    static void modifyOrigArray(int[] copyArray, int[] origArray) {
        for (int i = 0; i < copyArray.length; i++) {
            origArray[i] = copyArray[i];
        }
    }

    static int[] oddBeforeEven(int[] origArray) {
        int copyArray[] = new int[origArray.length];
        byte odd = 0, even = (byte) (origArray.length - 1);

        for (int num: origArray) {
            if (num % 2 !=0 ) {
                copyArray[odd++] = num; // odd++: first; copyArray[odd] = num; then odd += 1
            }
            else {
                copyArray[even--] = num;
            }
        }
        return copyArray;
    }
}

