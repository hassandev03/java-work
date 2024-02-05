import java.util.Arrays;

public class ArraySorting {
    public static void main(String[] args) {

        // sorting whole array
        int intArray[] = {5, 7, -3, 6, 31, 56};
        Arrays.sort(intArray);
        
        char[] charArray = {'g', 'h', 'y', 'a', 'Z'};
        Arrays.sort(charArray);

        int[] unicodeArray = {'g', 'h', 'y', 'a', 'Z', '3', 'U'};
        Arrays.sort(unicodeArray);

        String[] strArray = {"Hassan", "Ali", "John", "James"};
        Arrays.sort(strArray);

        //  sorting within a range of indexes
        float[] floatArray = {67.8f, 54.6f, 21.66f, 31.435f, 91.03f, 82.531f};
        /** Arrays.sort(arrayName, startIndex, endIndex+1); 
        goes to requiredlastIndex - 1 of array, so add +1 so that reaches to req. last index*/
        Arrays.sort(floatArray, 2, 6);
        String str = new String(charArray);
        System.out.println(str);
        System.out.println(Arrays.toString(floatArray));
    }
}
