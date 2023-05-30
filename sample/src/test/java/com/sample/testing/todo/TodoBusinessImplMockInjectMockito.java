package com.sample.testing.todo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

/*
 * What is Mocking?
 * well mocking is creating object that simulates the behavior of real objects.
 * Unlike stub, mocks can be dynamically created from code.
 * mock offers lot more functionality than stubbing
 * 
 * 
 * Why to use @RunWith
 * In order to use @Mock and @InjectMock annotation to work, TestClass need to run with MockitoJunitRunner
 * MockitoJunitRunner make sure all the mocks are created and autowired as per the need.
 * 
 * Either use @RunWith annotation at top of the class 
 * OR
 * @Rule
 * public MockitoRule mockitoRule = MockitoJUnit.rule();
 * 
 * 
 * with Runner, there can be only one runner
 * but with rule, you can have multiple such rule which run after and before the test
 */

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockInjectMockito {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoServiceMock;
	// TodoService todoServiceMock = mock(TodoService.class); -- saving this line

	@InjectMocks
	TodoBusinessImpl businessImpl;
	// TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceMock);
	// --saving this line
	
	@Captor
	ArgumentCaptor<String> stringArgCaptor;

	@Test
	public void testRetreiveTodoRelatedToSpring_usingMock() {
		// given
		List<String> todos = Arrays.asList("learn spring", "learn spring mvc", "learn java");

		// when
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);

		// then
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("dummy_user");
		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void testRetreiveTodoRelatedToHibernate_usingMock() {
		// given
		List<String> todos = Arrays.asList("learn Hibernate", "todo Hibernate", "Hibernate JPA", "learn Spring");

		// when
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);

		// then
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToHibernate("dummy_user");
		assertEquals(3, filteredTodos.size());
	}
	
	
	@Test
	public void testdeleteTodosRelatedToSpring_usingMockArgumentCaptor() {
		List<String> todos = Arrays.asList("learn spring","learn spring mvc","learn java");
		
		// if we don't stub the todos list into mock object, mockito will return empty list by default
		// mockito is smart, by default it create nice mocks
		when(todoServiceMock.retreiveTodos("dummy_user")).thenReturn(todos);
		
		businessImpl.deleteTodosRelatedToSpring("dummy_user");
		
		// capture the values
		verify(todoServiceMock, times(2)).deleteTodos(stringArgCaptor.capture());
		// check captured values, assert them
		assertEquals(stringArgCaptor.getAllValues().size(), 2);
	}


}
