import java.util.Arrays;

/**
        ***  array searching using binary search  ***
    => elements must be sorted before using binary search

    Syntax:  binarysearch(arrayName, element)

    Returns: If element found; index of element
            If not found, then -(insertionIndex + 1)

    Insertion Index: where element must be inserted in a a sorted array,
                    mainting the sorted form of array.


            ***  Comparing arrays  ***
    => never use array1 == array2; returns 'false'
    => never use '==' for non-primitive data-types' comparison

    Arrays.compare(array1, array2);
    
 */ 
public class ArraySearchingComparing {
    public static void main(String[] args) {

        // searching arrays
        int intArray[] = {5, 7, -3, 6, 31, 56, 29, 12, 19};
        Arrays.sort(intArray); // array sorted
        System.out.println("Index of 19: " + Arrays.binarySearch(intArray, 19));

        char[] charArray = {'e', 'f', 'i', 'j', 'm', 'n', 'q', 't'};
        System.out.println("'k' not present, so -(insertionIndex + 1): " 
                            + Arrays.binarySearch(charArray, 'v'));
        

        // array comparison
        int myArray[] = {5, 7, -3, 6, 31, 56, 29, 12, 19};
        int gameArray[] = {5, 7, -3, 6, 31, 65, 29, 12, 19};
        int classArray[] = {5, 7, -3, 6, 31, 56, 29, 12, 19};

        System.out.println("\nDo 'myArray[]' equals 'gameArray[]': "
                            + Arrays.equals(myArray, gameArray));

        System.out.println("Do 'myArray[]' equals 'classArray[]': "
                            + Arrays.equals(myArray, classArray));
    }
}