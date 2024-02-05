import java.util.ArrayList;

public class OperatorsAndPrinting {
    public static void main(String[] args) {

        //          Plus (+) Operator

        /** in char type, print method converts chars to their repective unicode value and then
            adds them and prints them
        */
        System.out.println('a' + 'c');
        // here new object "ac" will be created and then printed


        /** while adding the string types, print method just 
            concatenates the strings and then prints it
          */ 
        System.out.println("a" + "b");


        /**  while adding char type and int type, char is converted into respective unicode
             value and then added with int type and finally printed
        */
        System.out.println('b' + 5);
        System.out.println((char) ('a' + 5));


        /** while adding in string and int type, print method converts int to
            Integer (Wrapper) Class and then converts that to string type,
            concatenates and then prints
        */
        System.out.println("h" + 7);


        /** while adding in string and char, print method converts char to
            string , concatenates and then prints
        */
        System.out.println("Name:" + 'H');

        
        /** in print function, Plus (+) operator can only be used with primitives
         *  in case of non-primitives (objects) it does not work, except it only works
         *  when atleast one of the non-primitives is String type
         *  the below one, will not work
         */
        // System.out.println(new ArrayList<>() + new int[]{}); // error, + is undefined
        // System.out.println(5 + new int[]{});  // error, + is undefined

        // the following will work
        System.out.println(new ArrayList<>() + " " + new int[]{});
        System.out.println(5 + " " + new int[]{});


        // string and char and int
        String str = "";
        str += 'a' + 2;
        System.out.println(str);

        //          Subtraction (-) Operator
        // it is only defined for primitives, not for non-primitives (objects)
    
    }
}
