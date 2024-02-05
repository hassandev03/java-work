import java.util.Scanner;
import java.lang.Math;
public class QuadraticEquation{
    public static void main(String[] args){
        float a, b, c, discriminant, root1, root2;
        Scanner valuesInp = new Scanner(System.in);

        System.out.println("      --- Quadratic Equation Solver ---");
        System.out.print("Enter values for 'a', 'b', 'c' (separate by spaces): ");
        a = valuesInp.nextFloat();
        b = valuesInp.nextFloat();
        c = valuesInp.nextFloat();
        valuesInp.close();

        discriminant = (float) b * b - 4 * a * c;

        if (discriminant > 0.0){
            root1 = (float) ((-b + Math.sqrt(discriminant)) / 2 * a);
            root2 = (float) ((-b - Math.sqrt(discriminant)) / 2 * a);

            System.out.println("The equation has two roots: " + root1 + " " + root2);
        }
        else if (discriminant == 0.0){
            root1 = (float) ((-b + Math.sqrt(discriminant)) / 2 * a);

            System.out.println("The equation has one root: " + root1);
        }
        else{
            System.out.println("The equation has no roots");
        }
    }
}