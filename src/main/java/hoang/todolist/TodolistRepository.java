package hoang.todolist;

import org.springframework.data.repository.CrudRepository;

public interface TodolistRepository extends CrudRepository<Todolist, Long> {
	
	Todolist findByUsername(String username);

}
