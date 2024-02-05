public class ArrayElementOccurance {
    public static void main(String[] args) {
        int newArray[] = {5, 7, -3, 6, 31, 56, 29, 12, 19, 42, 10};

        byte num = Byte.parseByte(System.console().readLine("Enter integer to find occurances: "));

        byte occurance = 0;
        for (int i: newArray) {
            if (i == num) {
                occurance++;
            }
        }
        System.out.printf("Occurance of %d is: %d", num, occurance);
    }
}
