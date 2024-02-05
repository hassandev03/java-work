import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterrr {
    public static void main(String[] args) {
        String data = "Writing using buffered Writer";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("myfile.txt"));
            writer.write(data);
            writer.flush();
            System.out.println("Content has been written to the file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file." + "\n" + e.toString());
        }

    }
}