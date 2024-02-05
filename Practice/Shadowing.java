public class Shadowing { // using two variables with same name within the scope that overlapse

    static int num = 50;    // this will be shadowed at line 8
    public static void main(String[] args) {
    System.out.println(num); //     num: 50

    int num = 25;   // class variable (num) at line 4 is shadowed by this
    System.out.println(num); //     num: 44

    printing();
    deepUnderstanding();
    }
    static void printing() {
        System.out.println(num);    //  num: 50
    }

    static void deepUnderstanding() {
        int num;  // here variable is declared but doesn't have a value
        // System.out.println(num);  // gives error as variable not initialized and class variable
                                    // cannot be accessed

        num = 25;  // scope begins where variable is initalized
        System.out.println(num);    // num: 25
    }
}
