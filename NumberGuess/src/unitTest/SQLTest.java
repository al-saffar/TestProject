package unitTest;

import junit.framework.TestCase;
import mapper.SQLmapper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.User;

public class SQLTest extends TestCase {

	
	private User userTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("Starting junit method..");
	}

	
	@Before
	public void setUp() throws Exception {
     userTest = new User();
	
	 userTest.setFirstname("Andere");
	 userTest.setLastname("Alssafar");
	 userTest.setUsername("testtest");
	 userTest.setPassword("123456");
	 
	}


	@Test
	public void testUser_insert_login_delete() {
		System.out.println("Saving user...");

		boolean expResult = true;
		boolean result = SQLmapper.saveUser(userTest);
		assertEquals(expResult, result);

		try {
			Thread.sleep(4000);
			System.out.println("user saved: "+ userTest.getUsername());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int id = -1;
		id = SQLmapper.loginAndGetID(userTest.getUsername(), userTest.getPassword());

		if (id < 0) {
			fail("No user with this ID");
		} else {
			String expResult2 = userTest.getUsername();
			User userResult = SQLmapper.getUserInfo(id);
			assertEquals(expResult2, userResult.getUsername());

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean expResult3 = true;
			boolean result3 = SQLmapper.deleteUser(id);
			assertEquals(expResult3, result3);
			
			
		}
	}
	
	@After
	public void tearDown() throws Exception {
		userTest = null;
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Closing junit method..");
	}


}
