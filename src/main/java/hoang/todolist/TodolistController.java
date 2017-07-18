package hoang.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodolistController {
	
    @Autowired
    private TodolistRepository todolistRepository;
    
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public TodolistResource add(@RequestBody Todolist todolist){

        if(todolistRepository.findByUsername(todolist.getUsername()) != null){
            throw new IllegalArgumentException("add name");
        }

        todolist.setId(0);
        todolistRepository.save(todolist);

        return new TodolistResource(todolist);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public TodolistResource account(@PathVariable String username) {

        Todolist todolist = todolistRepository.findByUsername(username);
        if(todolist == null){
            throw new IllegalArgumentException("add name");
        }

        return new TodolistResource(todolist);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public TodolistResource update(@RequestBody Todolist todolist) {

        Todolist me = todolistRepository.findByUsername(todolist.getUsername());
        if(me == null){
            throw new IllegalArgumentException("update name");
        }

        me.setFirstDate(todolist.getFirstDate());
        me.setLastDate(todolist.getLastDate());

        me = todolistRepository.save(me);

        return new TodolistResource(me);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{username}")
    public TodolistResource delete(@PathVariable String username) {

        Todolist todolist = todolistRepository.findByUsername(username);
        if(todolist == null){
            throw new IllegalArgumentException("delete name");
        }

        todolistRepository.delete(todolist);

        return new TodolistResource(todolist);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Resources<TodolistResource> list() {
        Iterable<Todolist> todolists = todolistRepository.findAll();
        List<TodolistResource> todolistList = new ArrayList<>();
        todolists.forEach(todolist -> {
            todolistList.add(new TodolistResource(todolist));
        });
        return new Resources<>(todolistList);
    }
}
