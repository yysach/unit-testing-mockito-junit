package com.sample.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;


public class ListMockTest {
	
	@Test
	public void testListSize() {
		// given
		@SuppressWarnings("unchecked")
		List<Integer> list = mock(List.class);
		
		
		// when 
		when(list.size()).thenReturn(2).thenReturn(5);
		// first time it will return 2 and second onward it will return 5
		// then
		// assertEquals(2,list.size());
		// assertEquals(5,list.size());
		int size = list.size();
		verify(list, times(1)).size();
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

}
