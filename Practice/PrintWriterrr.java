import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterrr {
    public static void main(String[] args) {
        int age = 20;
        String name = "Hassan";
        try {
            PrintWriter writer = new PrintWriter("output1.txt");
            writer.printf("Name: %s, Age: %d\n", name, age);
            System.out.println("Content has been written to the file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file." + "\n" + e.toString());
        }
    } 
}
