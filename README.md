What is this?
===
This repo is a simplified version of the bug report I got for an other project of mine.

Turns out that this is an error reported by Eclipse. 
Note that both the commandline javac and IntelliJ IDEA like the code just fine.

So for me this is a bug in Eclipse.

I tested this with 

    Eclipse IDE for Java Developers
    Version: Oxygen.1a Release (4.7.1a)
    Build id: 20171005-1200

What goes wrong?
===
Eclipse gives an error depending on the ORDER of the builder methods that are called.
To me it seems like Eclipse is not using the correct return type of the builder methods because they are overridden using a generic construct.

