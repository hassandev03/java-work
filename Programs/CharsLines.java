import java.util.Scanner;

public class CharsLines {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- No. of Characters and Lines ---");
        System.out.print("Enter Length of Page: ");
        float length = inp.nextFloat();

        System.out.print("Enter Width of Page: ");
        float width = inp.nextFloat();

        System.out.print("Enter Top Margins: ");
        float top = inp.nextFloat();

        System.out.print("Enter Bottom Margins: ");
        float bottom = inp.nextFloat();

        System.out.print("Enter Left Margins: ");
        float left = inp.nextFloat();

        System.out.print("Enter Right Margins: ");
        float right = inp.nextFloat();

        System.out.print("Enter Point Size: ");
        float pointSize = inp.nextFloat();

        System.out.print("Are the lines double-spaced (Enter 'true'/'false'): ");
        boolean doubleSpace = inp.nextBoolean();

        pointSize = doubleSpace ? pointSize * 2: pointSize;
        int lines =  (int) (((length - (top + bottom)) * 72.0) / pointSize);
        int charsInLine = (int) (((width - (right + left)) * 72.0) / pointSize);

        System.out.println("Number of Characters per Line: " + charsInLine); 
        System.out.println("Number of Lines on the Page: " + lines); 
    }
}