import java.util.Scanner;
public class PrimeSeries {
    public static void main(String[] args){
        Scanner range = new Scanner(System.in);

        System.out.print("Enter minimum limit: ");
        int minLim = range.nextInt();

        System.out.print("Enter max limit: ");
        int maxLim = range.nextInt();
        range.close();

        seriesPrint(minLim, maxLim);
    }
    public static boolean isPrime(int num) {
        for (int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0){
                return false;
            }      
        }
        return true;
}
    public static void seriesPrint(int mini, int maxi){
        if (maxi > mini) {
            for (int num = mini; num <= maxi; num++) {
                if (num > 1){
                    if (isPrime(num))
                        System.out.println(num);
                }
            }     
        }
        else {
            System.out.print("Invalid Upper Limit!");
            System.exit(0);
        }
    }

}
