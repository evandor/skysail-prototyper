package io.skysail.server.app.ref.one2many.todolist.resources;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


/**
 * generated from entityResource.stg
 */
public class TodoListResourceGen extends EntityServerResource<io.skysail.server.app.ref.one2many.todolist.TodoList> {

    private String id;
    private one2manyApplicationApplication app;
    private TodoListRepository repository;

    public TodoListResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        id = getAttribute("id");
        app = (one2manyApplicationApplication) getApplication();
        repository = (TodoListRepository) app.getRepository(io.skysail.server.app.ref.one2many.todolist.TodoList.class);
    }


    @Override
    public SkysailResponse<?> eraseEntity() {
        repository.delete(id);
        return new SkysailResponse<>();
    }

    @Override
    public TodoList getEntity() {
        return (TodoList)app.getRepository().findOne(id);
    }

	@Override
    public List<Link> getLinks() {
        return super.getLinks(PutTodoListResourceGen.class,PostTodoListToNewTodoRelationResource.class,TodoListsTodosResource.class);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(TodoListsResourceGen.class);
    }


}