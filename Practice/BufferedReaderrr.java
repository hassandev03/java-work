import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderrr {
    public static void main(String[] args) {
         // BufferedReader; reads from char streams
        // can read line by line

        // with try-catch, no need of closing the stream; auto. closed

        // byte to char stream (InputStreamReader) and then read char stream (Buffered Reader)
      

        // BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in))
        //  => for reading input from keyboard

        try (BufferedReader buffRead = new BufferedReader(new FileReader("D:\\Seasons.txt"))) {
            while (buffRead.ready()) {
                System.out.println(buffRead.readLine());
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}