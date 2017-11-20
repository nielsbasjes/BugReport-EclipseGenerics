package nl.basjes.bugreport.eclipse.classes;

import java.io.Serializable;

public class Parent implements Serializable {

    private String name;

    protected Parent() {
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Class" + this.getClass().getSimpleName() + ": name is : " + name);
    }

    // -----------------------------------------

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static ParentBuilder<? extends Parent, ? extends ParentBuilder> newBuilder() {
        return new ParentBuilder<>(new Parent());
    }

    @SuppressWarnings("unchecked")
    public static class ParentBuilder<CLASS extends Parent, BUILDER extends ParentBuilder<CLASS, BUILDER>> {
        private final CLASS clazz;

        ParentBuilder(CLASS newCLASS) {
            this.clazz = newCLASS;
        }

        public BUILDER withName(String name) {
            clazz.setName(name);
            return (BUILDER)this;
        }

        public CLASS build() {
           return clazz;
        }

    }
}
