package com.sample.testing.todo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


/*
 * What is Mocking?
 * well mocking is creating object that simulates the behaviour of real objects.
 * Unlike stub, mocks can be dynamically created from code.
 * mock offers lot more functionality than stubbing
 */
public class TodoBusinessImplMockTest {
	
	@Test
	public void testRetreiveTodoRelatedToSpring_usingMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		
		// given
		List<String> todos = Arrays.asList("learn spring","learn spring mvc","learn java");
		
		// when
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);
		
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// then
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("dummy_user");
		assertEquals(2,filteredTodos.size());
		
	}
	
	@Test
	public void testRetreiveTodoRelatedToHibernate_usingMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		
		// given
		List<String> todos = Arrays.asList("learn Hibernate","todo Hibernate","Hibernate JPA","learn Spring");
		
		// when
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);
		
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// then
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToHibernate("dummy_user");
		assertEquals(3,filteredTodos.size());
	}

}
