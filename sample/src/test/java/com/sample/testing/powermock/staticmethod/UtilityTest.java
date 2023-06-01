package com.sample.testing.powermock.staticmethod;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/*
 *  this class showcase contructor mock(used when object initiated inside function locally
 *  this class also showcase how to mock static function
 *  
 *  Powermock static function required three things to do
 *  1.) Run with PowerMockRunner
 *  2.) initialize class which contains static method, using @PrepareForTest
 *  3.) last before every static method mock, PowerMockito.mockStatic(Utility.class)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class UtilityTest {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Spy
	Builder builderMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// stubbing local object in a function, like Builder builder = new Builder()
	    PowerMockito.whenNew(Builder.class).withAnyArguments().thenReturn(builderMock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String message = "HelloSachin";
		
		// this static method, change all character into uppercase and append "afterBuilder"
		String msg = Utility.staticMethod(message);
		assertEquals("HELLOSACHINafterBuilder", msg);
	}
	
	@Test
	public void testStubbingBuilderMethod() {
		String message = "HelloSachin";
		when(builderMock.addBuilder(Matchers.anyString())).thenReturn("SUCCESS");
		
		String msg = Utility.staticMethod(message);
		assertEquals("SUCCESS", msg);
	}

}
