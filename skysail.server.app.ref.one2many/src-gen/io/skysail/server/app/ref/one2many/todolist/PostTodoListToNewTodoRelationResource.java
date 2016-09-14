package io.skysail.server.app.ref.one2many.todolist;

import java.util.List;

import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.api.links.Link;
import io.skysail.server.restlet.resources.PostRelationResource2;
import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


/**
 * generated from postRelationToNewEntityResource.stg
 */
public class PostTodoListToNewTodoRelationResource extends PostRelationResource2<Todo> {

    private one2manyApplicationApplicationGen app;
    private TodoListRepository repo;
    private String parentId;

    public PostTodoListToNewTodoRelationResource() {
        // addToContext(ResourceContextId.LINK_TITLE, "add");
    }

    @Override
    protected void doInit() {
        app = (one2manyApplicationApplication) getApplication();
        repo = (TodoListRepository) app.getRepository(io.skysail.server.app.ref.one2many.todolist.TodoList.class);
        parentId = getAttribute("id");
    }

    public Todo createEntityTemplate() {
        return new Todo();
    }

    @Override
    public void addEntity(Todo entity) {
        TodoList parent = repo.findOne(parentId);
        parent.getTodos().add(entity);
        repo.save(parent, getApplication().getApplicationModel());
    }

    @Override
    public List<Link> getLinks() {
        return super.getLinks(TodoListsTodosResource.class, PostTodoListToNewTodoRelationResource.class);
    }
}