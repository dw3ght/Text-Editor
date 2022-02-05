import java.util.Scanner;
import edu.uga.cs1302.txtbuff.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class TextLineTester {
    
    private EditableTextLine eLine;
    
    @Before
    public void setUp(){
	eLine =	new EditableTextLine("Dwight");
    }
	
    // Create the test cases.
    
    // Test Case 1: Instantiation of a default Rectangle object
    //                                                                                                                                                              
    //  
    @Test
    public void testInstantiateDefault() {
	assertEquals( eLine.toString(), "Dwight" );
	assertEquals( eLine.length(), 6 );
    }
    
    // Test Case 2: Testing toString() and that the capacity increases when the length extends past the capacity
    //                                                                                                                                                              
    //
    @Test
    public void testLengthCapacity() {
	String longString = "IMPORTANT: This is a larger project–you will have to dedicate "
	    + "a significant amount of time to it.";
	eLine = new EditableTextLine(longString);
	assertEquals( eLine.capacity(), 160 );
    }
	
    // Test Case 3: Testing that the capacity doesn't increase when the length
    // is the same as the capacity                                                                                                                                                             
    //
    @Test
    public void testELineCapacity() {
	String char80 = "This is 80 charactersxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	eLine = new EditableTextLine(char80);
	assertEquals( eLine.length(), 80 );
	assertEquals( eLine.capacity(), 80 );
    }
    
    // Test Case 3: testing length() and the length of this TextLine                                                                                                                        
    //                                                                                                                                                              
    //
    @Test
    public void testLength() {
	assertEquals( eLine.length(), 6);
    }
    
    // Test Case 4: testing initial capacity                                                                                                                   
    //                                                                                                                                                              
    //
    @Test
    public void testCapacity() {
	assertEquals( eLine.capacity(), 80);
    }
    
    // Test Case 5: testing indexOf at the beginning of this textLine                                                                                                                                 
    //                                                                                                                                                              
    //
    @Test
    public void testindexOfFront() {
	assertEquals( eLine.indexOf("Dw"), 0);
    }
    
    // Test Case 5: testing indexOf in the middle of this TextLine                                                                                                                                       
    //                                                                                                                                                              
    //
    @Test
	public void testindexOfMiddle() {
	assertEquals( eLine.indexOf("wig"), 1);
	}
    
    // Test Case 5: testing indexOf at the end of this TextLine                                                                                                                                         
    //                                                                                                                                                              
    //
    @Test
	public void testindexOfEnd() {
	assertEquals( eLine.indexOf("ht"), 4);
    }
    
    // Test Case 5: testing indexOf when the fragment isn't in this TextLine
    //                                                                                                                                                              
    //
    @Test
    public void testindexOfNone() {
	assertEquals( eLine.indexOf("abc"), -1);
    }
    
    // Test Case 6: testing indexOf(String fragment, int fromIndex) from the beginning
    //                                                                                                                                                              
    //
    @Test
    public void testindexOfPlus() {
	assertEquals( eLine.indexOf("ig",0), 2);
    }
    
    // Test Case 6: testing indexOf(String fragment, int fromIndex) from the middle of this TextLine
    //                                                                                                                                                              
    //
    @Test
    public void testindexOfPlusNone() {
	assertEquals( eLine.indexOf("ig",3), -1);
	}
    
    // Test Case 7: Using the indexOf(String fragment, int fromIndex)
    // with an illegal bound "-9"                                                                                                                                                    
    //
    @Test( expected = TextLineIndexOutOfBoundsException.class )
    public void testIndexOfOutOfBoundsLess() {
    	assertEquals( eLine.indexOf("ig", -9 ), -1);
    }
    
    // Test Case 7: Using the indexOf(String fragment, int fromIndex)
    // with an illegal bound "90"                                                                                                                                                     
    //
    @Test( expected = TextLineIndexOutOfBoundsException.class )
    public void testIndexOfOutOfBoundsMore() {
    	assertEquals( eLine.indexOf("ig", 90 ), -1);
    }
    
    // Test Case 8: testing equals                                                                                                                                                      
    // with a true argument                                                                                                                                                   
    //
    @Test
    public void testEqualsTrue() {
    	TextLine tLine = new TextLine("Dwight");
    	assertEquals( eLine.equals(tLine), true);
    }
    
    // Test Case 8: testing equals                                                                                                                                                      
    // with a false argument                                                                                                                                                    
    //
    @Test
    public void testEqualsFalse() {
    	TextLine tLine2 = new TextLine("Coles");
    	assertEquals( eLine.equals(tLine2), false);
    }
    
    // Test Case 9: testing toString()
    //                                                                                                                                                   
    //
    @Test
    public void testToString() {
    	assertEquals( eLine.toString(), "Dwight");
    }
    
    // Test Case 10: testing append and using toString
    //                                                                                                                                                     
    //
    @Test
    public void testAppend() {
    	eLine.append("Coles");
    	assertEquals( eLine.toString(), "DwightColes");
    }
    
    // Test Case 10: testing append and testing if the capacity increases
    //                                                                                                                                                     
    //
    @Test
    public void testAppendAndCapacity() {
    	String longString = "IMPORTANT: This is a larger project–you will have to dedicate "
	    + "a significant amount of time to it.";
    	eLine.append(longString + longString + longString);
    	assertEquals( eLine.toString(), "Dwight" + longString + longString + longString);
    	assertEquals( eLine.capacity(), 320);
    }
    
    // Test Case 11: testing void insert(int index, String fragment)
    // inserting a string at the beginning of this TextLine
    //
    @Test
    public void testInsertFront() {
    	eLine.insert(0, "Coles");
    	assertEquals( eLine.toString(), "ColesDwight");
    }
    
    // Test Case 11: testing void insert(int index, String fragment)
    // inserting a string in the middle of this TextLine
    //
    @Test
    public void testInsertMiddle() {
    	eLine =	new EditableTextLine("ColesDwight");
    	eLine.insert(5, " , ");
    	assertEquals( eLine.toString(), "Coles , Dwight");
    }
    
    // Test Case 11: testing void insert(int index, String fragment)
    // inserting a string at the end of this TextLine
    //
    @Test
    public void testInsertEnd() {
    	eLine =	new EditableTextLine("Coles , Dwight");
    	eLine.insert(14, ": is a student.");
    	assertEquals( eLine.toString(), "Coles , Dwight: is a student.");
    }
    
    // Test Case 11: testing void insert(int index, String fragment) 
    // inserting a long string at the end of this TextLine
    // Also testing that the capacity increases when we add the long String
    //
    @Test
    public void testInsertLongString() {
    	String longString = ": IMPORTANT: This is a larger project–you will have to dedicate "
	    + "a significant amount of time to it.";
    	eLine.insert(6, longString);
    	assertEquals( eLine.toString(), "Dwight" + longString);
    	assertEquals(eLine.capacity(), 160);
    }
    
    // Test Case 12: testing void insert(int index, String fragment)
    // with illegal index values that are out of bounds - (-1000)
    //
    @Test( expected = TextLineIndexOutOfBoundsException.class )
    public void testInsertOutOfBoundsSmall() {
    	eLine.insert(-1000, "coles");
    	assertEquals( eLine.toString(), "ColesDwight");
    }
    
    // Test Case 12: testing void insert(int index, String fragment)
    // with illegal index values that are out of bounds  - (10000)
    //
    @Test( expected = TextLineIndexOutOfBoundsException.class )
    public void testInsertOutOfBoundsMore() {
    	eLine.insert(100000, ": is a student.");
    	assertEquals( eLine.toString(), "Coles , Dwight: is a student.");
    }
    
    // Test Case 13: testing void replace(int start, int end, String fragment)
    // testing replace at the beginning of this TestLine                                        
    //
    @Test
    public void testReplaceFront() {
    	eLine.replace(0, 1, "1234");
    	assertEquals( eLine.toString(), "1234ight");
    }
    
    // Test Case 13: testing void replace(int start, int end, String fragment)
    // testing replace in the middle of this TestLine                                        
    //
    @Test
    public void testReplaceMiddle() {
    	eLine =	new EditableTextLine("1234ight");
    	eLine.replace(4, 5, " 5678 ");
    	assertEquals( eLine.toString(), "1234 5678 ht");
    }
    
    // Test Case 13: testing void replace(int start, int end, String fragment)
    // testing replace at the end of this TestLine                                         
    //
    @Test
    public void testReplaceEnd() {
    	eLine =	new EditableTextLine("1234 5678 ht");
    	eLine.replace(10, 11, "9 10 11");
    	assertEquals( eLine.toString(), "1234 5678 9 10 11");
    }
    
    // Test Case 11: testing void insert(int start, int end, String fragment)
    // replacing this TextLine with a longString
    // Also making sure the capacity increases when we add the long String
    //
    @Test
    public void testReplaceLongString() {
    	String longString = "IMPORTANT: This is a larger project–you will have to dedicate "
	    		+ "a significant amount of time to it.";
    	eLine.replace(0, 5, longString);
    	assertEquals( eLine.toString(), longString);
    	assertEquals(eLine.capacity(), 160);
    }
    
    // Test Case 14: testing void replace(int start, int end, String fragment)
    // with an illegal start value that is out of bounds                                          
    //
    @Test( expected = TextLineIndexOutOfBoundsException.class )
    public void testReplaceOutOfBoundsLess() {
    	eLine.replace(-5, 5, "123");
    	assertEquals( eLine.toString(), "123");
    }  
    
    // Test Case 14: testing void replace(int start, int end, String fragment)
    // with an illegal end value that is out of bounds
    //
    @Test( expected = TextLineIndexOutOfBoundsException.class )
    public void testReplaceOutOfBoundsMore() {
    	eLine.replace(0, 1000, "Dwight ");
    	assertEquals( eLine.toString(), "Dwight 3");
    }  
    
    
}
