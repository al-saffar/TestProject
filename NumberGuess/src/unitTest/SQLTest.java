package unitTest;

import static org.junit.Assert.*;
import mapper.SQLmapper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import classes.User;
import database.DatabaseCon;

public class SQLTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	User userTest = new User();
	
	
	@Before
	public void setUp() throws Exception {
		
	
	 userTest.setFirstname("Andere");
	 userTest.setLastname("Alssafar");
	 userTest.setUsername("testtest");
	 userTest.setPassword("123456");
	 
	
	}

	@After
	public void tearDown() throws Exception {
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
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean expResult3 = true;
			boolean result3 = SQLmapper.deleteUser(id);
			assertEquals(expResult3, result3);
			
			
		}
	}

//	@Test
//	public void testLoginAndGetID() {
//		System.out.println("Login");
//
//		String username = "Muhsin";
//		String pass = "pass";
//
//		int expResult = 1;
//		int result = SQLmapper.loginAndGetID(username, pass);
//		assertEquals(expResult, result);
//	}

}
