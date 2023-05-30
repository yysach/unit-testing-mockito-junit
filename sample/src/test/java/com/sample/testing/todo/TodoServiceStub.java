package com.sample.testing.todo;

import java.util.Arrays;
import java.util.List;

/*
* 
* Stub is dummy implemention of TodoService.
* 
*  Problem with stubs:
*  - Dynamic condition adds lots of maintanence overhead
*  - service definitation change overhead
*  
*  in detail
*  There are a lot of maintenance problems using stubs.
*  For example, if we want to add a new method or delete an existing method to/from the ToDoService interface, we need to keep track on the stub related to this interface.
*  Another problem with stubs is the dynamic conditions that makes the code more complicated.
*  Stubs are useful in simple projects and scenarios, but in complex scenarios, we need something more dynamic than stubs. To overcome the drawbacks, mocks came into play instead of stubs.
*/
public class TodoServiceStub implements TodoService {

	@Override
	public List<String> retreiveTodos(String user) {
		return Arrays.asList("Learn spring mvc", "learn spring", "learn to dance");
	}

	@Override
	public void deleteTodos(String todo) {
		
	}

}
