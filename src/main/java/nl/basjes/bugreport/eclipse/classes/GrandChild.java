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

public class GrandChild extends Child implements Serializable {

    private String color = "Red";

    private GrandChild() {
        super();
    }

    protected void setColor(String color) {
        this.color = color;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Class" + this.getClass().getSimpleName() + ": color is : " + color);
    }

    // -----------------------------------------

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static GrandChildBuilder<? extends GrandChild, ? extends GrandChildBuilder> newBuilder() {
        return new GrandChildBuilder<>(new GrandChild());
    }

    @SuppressWarnings("unchecked")
    public static class GrandChildBuilder<CLASS extends GrandChild, BUILDER extends GrandChildBuilder<CLASS, BUILDER>>
            extends ChildBuilder<CLASS, BUILDER> {
        private final CLASS clazz;

        GrandChildBuilder(CLASS newCLASS) {
            super(newCLASS);
            this.clazz = newCLASS;
        }

        public BUILDER withColor(String newColor) {
            clazz.setColor(newColor);
            return (BUILDER)this;
        }

        @Override
        public CLASS build() {
            return super.build();
        }
    }
}
