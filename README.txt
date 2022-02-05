Hello, my name is Dwight Coles III, and this is a simple project that takes in a string
as an argument and delegates the characters of the string in to an array of characters.
In this project, there are many classes that use many mehtods that allow you to manipulate the
TextLine, in we refer to the list of characters. All classes except for the tester class
is in the edu.uga.cs1302.txtbuff package. The tester class will easily be located in the
edu.uga.cs1302.test package.

To begin, you may want to edit your .bash_profile
   Do this by entering:
   - CLASSPATH=.:./classes:~/classes:/home/myid/kkochut/classes/junit-4.13.jar:/home/myid/kkochut/classes/hamcrest-core-1.3.jar
    - export CLASSPATH

You are now ready to compile.

To compile any of the java progams in the edu.uga.cs1302.txtbuff package:

   - beginning in Project3 directory
     - $ javac -d classes src/edu/uga/cs1302/txtbuff/*.java
     - (bash profile must be edited)

To compile any of the java progams in the edu.uga.cs1302.test package:

   - beginning in the Project3 directory
     - $ javac -d classes src/edu/uga/cs1302/test/TextLineTester.java
     - (bash profile must be edited)

After compiling, you are now ready to run.

To run the tester class:
   - $ java org.junit.runner.JUnitCore edu.uga.cs1302.test.TextLineTester
