package com.sample.testing.todo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito.Then;
import org.mockito.Matchers;


/*
 * What is Mocking?
 * well mocking is creating object that simulates the behaviour of real objects.
 * Unlike stub, mocks can be dynamically created from code. at the runtime
 * mock offers lot more functionality than stubbing.
 * You can verify method call and lots of other things.
 * 
 * verify method call and arguement capture are mostly used when method under test do not return anything
 * a void function
 */
public class TodoBusinessImplMockTest {
	
	@Test
	public void testRetreiveTodoRelatedToSpring_usingMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		// given
		List<String> todos = Arrays.asList("learn spring","learn spring mvc","learn java");
		
		// if we don't stub the todos list into mock object, mockito will return empty list by default
		// mockito is smart, by default it create nice mocks
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);
		
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// when
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("dummy_user");
		
		// then
		assertEquals(2,filteredTodos.size());
		
	}
	
	@Test
	public void testRetreiveTodoRelatedToHibernate_usingMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		
		// given
		List<String> todos = Arrays.asList("learn Hibernate","todo Hibernate","Hibernate JPA","learn Spring");
		
		// if we don't stub the todos list into mock object, mockito will return empty list by default
		// mockito is smart, by default it create nice mocks
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);
		
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// when
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToHibernate("dummy_user");
		
		// then
		assertEquals(3,filteredTodos.size());
	}
	
	
	@Test
	public void testdeleteTodosRelatedToSpring_usingMockVerify() {
		// given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("learn spring","learn spring mvc","learn java");
		
		// if we don't stub the todos list into mock object, mockito will return empty list by default
		// mockito is smart, by default it create nice mocks
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// when
		businessImpl.deleteTodosRelatedToSpring("dummy_user");
		
		// then
		// verify call TodoService.deleteTodos
		verify(todoServiceMock).deleteTodos("learn spring");
		verify(todoServiceMock, atLeastOnce()).deleteTodos("learn spring mvc");
		verify(todoServiceMock, never()).deleteTodos("learn java");
		verify(todoServiceMock, times(2)).deleteTodos(Matchers.anyString());
	}
	
	
	@Test
	public void testdeleteTodosRelatedToSpring_usingMockArgumentCaptor() {
		// declare argument captor
		ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class); 
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("learn spring","learn spring mvc","learn java");
		
		// if we don't stub the todos list into mock object, mockito will return empty list by default
		// mockito is smart, by default it create nice mocks
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);
		
		businessImpl.deleteTodosRelatedToSpring("dummy_user");
		
		
		// capture the values
		verify(todoServiceMock, times(2)).deleteTodos(stringArgCaptor.capture());
		// check captured values, assert them
		assertEquals(stringArgCaptor.getAllValues().size(), 2);
	}

}
