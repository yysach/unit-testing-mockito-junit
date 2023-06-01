package com.sample.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/*
 * Movk vs Spy
 * we can override the behaviour of real object with spy
 */
public class ListMockvsSpy {
	
	@Test
	public void testListSize_usingMock() {
		List<String> arrayListMock = mock(ArrayList.class);
		assertEquals(0,arrayListMock.size());
		arrayListMock.add("Sachin");
		assertEquals(0,arrayListMock.size());
		arrayListMock.add("Yadav");
		assertEquals(0,arrayListMock.size());
		verify(arrayListMock).add("Sachin");
		verify(arrayListMock).add("Yadav");
		System.out.println(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(2);
		System.out.println(arrayListMock.size());
	}
	
	@Test
	public void testListSize_usingSpy() {
		List<String> arrayListSpy = spy(ArrayList.class);
		assertEquals(0,arrayListSpy.size());
		arrayListSpy.add("Sachin");
		assertEquals(1,arrayListSpy.size());
		arrayListSpy.add("Yadav");
		assertEquals(2,arrayListSpy.size());
	}
	
	@Test
	public void testListSize_usingStubbingWithSpy() {
		// we can override the behaviour of real object with spy
		List<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Sachin");
		verify(arrayListSpy).add("Sachin");
		verify(arrayListSpy,never()).remove("Sachin");
	
	}
	

}
