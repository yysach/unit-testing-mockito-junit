package com.sample.testing.powermock.staticmethod;

import static org.hamcrest.MatcherAssert.assertThat;
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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class UtilityTest {
	@Mock
	Builder builderMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	    PowerMockito.whenNew(Builder.class).withAnyArguments().thenReturn(builderMock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String message = "HelloSachin";
		when(builderMock.addBuilder(anyString())).thenReturn("Success");
		
		String msg = Utility.staticMethod(message);
		System.out.println(msg);
		assertEquals(msg,"Success");
	}

}
