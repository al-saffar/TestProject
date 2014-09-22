package unitTest;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import database.DatabaseCon;

public class DatabaseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		DatabaseCon.closeConnection();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp - OpenConnectionTest");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown - OpenConnectionTest");
	}
	
	@Test(timeout = 1000)
	public void DatabaseConnectionTest() {
		//average 1000 ms
		DatabaseCon.openConnection();
		
	}

}
