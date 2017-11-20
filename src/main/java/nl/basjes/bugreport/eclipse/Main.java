package nl.basjes.bugreport.eclipse;

import nl.basjes.bugreport.eclipse.classes.Child;
import nl.basjes.bugreport.eclipse.classes.GrandChild;
import nl.basjes.bugreport.eclipse.classes.Parent;

public class Main {
    public static void main(String[] args) {
        // Works fine in Eclipse
        Parent parent = Parent
            .newBuilder()
            .withName("Parent test")
            .build();

        // Works fine in Eclipse
        Child child1 = Child
            .newBuilder()
            .withName("Child test")
            .withSize(42)
            .build();

        // Gives error in Eclipse (note: only changed the order of the methods)
        Child child2 = Child
            .newBuilder()
            .withSize(42)
            .withName("Child test")
            .build();

        // Gives error in Eclipse
        GrandChild grandChild = GrandChild
            .newBuilder()
            .withColor("Blue")
            .withSize(666)
            .withName("GrandChild test")
            .build();

        System.out.println("===============================================");
        parent.run();

        System.out.println("===============================================");
        child1.run();

        System.out.println("===============================================");
        child2.run();

        System.out.println("===============================================");
        grandChild.run();

        System.out.println("===============================================");
    }

}
