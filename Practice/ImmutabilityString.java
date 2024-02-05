public class ImmutabilityString {
    public static void main(String[] args) {
        // program to print alphabets in a string
        String alphabetSeries = "";

        for (int i = 0; i < 26; i++) {
            alphabetSeries += (char)('a' + i); 
            /** 'a'(char) is and i(int) is implicitly converted to respective unicode(int)
                then unicode(int) value is exlpicitly converted to repective char type and
                then implicitly converted to string, concatenated & stored
            */
        }
        System.out.println(alphabetSeries);

        /** we know string is immutable, so in each iteration previous value of alphabetSeries 
         *  is copied and new char value (which is implicitly converted to string) is
         *  then concantenated with previous value of alphabetSeries and a new string object
         *  is being created and then alphabetSeries is assigned to that object on each itrn.
         *  => so all of the previous objects are dereferenced and take memory space
         *  leading to memory wastage.
         *  e.g. alphabetSeries = "a"; after another iteration: object of a +
         */

    }
}
