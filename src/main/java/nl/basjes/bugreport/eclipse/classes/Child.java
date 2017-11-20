/*
 * Yet Another UserAgent Analyzer
 * Copyright (C) 2013-2017 Niels Basjes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
