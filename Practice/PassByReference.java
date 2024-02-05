import java.util.Arrays;

public class PassByReference {
    public static void main(String[] args) {
        String naams = "Javasss";
        change(naams);
        System.out.println(naams);

        int[] arrr = {1 ,5, 7, 8};
        System.out.println(arrr);
        change(arrr);
        System.out.println(Arrays.toString(arrr));
        int i;
        String name;

        if (true) {
            i = 10;
            name = "hassani";
        }

        System.out.println(i + name);
        
    }

    static void change(int[] arrayy) {
        System.out.println(arrayy);
        arrayy[2] = 55;
    }

    static void change(String name) {
        name = "python";
    }
    
}