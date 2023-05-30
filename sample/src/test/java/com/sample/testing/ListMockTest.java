package com.sample.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;


public class ListMockTest {
	
	@Test
	public void testListSize() {
		// given
		@SuppressWarnings("unchecked")
		List<Integer> list = mock(List.class);
		
		
		// when 
		when(list.size()).thenReturn(2).thenReturn(5);
		// first time it will return 2 and second onward it will return 5

		assertEquals(2,list.size());
		assertEquals(5,list.size());
		int size = list.size();
		verify(list, times(3)).size();
		verify(list, never()).get(0);
		
		
	}
	
	@Test
	public void testListGet() {
		// given
		@SuppressWarnings("unchecked")
		List<Integer> list = mock(List.class);
		// when
		when((list.get(0))).thenReturn(100);
		
		// then
		assertEquals(new Integer(100),list.get(0));
		assertEquals(null,list.get(1)); // an example of good mocking, will return 100 only when get is 0
		// to match with BDD syntax we can use then, instead of verify
		
	}
	
	@Test
	public void testListGetWithArgumentMatcher() {
		// given
		@SuppressWarnings("unchecked")
		List<Integer> list = mock(List.class);
		// when
		when((list.get(Matchers.anyInt()))).thenReturn(100);
		
		// then
		// will return 100, for any index, power of arguement matchers
		assertEquals(new Integer(100),list.get(0));
		assertEquals(new Integer(100),list.get(1)); 
	}
	
	@Test(expected = RuntimeException.class)
	public void testListGetWithThrowRuntimeException() {
		// given
		@SuppressWarnings("unchecked")
		List<Integer> list = mock(List.class);
		// when
		when((list.get(Matchers.anyInt()))).thenThrow(new RuntimeException("something went wrong"));
		
		// then
		assertEquals(new Integer(100),list.get(0));
	}

}
