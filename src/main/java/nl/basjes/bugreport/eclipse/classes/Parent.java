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
