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

	User user;

	/**
	 * Test method for {@link classes.User#getFirstname()}.
	 */
	// @Test
	// public void testGetFirstname() {
	// System.out.println("getUser");
	// user = new User("Anders", "Al-saffar", "brugernavn", "pw");
	// boolean expResult = true;
	// boolean result = user.getFirstname();
	// assertEquals(expResult, result);

	// }

	/**
	 * Test method for {@link classes.User#setFirstname(java.lang.String)}.
	 */
	@Test
	public void testSetFirstname() {
		//new test that should return true, because firstname => 2 
		System.out.println("setUser");
		String _firstname = "Anders";
		user = new User();
		boolean expResult = true;
		boolean result = user.setFirstname(_firstname);
		assertEquals(expResult, result);
		
		//new test that should return false, because firstname < 2 
		_firstname ="A";
		boolean expResult1 = false;
		boolean result1 = user.setFirstname(_firstname);
		assertEquals(expResult1, result1);
						
	}

}
