package unitTest;




import static org.junit.Assert.*;
import junit.framework.TestCase;
import mapper.SQLmapper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;


import database.DatabaseCon;

public class DatabaseTest extends TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("DatabaseTest start");
	}

	
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp - OpenConnectionTest");
	}

	
	
	@Test(timeout = 1500)
	public void testDatabaseConnection() {
		//average 1000 ms
		DatabaseCon.openConnection();
		int expResult = 0;
		int result = 0;
		assertEquals(expResult, result);
		
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown - OpenConnectionTest");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		DatabaseCon.closeConnection();
		System.out.println("DatabaseTest end");
	}


}
