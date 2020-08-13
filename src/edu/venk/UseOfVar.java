package edu.venk;

import java.util.ArrayList;

public class UseOfVar {
    public static void main(String[] args) {
        var x = new ArrayList<String>();
        // after this declaration, x is of type Java.util.ArrayList<String>
        System.out.println(x.getClass().getName());

        // use of var in lamda expressions
        MethodWith2Args methodWith2Args = (x1, y1) -> {
            return x1+y1;
        };
        System.out.println(methodWith2Args.addTheArgs(10, 20));

        // without using curly braces
        MethodWith2Args methodWith2Args1 = (x2, y2) -> x2+y2;
        System.out.println(methodWith2Args1.addTheArgs(5,6));

        // no arg type fails with any annotation as below
        //MethodWith2Args methodWith2Args2 = (@Deprecated x2, y2) -> x2+y2;

        // same thing passes if we use var on each argument.
        // NOTE: if we use var declaration for 1 arg, we should
        // use it for both and parenthesis is mandatory
        // below will fail
        //MethodWith2Args methodWith2Args3 = (@Deprecated var x2, y2) -> x2+y2;
        //MethodWith2Args methodWith2Args3 = (@Deprecated var x2, int y2) -> x2+y2;
        //MethodWith2Args methodWith2Args3 = var x2, var y2 -> x2+y2;
        //MethodWith2Args methodWith2Args3 =  x2, y2 -> x2+y2;
        // below will pass
        MethodWith2Args methodWith2Args3 = (@Deprecated var x2, var y2) -> x2+y2;
        System.out.println(methodWith2Args1.addTheArgs(5,7));

    }
}

interface  MethodWith2Args {
    public int addTheArgs(int arg1, int arg2);
}
