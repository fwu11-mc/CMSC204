import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		dataMgr.add("CMSC203",30503,4,"SC450","Jill B. Who-Dunit");
		dataMgr.add("CMSC204",30559,4,"SC450","BillyBob Jones");
		ArrayList<String> list = dataMgr.showAll();
		
		System.out.println(dataMgr.showAll());
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450");
		assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30504 Credits:4 Instructor:Joey Bag-O-Donuts Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:30559 Credits:4 Instructor:BillyBob Jones Room:SC450");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC203 30503 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
