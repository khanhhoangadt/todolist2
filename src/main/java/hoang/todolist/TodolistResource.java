package hoang.todolist;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;


public class TodolistResource extends ResourceSupport {
	private final Todolist todolist;
	
    public TodolistResource(Todolist todolist) {
        this.todolist = todolist;
        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(TodolistController.class).add(null)).withRel("add"));
        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(TodolistController.class).account(todolist.getUsername())).withSelfRel());
        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(TodolistController.class).update(null)).withRel("update"));
        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(TodolistController.class).delete(todolist.getUsername())).withRel("delete"));
    }

    public Todolist getTodolist() {
        return todolist;
    }
}
