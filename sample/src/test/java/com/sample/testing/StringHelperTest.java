package com.sample.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperTest {

	private String input;
	private String expectedOutput;

	public StringHelperTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<String[]> testConditions() {
		String expectedOutputs[][] = { { "AABB", "BB" }, { "ABB", "BB" }, { "BB", "BB" }, { "RTAA", "RTAA" } };
		return Arrays.asList(expectedOutputs);
	}

	StringHelper helper = new StringHelper();

	@Before
	public void before() {
		System.out.println("Before Test ...");
	}

	@After
	public void after() {
		System.out.println("After Tets ...");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class ... function should be static");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After class ... function should be static");
	}

	@Test
	public void testSimple() {
		assertEquals(expectedOutput, helper.truncateAFromFirstTwoPosition(input));
	}

	@Test
	public void testStringTruncate() {
		assertFalse(helper.checkFirstAndLastTwoCharactersAreSame("AABB"));
		assertFalse(helper.checkFirstAndLastTwoCharactersAreSame("ABB"));
		assertTrue(helper.checkFirstAndLastTwoCharactersAreSame("BB"));
		assertFalse(helper.checkFirstAndLastTwoCharactersAreSame("RTAA"));
	}

}
