import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// initial size if not given; automatically set to 16
// if array list is filled to a some amount; new list is created (say, of double size)
// the elements of old list is copied into the new list; old one deleted
public class ArrayLists {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        // it automatically extends the size
        // initial capacity is not mandatory
        ArrayList <Integer> myList = new ArrayList<>(5);
        myList.add(91);
        myList.add(82);
        myList.add(77);
        myList.add(58);
        myList.add(71);
        myList.add(32);
        myList.add(63);
        myList.add(21);
        myList.add(54);
        myList.add(6, 100);

        // printing
        System.out.println(myList);

        // element replacing 
        myList.set(2, 69);

        // remove element
        myList.remove(4);
        
        //get the element at index
        System.out.println("4th index: " + myList.get(4));
        
        // sort the list
        myList.sort(null);

        // get size of list
        System.out.println("size: "+ myList.size());

        // printing elements
        System.out.println("\t --- Printing ---");
        System.out.println("For Each Loop:");
        for (int num: myList){
            System.out.println(num);
        }
        System.out.println();
        
        // another method of printing
        System.out.println("For Loop:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        System.out.println();
        
        // another efficient and optimized way of printing
        System.out.println("Iterator:");
        Iterator <Integer> myListIterator = myList.iterator();
        // hasNext() checks if next element is present
        while (myListIterator.hasNext()) {
            System.out.println(myListIterator.next());
        }
        System.out.println();
    
        // clean the list
        myList.clear();
        System.out.println("clear method: " + myList);

        // check if empty
        System.out.println("Empty?: " + myList.isEmpty());

        // taking input
        ArrayList <String> strArrList = new ArrayList<>();
        String str;
        System.out.println("\nEnter '-1' to exit!");
        while (true) {
            System.out.print("Enter any string: ");
            str = inp.nextLine();
            if (str.equals("-1")) {
                break;
            }
            
            if (!str.isBlank()) {
                strArrList.add(str);
            }
        }

        // printing
        System.out.println("\nString Array: ");
        for (String string: strArrList) {
            System.out.println(string);
        }
    }
}
