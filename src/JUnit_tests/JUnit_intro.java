package JUnit_tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit_intro {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed @before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed @After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executed @before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Executed @After");
	}

	@Test
	public void test1() {
		System.out.println("Executed @test - test1");
	}
	@Test
	public void test2() {
		System.out.println("Executed @test - test2");
	}

}
