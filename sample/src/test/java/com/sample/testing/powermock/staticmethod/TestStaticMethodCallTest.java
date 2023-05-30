package com.sample.testing.powermock.staticmethod;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utility.class})
public class TestStaticMethodCallTest {
	@Mock
	private boolean status;
	
	@InjectMocks
	private TestStaticMethodCall methodCall;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(Utility.class);
		when(Utility.staticMethod(anyString())).thenReturn("StubbedMessage");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStaticMethodCall() {
		System.out.println(methodCall.getStaticMethodCall("This is input message"));
		System.out.println("___________________________");
		System.out.println(methodCall.getStaticMethodCall("This is input message"));
	
	}

}
