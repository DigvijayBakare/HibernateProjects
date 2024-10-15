package ReflectionInJava;

import java.lang.Class;
import java.lang.reflect.*;

class Animal {
}

// put this class in different Dog.java file
class Dog extends Animal {
    public void display() {
        System.out.println("I am a dog.");
    }
}

// put this in ClassReflection.java file
public class ClassReflection {
    public static void main(String[] args) {
        try {
            // create an object of Dog
            Dog1 d1 = new Dog1();

            // create an object of Class
            // using getClass()
            Class obj = d1.getClass();

            // get name of the class
            String name = obj.getName();
            System.out.println("Name: " + name);

            // get the access modifier of the class
            int modifier = obj.getModifiers();

            // convert the access modifier to string
            String mod = Modifier.toString(modifier);
            System.out.println("Modifier: " + mod);

            // get the superclass of Dog
            Class superClass = obj.getSuperclass();
            System.out.println("Superclass: " + superClass.getName());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}