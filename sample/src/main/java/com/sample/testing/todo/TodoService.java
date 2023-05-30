package com.sample.testing.todo;

import java.util.List;

/*
 * create todoServiceStub
 * test todoBusinessImpl using todoSerivceStub
 */
public interface TodoService {

	public List<String> retreiveTodos(String user);
}
