/** String builder object is mutable; unlike String object, change can be made to original
 *  object without creating  new object (everytime change is made and then reassigning 
 *  the reference variable to the new object created).
 */
public class StringBuilderUse {
    public static void main(String[] args) {
        StringBuilder alphaSeries = new StringBuilder("");

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            alphaSeries.append(ch);
            /** here, the change is made to original object (appending occurs)
             *  previous value of alphaSeries is not copied everytime, previous object is
             *  dereferenced and a new object formed by contatenation is not formed
             *  rather, ch object which is converted to string is appended to alphaSeries
             */
        }
        System.out.println(alphaSeries.toString());
        StringBuilder origSeries = new StringBuilder(alphaSeries);

        // Note: change made at any place within scope, will change the original object

        // some methods

        System.out.println(alphaSeries.indexOf("e")); // returns index of a substring

        alphaSeries.deleteCharAt(1); // deletes character at specified index
        System.out.println(alphaSeries);

        alphaSeries.delete(7, 10); 
        // deletes substring; starts from startIndex and goes to endIndex - 1
        System.out.println(alphaSeries);

        alphaSeries.insert(5, "game"); // inserts a string at specific index
        System.out.println(alphaSeries);

        alphaSeries.reverse(); // reverses the string
        System.out.println(alphaSeries);

        System.out.println(alphaSeries.compareTo(origSeries)); 
        // compares two string builder objects
        // returns: 1. 0 if two objects are equal
        // 2. negative integer if our object (alphaSeries) is smaller than argument obj
        // 3. positive integer if our object (alphaSeries) is greater than orgument obj
    }
}
