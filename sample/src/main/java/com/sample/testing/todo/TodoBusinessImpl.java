package com.sample.testing.todo;

import java.util.ArrayList;
import java.util.List;

/*
 *  TodoBusinessImpl is SUT system under test
 *  Problem here we are discussing, how will we test this SUT without TodoServiceImpl (under development by some other team)
 *  and TodoService is its dependency
 *  
 *  Two solution :
 *  1.) stub
 *  2.) mock using mockito
 *  
 *  
 *  Stub is nothing but a sample implementation or a dummy implementation for this todoService dependency
 *  A stub is only used for unit testing
 *  
 *  Problem with stubs:
 *  - Dynamic condition adds lots of maintanence overhead
 *  - service definitation change overhead
 *  
 *  in detailL
 *  There are a lot of maintenance problems using stubs.
 *  For example, if we want to add a new method or delete an existing method to/from the ToDoService interface, we need to keep track on the stub related to this interface. Another problem with stubs is the dynamic conditions that makes the code more complicated.
 *	Stubs are useful in simple projects and scenarios, but in complex scenarios, we need something more dynamic than stubs. To overcome the drawbacks, mocks came into play instead of stubs.
 */
public class TodoBusinessImpl {

	private TodoService service;

	public TodoBusinessImpl(TodoService service) {
		super();
		this.service = service;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<>();
		List<String> todos = this.service.retreiveTodos(user);

		for (String todo : todos) {
			if (todo.contains("spring")) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}

	public List<String> retrieveTodosRelatedToHibernate(String user) {
		List<String> filteredTodos = new ArrayList<>();
		List<String> todos = this.service.retreiveTodos(user);

		for (String todo : todos) {
			if (todo.contains("Hibernate")) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}
	
	public void deleteTodosRelatedToSpring(String user) {
		List<String> todos = this.service.retreiveTodos(user);
		for(String todo : todos) {
			if(todo.contains("spring")) {
				this.service.deleteTodos(todo);
			}
		}
	}

}
