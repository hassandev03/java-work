import java.util.Scanner;

public class LinearEquation {
    public static void main(String[] args){
        float a, b, c, d, e, f, x, y;
        Scanner valuesInp = new Scanner(System.in);

        System.out.println("        --- Linear Equation Solver ---");
        System.out.print("Enter values for 'a', 'b', 'c', 'd', 'e', 'f': ");
        a = valuesInp.nextFloat();
        b = valuesInp.nextFloat();
        c = valuesInp.nextFloat();
        d = valuesInp.nextFloat();
        e = valuesInp.nextFloat();
        f = valuesInp.nextFloat();
        valuesInp.close();

        if (a * d - b * c != 0) {
            x = (e * d - b * f) / (a * d - b * c);
            y = (a * f - e * c) / (a * d - b * c);

            System.out.print("x = " + x + "\ny = " + y);
        }
        else {
            System.out.println("No Solution Exists!");
        }
    }
}
