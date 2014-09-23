package unitTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DatabaseTest.class, GameTest.class, SQLTest.class, UserTest.class })
public class AllTests extends TestCase {
	
	public static Test suite() {   
		  TestSuite suite = new TestSuite("Test for test");     
		   suite.addTestSuite(DatabaseTest.class);
		   suite.addTestSuite(GameTest.class);
		   suite.addTestSuite(SQLTest.class);
		   suite.addTestSuite(UserTest.class);
		  return suite;   
		 }
	}
