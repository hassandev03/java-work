/**    println method always prints String, no matter what data-type you give to it
 
       everything you print in println metod, java calls 'valueOF()' method to get value of 
       of the object to be printed by calling the 'toString()' method and thus converting
       the object into a String. 
*/

public class StringsPractice {
    public static void main(String[] args) {
        String str1 = "String1";
        String str2 = "String 2";
        String completeString = str1 + " " + str2;
        
        System.out.println(str1 + str2);
        System.out.println(completeString);

        // Auto conversion of int into str
        System.out.println("My Age is: " + 20); // 20 is auto converted into str type

        System.out.println("I was born in: " + 20 + 03); 
            /** 20 + 03 will be converted into str as '203'
            as 20 + 03 will be first converted into str then
            '203' string will be concated to main string */ 
        

        // prevention of auto conversion of int into str
        System.out.println("Date was: " + (30 + 01)); 
        // here 30 + 1 will be calculated as int then concated as str

        // multi-concatenation of strings using concat method
        System.out.println("Java is".concat(" a high-level ").concat("prog. language"));

        // we cannot show print any specific character of string, like that of in python
        //System.out.println(str1[3]); // gives error
    }
}
