public class VarArgsSum {
    public static void main(String[] args) {
        sum(5, 6 , 8, 6, 4, 51);
    }

    static void sum(int ...nums) {
        int summation = 0;
        for (int i = 0; i < nums.length; i++) {
            summation += nums[i];
        }
        System.out.println("Sum is: " + summation);
    }
}