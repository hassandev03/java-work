import java.io.FileWriter;
import java.io.IOException;

public class FileWriterClass {
    public static void main(String[] args) {
        
        // whole string
        String content = "Writing Characters to File";
        try {
            FileWriter writer = new FileWriter("output1.txt");
            writer.write(content);
            System.out.println("Content has been written to the file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // characters
        String content1 = "Writing Characters to File";
        try {
            FileWriter writer = new FileWriter("output1.txt");
            for (int i = 0; i < content1.length(); i++) {
                writer.write(content1.charAt(i));
            }
            System.out.println("Content has been written to the file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // char array
        try {
            char[] charArray = { 'J', 'a', 'v', 'a', '-', '2', '1' };
            FileWriter writer = new FileWriter("output2.txt");
            writer.write(charArray);
            writer.flush();
            System.out.println("Content has been written to the file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file." + "\n" + e.toString());
        }

    }
}