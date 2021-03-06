
package edu.uga.cs1302.txtbuff;

/**
 * @author Dwight S. Coles
 * 
 * A public interface containing methods for the EditableTextLine class 
 */
public interface Editable {

    /**
     * Appends the given string at the end of this TextLine.
     *
     * @param fragment the string commanded to be appended
     */
    public void append(String fragment);

    /**
     * Inserts the given string fragmentat the specified indexposition of this TextLine.
     *
     * @param index the index at which you want to insert the string
     * @param fragment the string commanded to be inserted
     */
    public void insert(int index, String fragment);

    /**
     * Replaces the characters between start and end in the TextLine with the specified string.
     *
     * @param start the index of the characters in which you would like to start your replacement.
     * @param end the index of the charcaters in which you like to complete your replacement.
     * @param fragment the string you would like to replace the charcaters from start to finish 
     * with.
     */
    public void replace(int start, int end, String fragment);
    
}
