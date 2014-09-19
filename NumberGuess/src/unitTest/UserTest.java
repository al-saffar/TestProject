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

	private static User user;
	/**
	   @BeforeClass executes before the start of tests. 
		This can be used to perform time intensive activities, 
		e.g., connect to a database. @AfterClass executes after all tests have finished. 
		This can be used to perform clean-up activities, e.g., disconnect from a database. 
		Those two only run one time no matter how many test the class has. 
		Also you have to declare “@BeforeClass” and “@AfterClass” method as static method.
		The two annotations should be used do some static initialization code and destroy static variables.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user = new User();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	  @Before and @After Will execute the method before/after each test. This
	   method can prepare/clean up the test environment (e.g. read input
	   data, initialize the class, delete temporary data, etc). As a
	   class can have multiple test methods,
	   @Before and @After methods will be executed before and after each test.
	   This is different with @BeforeClass and @AfterClass.
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUser");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	

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

		
		// new test that should return true, because firstname => 2
		String _firstname = "Anders";
		
		boolean expResult = true;
		boolean result = user.setFirstname(_firstname);
		assertEquals(expResult, result);

		// new test that should return false, because firstname < 2
		_firstname = "A";
		boolean expResult1 = false;
		boolean result1 = user.setFirstname(_firstname);
		assertEquals(expResult1, result1);

	}

}
