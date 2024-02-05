public class DiffStringObjectsSameValue {
    public static void main(String[] args) {
        // creating string objects with same value but memory location diff
        String str1 = new String("Game");
        String str2 = new String("Game");

        // if we don't use new String(), all the strings are added to string pool,
        // which is a memory area in heap in which strings are stored, and
        // strings reference variables, if have same value, point to same object.
        // this all is due to memory optimization so there is no repetition of objects

        // in this case, the string objects are created outside pool, so they'll have
        // diff memory locations, so these are not equal

        System.out.println(str1 == str2);
    }
}