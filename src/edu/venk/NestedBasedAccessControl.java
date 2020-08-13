package edu.venk;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NestedBasedAccessControl {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BaseClass baseClass = new BaseClass();
        BaseClass.NestedClass nestedClass = baseClass.new NestedClass();
        // calls nestedPublic method
        nestedClass.nestedPublic();
        // access private method of base class directly
        Method declaredMethod = baseClass.getClass().getDeclaredMethod("privateMethod");
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(baseClass);
        // can't access if set to false as below
       /* declaredMethod.setAccessible(false);
        declaredMethod.invoke(baseClass);
*/
        // with java 11, we can access inner class members using
        Class<?> nestHost = baseClass.getClass().getNestHost();
        Method[] declaredMethodsOfNestHost = nestHost.getDeclaredMethods();
        System.out.println("Base class details: ");
        System.out.println("Base class name: " + nestHost.getName());
        for (int i = 0; i < declaredMethodsOfNestHost.length; i++) {
            System.out.println(declaredMethodsOfNestHost[i].getName());
        }

        Class<?>[] nestMembers = baseClass.getClass().getNestMembers();
        System.out.println("Members of nested class details: ");
        for (int i = 1; i < nestMembers.length; i++) {
            System.out.println("nested Member name:" + nestMembers[i].getName());
            System.out.println("nested Member methods are:");
            Method[] declaredMethods = nestMembers[i].getDeclaredMethods();
            for (int j = 0; j < declaredMethods.length; j++) {
                System.out.println(declaredMethods[j].getName());
            }
            System.out.println();
        }
        // nestMembers[0] is always the nest host

        /*(BaseClass) nestHost;
        boolean b =  instanceof BaseClass;
        System.out.println(b);
        if(nestMembers[0] instanceof BaseClass){
            System.out.println(b1.);
        }*/
        // all these 4 will print true
        System.out.println(baseClass.getClass().isNestmateOf(nestMembers[1]));
        System.out.println(nestedClass.getClass().isNestmateOf(nestMembers[1]));
        System.out.println(nestedClass.getClass().isNestmateOf(baseClass.getClass()));
        System.out.println(nestMembers[0].isNestmateOf(nestMembers[1]));

        // below line will throw java.lang.ClassCastException
        // : Cannot cast java.lang.Class to edu.venk.BaseClass as both are of different types
        //System.out.println(nestMembers[0].cast(BaseClass.class).toString());

    }
}


class BaseClass {
    private void privateMethod() {
        System.out.println("Am privateMethod");
    }

    public void publicMethod() {
        System.out.println("Am publicMethod");
    }

    class NestedClass {
        public void nestedPublic() {
            privateMethod();
        }
    }
}
