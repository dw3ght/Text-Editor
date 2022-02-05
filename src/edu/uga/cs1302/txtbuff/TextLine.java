package edu.uga.cs1302.txtbuff;

/**
 * @author Dwight S Coles III
 * 
 * a public class representing a line of text of characters.
 */
public class TextLine {
    
    /**
     * Creating an int which specifies the default capacity of a TextLine(set to 80).
     */
    public static final int DEFAULT_SIZE = 80;
    
    public int capacity; // public variable to store the capacity
    
    /**
     * Creating a public variable arr that will be assecible to create the TextLine
     */
    char[] arr;
    
    static char x = '\u0000'; // public variable that holds basically the null version of a character
    
    /**
     * Constructing an empty TextLine
     */
    public TextLine() {
        capacity = DEFAULT_SIZE; //initializing capacity
        arr = new char[capacity]; //making an array with the size of capacity
    }
    
    /**
     * Contructing a TextLine object initialized to contain the same characters as in teh argument
     * line.
     *
     * @param line the string that will be in the array of this TextLine.
     */
    public TextLine(String line) {
        capacity = DEFAULT_SIZE; // initializing the capacity
	
	//if and while statement to increase capacity when the length of the TextLine increases past the capacity
        if(line.length() > DEFAULT_SIZE) {
            while(capacity < line.length()) {
                capacity += DEFAULT_SIZE; // increasing capacity
            }
        }
	
        arr = new char[capacity]; // initializing a new array with lenght of the capacity variable
	
	//for loop to add the charcaters from the string to the array
        for(int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i); //adding characters
        }
    }
    
    /**
     * Gives the length of this TextLine.
     *
     * @return The number of characters in the TextLine.
     */
    public int length() {
    	char[] temp = new char[capacity()]; // initializing a temporary array
        int count = 0; // initializing a counter variable
	//for loop to add the characters from the initial array to the temp array
        for (int z = 0; z < arr.length; z++) {
	    temp[z] = arr[z]; //adding characters
        }
        arr = temp; // reinitializing the initial array
	//for loop to iterate through the array to count the characters
        for (int i = 0; i < capacity; i++) {
            if (arr[i] != x) { //if arr[i] is not a blank
                count ++; //count increases by 1
            }
        }
        return count;
    }
    
    /**
     * Gives the current capacity of this TextLine.
     *
     * @return The capacity/length of the array.
     */
    public int capacity() {
        return capacity;
    }
    
    /**
     * Returns the index position of the first occurrence of the fragment 
     * substring in this TextLine.
     *
     * @param fragment the string/substring the user is looking for in this TextLine.
     *
     * @return the index of the string/substring , and -1 if the fragment is not found.
     */ 
    public int indexOf(String fragment) {
	//for loop to find the index of the fragment
        for (int i = 0;i < this.length(); i++) {
            int iHolder = i; // initializing a holder
            int z = 0; // initializing a public variable to be used in the while loop

	    //while loop to find the fragment
            while(arr[i] == fragment.charAt(z)) {
            	if(z == fragment.length()-1) { // if statement that proves the word was found
		    return iHolder;
            	}
            	i++; //increases if the letter at the indices match
            	z++; //increases if the letter at the indices match
            }
            
            z = 0;
            i = iHolder;
        }
        return -1;
    }
    
    /**
     * Returns the index position of the first occurrence of the fragment substring
     * in this TextLine, starting at the specified index fromIndex.
     *
     * @param fragment the string/substring the user is looking for in this TextLine.
     * @param fromIndex the index where you begin searching for the string fragment.
     *
     * @throws TextLineIndexOutOfBoundsException exception if fromIndex is out of bounds
     * of this TextLine
     *
     * @return the index of the string/substring , and -1 if the fragment is not found.
     */
    public int indexOf(String fragment, int fromIndex) throws TextLineIndexOutOfBoundsException {
	// if statement to throw excpetion
	if ((fromIndex < 0) || (fromIndex > capacity)) { //if index is out of the array's bounds
           throw new TextLineIndexOutOfBoundsException();
        }
        else { //else run the method
	    // for loop to find the String from the given index
            for (int i = fromIndex;i < this.length(); i++) {
                int iHolder = i;
                int z = 0;
		
		//while loop to find the fragment 
                while(arr[i] == fragment.charAt(z)) {
		    if (z == fragment.length() - 1) { //if statement to prove the fragment was founded
                		return iHolder;
		    }
		    i++;
		    z++;
                }
                
                z = 0;
                i = iHolder;
            }
	    return -1;
	}
    }
    
    /**
     * Returns true or false if this TextLine has the same characters as the argument obj.
     *
     * @param obj is the object of character you would compare the characters in this textLine to.
     *
     * @return true if the TextLine has the same characters, and no if the Textline doesn't contain
     * the same characters.
     */
    public boolean equals(Object obj) {
        String test = obj.toString(); //assigning a string variable from obj
        int checker = 0; //initializing a checker variable
        boolean placer = false;
	int count = 0;
	
	//for loop to get the length of the characters in the array
	for (int i = 0; i < capacity; i++) {
            if (arr[i] != x) {
                count ++;
            }
        }
	
	// for loop to loop through the array
        for (int i = 0;i < capacity; i++) {
            x = arr[i];
            if (arr[i] == test.charAt(0)) { //if the characters at i are equal it will move onto the for loop
		
		//for loop to see if the Textline and obj are equal
                for (int z = 0; z < test.length(); z++) {
		    //testing if the characters are equal from both the obj and TextLine
                    if (arr[i] == test.charAt(z)) { //if it is then i and checker increase by 1
                        i++;
                        checker++;
			//if checker equals the test.length() then theyre equal and the arrays length.
			//Also checks if the obj variable is an instance of the TextLine or EditableTextLine 
			if ((checker == test.length() && checker == count) && ((obj instanceof TextLine) || (obj instanceof EditableTextLine))) {
			    placer = true;
                        }
                        else {
                            placer = false;
                        }
                    }
                }
            }
        }
        return placer;
    }

    /**
     * Returns the contents of this TextLine represented as a Java String.
     * 
     * @return the content of this TextLine in a Java string format.
     */
    public String toString() {
	
        String toString = ""; //initializing a string variable
	
	//for loop to iterate throuhg through the array to create the string
        for (int i = 0; i < capacity; i++) {
            if (arr[i] != x) { //if the character at i is not a 'blank'
                toString += arr[i]; //add the character
            }
        }
        return toString;
    }
}
