import java.io.IOException;
import java.io.File;
public class FileClass {
	public static void main(String[] args) {
        // Create a File object
        File file = new File("D:\\Other Data\\Seasons.txt");

        // Check if is a file
        System.out.println("Can read file: " + file.canRead());
        
        // Check if file can be read and written
        System.out.println("Can read file: " + file.canRead());
        System.out.println("Can write to file: " + file.canWrite());

        // Check if file exists
        System.out.println("File exists: " + file.exists());

        // Get file name and absolute path
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());

        // Get file length
        System.out.println("File length (in bytes): " + file.length());

        // Check if it's a directory and if it's an absolute path
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Is absolute path: " + file.isAbsolute());

        // Get file path, last modified time, and rename the file
        System.out.println("File path: " + file.getPath());
        System.out.println("Last modified: " + file.lastModified());

        // rename the file
        String newName = "Unwatched Seasons.txt";
        File newFile = new File(file.getParent(), newName);
        if (file.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Failed to rename the file.");
        }

        try {
            // Creating a new file
            if (file.createNewFile()) {
                System.out.println("File created successfully at " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }

        // Deleting the file
       if (file.delete()) {
           System.out.println("File deleted successfully.");
       } else {
           System.out.println("Failed to delete the file.");
       }
    }
}
