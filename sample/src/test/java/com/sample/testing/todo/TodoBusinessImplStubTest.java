package com.sample.testing.todo;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


public class TodoBusinessImplStubTest {
	
	@Test
	public void testRetreiveTodoRelatedToSpring_usingStub() {
		// given
		TodoService todoServiceStub = new TodoServiceStub();
		// then
		TodoBusinessImpl businessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("dummy_user");
		assertEquals(2,filteredTodos.size());
	}

}
