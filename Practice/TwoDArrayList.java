import java.util.ArrayList;
import java.util.Scanner;

public class TwoDArrayList {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<ArrayList<String>> myList = new ArrayList<>();
        
        // first add your required num of internal array lists in the outer array list
        // suppose I want to add 3
        // whenever empty; don't use for each loop
        for (int i = 0; i < 3; i++) {
            myList.add(new ArrayList<>());
        }

        
        // taking input 
        String str = "";
        for (ArrayList<String> internalList: myList) {
            while (true) {
                System.out.print("Enter any String: ");
                str = inp.nextLine().strip();

                if (str.equals("-1")) {
                    break;
                } 
                internalList.add(str);
            }
        }

        // using normal for loop
        // // here the size has been set to the number of internal lists in a list
        // for (int i = 0; i < myList.size(); i++) {
        //     while (true) {
        //         System.out.print("Enter any String: ");
        //         str = inp.nextLine().strip();

        //         if (str.equals("-1")) {
        //             break;
        //         } 
        //         myList.get(i).add(str);
        //     }
        // }
        System.out.println(myList);
    }
}