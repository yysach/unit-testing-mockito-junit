package com.sample.testing.todo;

import java.util.List;

/*
 * TodoService is a dependency of TodoBusinessImpl (SUT)
 * here TodoService is external service, created by some other team, or its impl is under developement
 * 
 * create todoServiceStub
 * test todoBusinessImpl using todoSerivceStub
 */
public interface TodoService {

	public List<String> retreiveTodos(String user);
	
	public void deleteTodos(String todo);
}
