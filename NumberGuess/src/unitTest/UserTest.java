/**
 * 
 */
package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.User;

/**
 * @author Anders Al-saffar
 *
 */
public class UserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link classes.User#User()}.
	 */
	@Test
	public void testUser() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link classes.User#User(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUserStringStringStringString() {
		fail("Not yet implemented"); // TODO
	}
	User user;
	/**
	 * Test method for {@link classes.User#getFirstname()}.
	 */
	@Test
	public void testGetFirstname() {
		System.out.println("getUser");
        user = new User("Anders", "Al-saffar", "brugernavn", "pw");
        String expResult = "Anders";
        String result = user.getFirstname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
	}

	/**
	 * Test method for {@link classes.User#setFirstname(java.lang.String)}.
	 */
	@Test
	public void testSetFirstname() {
		System.out.println("setUser");
        String _firstname = "Anders";
        user = new User();
        user.setFirstname(_firstname);
        // TODO review the generated test code and remove the default call to fail.
        
	}

	/**
	 * Test method for {@link classes.User#getLastname()}.
	 */
	@Test
	public void testGetLastname() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link classes.User#setLastname(java.lang.String)}.
	 */
	@Test
	public void testSetLastname() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link classes.User#getUsername()}.
	 */
	@Test
	public void testGetUsername() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link classes.User#setUsername(java.lang.String)}.
	 */
	@Test
	public void testSetUsername() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link classes.User#getPassword()}.
	 */
	@Test
	public void testGetPassword() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link classes.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		fail("Not yet implemented"); // TODO
	}



}
