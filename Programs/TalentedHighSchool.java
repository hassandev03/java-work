import java.util.Scanner;

public class TalentedHighSchool {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Talented High School ---");

        String[] subjects = {"Mathematics", "English", "Computer Science", "Chemistry", "Physics"};
        System.out.print("Enter the number of students: ");
        int students = inp.nextInt();

        // get student result data
        int[][] resultData = studentResult(subjects, inp, students);

        // individual data
        printResult(resultData);

        // subject statistics
        subjectsStats(resultData, subjects);
    }

    private static void printResult(int[][] resultData) {
        int totalMarks;
        for (int i = 0; i < resultData.length; i++) {
            // reset total marks after each student
            totalMarks = 0;
            // for each student, calculate total marks
            for (int j = 0; j < resultData[i].length; j++) {
                totalMarks += resultData[i][j];
            }
            System.out.printf("Total marks of Student #%d: %d\n", i + 1, totalMarks);
        }
    }

    private static void subjectsStats(int[][] resultData, String[] subjects) {
        // loop through subjects for each student
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("\n\t --- %s Statistics ---\n", subjects[i]);
            // show each student result
            for (int j = 0; j < resultData.length; j++) {
                System.out.printf("Student %d: %d\n", j + 1, resultData[j][i]);
            }
        }
    }

    private static int[][] studentResult(String[] subjects, Scanner inp, int students) {
        // 2d array of data
        // no. internal arrays = no. of students
        // length of each internal array = no. of subjects
        // in each internal array, index 0 will have maths and so on to index 4 which will have physics, respectively
        int[][] data = new int[students][subjects.length];

        for (int i = 0; i < data.length; i++) {
            System.out.printf("\t--- Data of Student %d\n", i + 1);
            
            // for subjects marks entrance
            for (int j = 0; j < subjects.length; j++) {
                System.out.printf("Enter %s Marks out of 100: ", subjects[j]);
                data[i][j] = inp.nextInt();
            }
        }
        return data;
    }
}
