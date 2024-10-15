package ReflectionInJava;

import java.lang.Class;
import java.lang.reflect.*;

class Dog2 {

    // public constructor without parameter
    public Dog2() {

    }

    // private constructor with a single parameter
    private Dog2(int age) {

    }

}

public class ConstructorReflection {
    public static void main(String[] args) {
        try {
            // create an object of Dog
            Dog2 d1 = new Dog2();

            // create an object of Class
            // using getClass()
            Class obj = d1.getClass();

            // get all constructors of Dog
            Constructor[] constructors = obj.getDeclaredConstructors();

            for (Constructor c : constructors) {

                // get the name of constructors
                System.out.println("Constructor Name: " + c.getName());

                // get the access modifier of constructors
                // convert it into string form
                int modifier = c.getModifiers();
                String mod = Modifier.toString(modifier);
                System.out.println("Modifier: " + mod);

                // get the number of parameters in constructors
                System.out.println("Parameters: " + c.getParameterCount());
                System.out.println("");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}