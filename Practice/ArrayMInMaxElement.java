public class ArrayMInMaxElement {
    public static void main(String[] args) {
        int newArray[] = {5, 7, -3, 6, 31, 56, 29, 12, 19};

        int min = newArray[0];
        int max = newArray[0];

        for (int i: newArray) {
            if (i > max) {
                max = i;
            }
            else if (i < min) {
                min = i;
            }
        }
        System.out.printf("Min Value: %d%nMax Value: %d", min, max);
    }
}
