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


public class GameTest extends TestCase {
	private int counter;
	private int level;
	private int algorithm;
	private int scoreAlgorithm;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("gameTest start");
	}

	

	@Before
	public void setUp() throws Exception {
		counter = 5;
		level = 50;
		algorithm = (1000 * (level / 10)) / counter;
		scoreAlgorithm = (level * 10) - (100 * counter / 10);
	}

	

	@Test
	public void testGame() {

		int score = algorithm;

		score += scoreAlgorithm;
		int expResult = 1450;
		int result = score;
		assertEquals(expResult, result);

	}
	
	@After
	public void tearDown() throws Exception {
		algorithm = 0;
		scoreAlgorithm = 0;
		counter = 0;
		level = 0;
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("gameTest end");
	}

}
