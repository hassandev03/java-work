import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        // inputStreamReader; converts byte streams to char stream
        // you have to close the stream as it holds the file aur data, till running of prog.
        
        // with try-catch, no need of closing the stream; auto. closed
        // FileReader('fileName' or 'File obj')
        int letters;
        try (FileReader reader = new FileReader("D:\\Seasons.txt")) {
            
            // .ready() tells whether the stream is ready to read
            while (reader.ready()) {
                // .read() reads characters as integers
                letters = reader.read();
                System.out.println((char) letters);
            }

        }
        catch(IOException e) {
            System.out.println(e.toString());;
        }

        System.out.println();
        // reading line by line; it is done by buffered reader
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Seasons.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            reader.close();
        }


        // reading writing
        File myFile;
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter text file name: ");
        String fileName = inp.nextLine();

        // create instance of file
        myFile = new File("D:\\Programming\\Java\\Practice\\Files\\" + fileName + ".txt");
        // create a file
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write to file (append on)
        try (FileWriter fw = new FileWriter("D:\\Programming\\Java\\Practice\\Files\\" + fileName + ".txt", true)) {
            System.out.print("Enter the text you want to write to file: ");
            String text = inp.nextLine();
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // show contents of a file
        System.out.print("Enter text file name whose contents you want to see: ");
        String showFile = inp.nextLine();
        System.out.println("Contents of File are: ");
        try (BufferedReader br = new BufferedReader(
                new FileReader("D:\\Programming\\Java\\Practice\\Files\\" + showFile + ".txt"))) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // remove a file
        System.out.print("Enter text file name you wanna remove: ");
        String remFile = inp.nextLine();

        // // using Path and Paths
        // try {
        // Path filePath = Paths.get("D:\\Programming\\Java\\Practice\\Files\\" +
        // remFile + ".txt");
        // Files.deleteIfExists(filePath);
        // System.out.println("File Successfully deleted");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // using File class
        File toDelete = new File("D:\\Programming\\Java\\Practice\\Files\\" + remFile + ".txt");
        if (toDelete.exists()) {
            toDelete.delete();
            System.out.println(toDelete.getName() + " has successfully been deleted");
        }
        else {
            System.out.println(toDelete.getName() + "does not exit.");

        }

    }
}
