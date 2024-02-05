import java.util.Arrays;

/**
            ***  array filling ***
    => when array is created, default value is inserted in whole array
    => Default value: for String Array: 'null'
                      for Int Array: '0'

    Syntax:   Arrays.fill(arrayName, value)
              Arrays.fill(array, startIndex, endIndex+1, value)
        goes to requiredlastIndex - 1 of array, so add +1 so that reaches to req. last index


            ***  Printing arrays  ***
        sout(Arrays.toString(arrayName));
 */ 
public class ArrayFillingPrinting {
    public static void main(String[] args) {
        
        // filling arrays
        String[] strArray = new String[6];
        Arrays.fill(strArray, "strings");
        
        int intArray[] = new int[5];
        Arrays.fill(intArray, 2, 5, 31);

        // printing arrays
        int newArray[] = {5, 7, -3, 6, 31, 56, 29, 12, 19};
        System.out.println(Arrays.toString(newArray));
    }
}
