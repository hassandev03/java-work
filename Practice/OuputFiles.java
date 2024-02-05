import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class OuputFiles {
    public static void main(String[] args) {
        // streams work with bytes (unicodes)
        // output stream writes only chars like input stream reads only chars
        // OutputStream outObj = System.out;
        // try {
        //     // range exceeded of unicode
        //     // .write() takes unicode character only (int value of character)
        //     outObj.write(😀);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        // try (InputStreamReader inpObj = new InputStreamReader(System.in)){
        //     int ch;
        //     System.out.print("Enter any char:");
        //     while (true) {
        //         ch = inpObj.read();
        //         if ((char) ch == '0') 
        //             break;
        //         System.out.println((char) ch);
        //     }
        // }
        // catch (IOException e) {
        //     e.printStackTrace();
        // }

        
        // try (OutputStreamWriter outObj = new OutputStreamWriter(System.out);) {
        //     // .write() takes unicode character(int value of character) or arrays of char
        //     outObj.write('6');
        //     outObj.write('b');
        //     outObj.write(66);
        //     outObj.write('%');
        //     char[] arr = "game is love".toCharArray();
        //     outObj.write(arr);

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        Scanner inp = new Scanner(System.in);
        // if you want to append; use true after file name in FileWrite Constructor
        try (FileWriter fr = new FileWriter("D:\\Programming\\Java\\Practice\\Files\\testFile.txt", true)) {
            System.out.print("Enter text you want to append to file: ");
            String text = inp.nextLine();
            fr.write("\n" + text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // using buffered writer
        // .newLine() for new line insertion
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Programming\\Java\\Practice\\Files\\testFile.txt", true))) {
            System.out.print("Enter text you want to append to file: ");
            String text = inp.nextLine();
            bw.newLine();
            bw.write(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
