package edu.uga.cs1302.txtbuff;

/**
 * @author Dwight Stephen Coles III
 *
 * A class that contains all of the exceptions that are required for the EditableTextLine class.
 */
public class TextLineIndexOutOfBoundsException extends IndexOutOfBoundsException {

    /**
     * Constructs an exception object with no detailed message. It utilizes it's parent 
     * class when it is thrown.
     */
    public TextLineIndexOutOfBoundsException () {
	super(); //calling super to the parent class
    }

    /**
     * Contructs an excpetion object with the specified message, given as the argument.
     *
     * @param errMsg This parameter is the error message that is shown when the expception
     * is thrown.
     */
    public TextLineIndexOutOfBoundsException(String errMsg) {
	super(errMsg); //calling super method from the parent class with the argumented string
    }

    /**
     * Constructs a new exception object with an argument indicating the illegal index.
     * 
     * @param index This parameter is used to construct the error message.
     */
    public TextLineIndexOutOfBoundsException(int index) {
	this( (String) "TextLine index out of range: " + index);
    }
    
}
