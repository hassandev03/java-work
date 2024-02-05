import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args){
        String exampleString = "      My nAMe is hAsSan raZa  ";
        String age = " 20";

    /** methods don't change original string (as immutable), rather a new object is created
        and we print that new string object 
    */

        System.out.println(exampleString.toUpperCase()); 
        // converts to lowercase

        System.out.println(exampleString.toLowerCase());

        System.out.println(exampleString.length());
        // gives length of string

        System.out.println(exampleString.isEmpty()); 
        /// true if string has no character (blank space will be counted as character)


        System.out.println(exampleString.isBlank()); 
        // true if string has blank space or no character

        System.out.println(exampleString.charAt(5)); 
        // returns character at given index

        System.out.println(exampleString.indexOf('h')); 
        // gives index of character

        System.out.println(exampleString.lastIndexOf('a')); 
        // returns last index of character


        System.out.println(exampleString.concat(age)); 
        // concatenates strings

        System.out.println(exampleString.concat(age).concat(" Games"));
        // multi-concatenation

        System.out.println(exampleString.equals(age)); 
        // compares only values of strings, not memory addresses

        System.out.println(exampleString.charAt(5));
        // returns a character at the specified index

        System.out.println(exampleString.replace("hAsSan", "Muhammad"));
        // replaces a substring with given string

        System.out.println(exampleString.strip());
        // removes tailing and leading white spaces for unicode for various languages

        System.out.println(exampleString.trim());
        // removes just tailing and leading white spaces

        System.out.println(Arrays.toString(exampleString.toCharArray()));
        /** the method creates character array of string and then we used array method to
            convert it into string
         */

        System.out.println(Arrays.toString(exampleString.split(" ")));
        // splits the string at the argument given, and returns array of strings


        System.out.println(exampleString);
        // as you can see, original string is the same
    }

}
