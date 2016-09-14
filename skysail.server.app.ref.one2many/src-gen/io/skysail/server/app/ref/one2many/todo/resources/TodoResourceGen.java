package io.skysail.server.app.ref.one2many.todo.resources;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.ResourceContextId;
import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


/**
 * generated from entityResourceNonAggregate.stg
 */
public class TodoResourceGen extends EntityServerResource<io.skysail.server.app.ref.one2many.todo.Todo> {

    private String id;
    private one2manyApplicationApplication app;
    //private TodoRepository repository;

    public TodoResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        id = getAttribute("id");
        app = (one2manyApplicationApplication) getApplication();
       // repository = (TodoRepository) app.getRepository(io.skysail.server.app.ref.one2many.todo.Todo.class);
    }


    @Override
    public SkysailResponse<?> eraseEntity() {
        //repository.delete(id);
        return new SkysailResponse<>();
    }

    @Override
    public io.skysail.server.app.ref.one2many.todo.Todo getEntity() {
        return (io.skysail.server.app.ref.one2many.todo.Todo)app.getRepository().findOne(id);
    }

	@Override
    public List<Link> getLinks() {
        return super.getLinks(PutTodoResourceGen.class);
    }

}