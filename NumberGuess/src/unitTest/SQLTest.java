package unitTest;

import static org.junit.Assert.*;
import mapper.SQLmapper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.User;
import database.DatabaseCon;

public class SQLTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveUser() {
		System.out.println("saveUser");
		
		User user = new User("Anders", "Al-saffar", "brugernavn", "pw");
		
		boolean expResult = true;
		boolean result = SQLmapper.saveUser(user);
		assertEquals(expResult, result);
	}

}
