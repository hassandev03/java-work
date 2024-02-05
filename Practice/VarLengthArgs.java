import java.util.Arrays;

/**
    when you don't know how many number no. of arguments you are passing,
    use variable length arguments;
    arguments are auto-converted into array of relevant data type
 */ 

public class VarLengthArgs {
    public static void main(String[] args) {
        intVarArgs(5, 6, 7, 9, 8, 3);
        strVarArgs("My", "Class", "String", "Not", "Char");
        mixVarArgs("Game", 67, 56.4f, '$', 'B', 'Z', '%');
    }

   static void intVarArgs(int ...intArrays) {       // works with >=0 arguments
        System.out.println(Arrays.toString(intArrays));
    }

    static void strVarArgs(String ...strArrays) {   // works with >=0 arguments
        System.out.println(Arrays.toString(strArrays));
    }

    /** 
      if mix-type variables are to be passed, then, variable length argument,
      must be at the end
      */ 
    static void mixVarArgs(String strs, int num, float deci, char ...charsArray) {
        System.out.println(strs + " " + num + " " + deci + " " +
                            Arrays.toString(charsArray));
    }
}
