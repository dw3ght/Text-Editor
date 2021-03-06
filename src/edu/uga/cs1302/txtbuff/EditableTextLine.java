package edu.uga.cs1302.txtbuff;

/**
 * @author Dwight S Coles III
 * 
 * A class which represents a TextLine that can be manipulated by many methods.
 */
public class EditableTextLine extends TextLine implements Editable{
    
    /**
     * Creating a TextLine variable referring to the TextLine class
     */
    TextLine tl = new TextLine();
    
    /**
     * Creates an uninitialized EditableTextLine
     */ 
    public EditableTextLine() {
        super();
    }
    
    /**
     * Creates a new EditableTextLine object initialized to contain the same characters in 
     * the argument string line.
     *
     * @param line the string that will be in the array of this TextLine.
     */
    public EditableTextLine(String line) {
        super(line);
    }
    
    /**                                                                                            
     * Appends the given string at the end of this  TextLine.
     *                                                                                             
     * @param fragment the string commanded to be appended                                         
     */
    public void append(String fragment) {
    	while(capacity < length() + fragment.length()) {
	    capacity += DEFAULT_SIZE;
    	}
	
	/**
	 * Creating a temporary array that holds the length of the TextLine capacity.
	 */
        char[] temp = new char[capacity()];
	
	//for statement to add the characters from the initial array to the temporary array
        for (int i = 0; i < this.length(); i++) {
	    temp[i] = arr[i]; // adding the characters
        }
	// for loop to add the characters from the string to the end of the temporary array
        for (int z = this.length(), q = 0; z < this.length() + fragment.length(); z++, q++) {
            temp[z] = fragment.charAt(q); // adding the characters
        }
        arr = temp; //assigning the temperorary array back to the initial array
    }
    
    /**                                                                                            
     * Inserts the given string fragmentat the specified indexposition of this TextLine.           
     *                                                                                             
     * @param index the index at which you want to insert the string                               
     * @param fragment the string commanded to be inserted        
     *                                 
     * @throws TextLineIndexOutOfBoundsException exception is thrown if the                         
     * supplied startor endindex isout of bounds of this TextLine.
     */
    public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException {
	
	// While loop to increase the capacity every time the capacity is less than the length() + fragment length
    	while (capacity < length() + fragment.length()) {
	    capacity += DEFAULT_SIZE; //capacity increases
    	}
	
	/**                                                                                        
         * Creating a temporary array that holds the length of the TextLine capacity.              
         */
        char[] temp1 = new char[capacity];
	
	//if statement to throw exception
        if ((index < 0) || (index > capacity)) {
            throw new TextLineIndexOutOfBoundsException(); // throwing the exception
        }
        else { //else run the method
	    // for statemen to add all the characters in the initial array to the temporary array all the way to the given index
            for (int i = 0; i < index; i++) { //stops adding when i reaches the argumented index
                temp1[i]= arr[i]; // adding the characters
            }
	    // for loop to add the characters of teh string to the temp array
            for (int q = index, a = 0;a < fragment.length(); q++, a++) {
                temp1[q] = fragment.charAt(a); // adding characters from the string to the temp array
            }
	    // for loop to add the rest of the characters to the temp array
            for (int y = index + fragment.length(), z = index; y < capacity; y++, z++) {
                temp1[y] = arr[z]; // adding the rest of the characters to the temp array
            }
            arr = temp1; //initializing the temp array to the initial array
        }
    }
    
    /**                                                                           
     * Replaces the characters between start and end in the TextLine with the specified string.    
     *                                                                                             
     * @param start the index of the characters in which you would like to start your replacement. 
     * @param end the index of the charcaters in which you like to complete your replacement.      
     * @param fragment the string you would like to replace the charcaters from start to finish    
     * with.                                                                                       
     *                                                                                             
     * @throws TextLineIndexOutOfBoundsException exception is thrown if the                         
     * supplied startor endindex isout of bounds of this TextLine.                                 
     */
    public void replace(int start, int end, String fragment)
	throws TextLineIndexOutOfBoundsException {
	
	// While loop to increase the capacity every time the capacity is less than the length() + fragment length
    	while (capacity < length() + fragment.length()) {
	    capacity += DEFAULT_SIZE; // capacity increases
    	}
	
	/**                                                                                        
         * Creating a temporary array that holds the length of the TextLine capacity.              
         */
        char[] temp2 = new char[capacity];
	
	/**                                                                                        
         * Creating a temporary array that holds the length of the TextLine capacity.              
         */
	char[] temp3 = new char[capacity];
	
	// if statement to throw the exception
        if (start > capacity || end > capacity || start < 0 || end < 0 || start > end) {
            throw new TextLineIndexOutOfBoundsException(); // throwing the exception
        }
	// else run the method
        else {
	    //for loop to add all the characters from the initial array to the temp array all the way up until the start index
            for (int i = 0; i < start; i++) {
                temp2[i] = arr[i]; // adding characters
            }
	    // for loop to add the characters starting from the end index the second temp array
            for (int z = end+1, y=0; z < capacity; z++, y++ ) {
                temp3[y] = arr[z]; // adding characters to the second array
            }
	    // for loop to add the charcaters from the fragment to the first temp array
            for (int q = 0, p = start; q<fragment.length(); p++, q++) {
                temp2[p] = fragment.charAt(q); // adding characters
            }
	    // for loop to add the rest of the characters to the first temp array
            for (int t = start + (fragment.length()), g = (end + 1); t < capacity &&
                     g < capacity; t++, g++) {
                temp2[t] = arr[g]; // adding characters
            }
            arr = temp2; //initializing the temp array to the initial array
        }
    }
}
