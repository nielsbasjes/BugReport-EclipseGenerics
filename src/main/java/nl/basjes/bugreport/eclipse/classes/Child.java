package nl.basjes.bugreport.eclipse.classes;

import java.io.Serializable;

public class Child extends Parent implements Serializable {

    private long size = -1;

    protected Child() {
        super();
    }

    protected void setSize(long size) {
        this.size = size;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Class" + this.getClass().getSimpleName() + ": size is : " + size);
    }

    // -----------------------------------------

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static ChildBuilder<? extends Child, ? extends ChildBuilder> newBuilder() {
        return new ChildBuilder<>(new Child());
    }

    @SuppressWarnings("unchecked")
    public static class ChildBuilder<CLASS extends Child, BUILDER extends ChildBuilder<CLASS, BUILDER>>
            extends ParentBuilder<CLASS, BUILDER> {
        private final CLASS clazz;

        ChildBuilder(CLASS newCLASS) {
            super(newCLASS);
            this.clazz = newCLASS;
        }

        public BUILDER withSize(long newSize) {
            clazz.setSize(newSize);
            return (BUILDER)this;
        }

        @Override
        public CLASS build() {
            return super.build();
        }
    }
}
