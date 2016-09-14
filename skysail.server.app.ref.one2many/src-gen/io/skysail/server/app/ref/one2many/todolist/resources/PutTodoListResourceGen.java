package io.skysail.server.app.ref.one2many.todolist.resources;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.PutEntityServerResource;

import java.util.Date;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.ref.one2many.*;
import io.skysail.server.app.ref.one2many.todolist.*;

/**
 * generated from putResource.stg
 */
public class PutTodoListResourceGen extends PutEntityServerResource<io.skysail.server.app.ref.one2many.todolist.TodoList> {


    protected String id;
    protected one2manyApplicationApplication app;

    @Override
    protected void doInit() throws ResourceException {
        id = getAttribute("id");
        app = (one2manyApplicationApplication)getApplication();
    }

    @Override
    public void updateEntity(TodoList  entity) {
        io.skysail.server.app.ref.one2many.todolist.TodoList original = getEntity();
        copyProperties(original,entity);

        app.getRepository(io.skysail.server.app.ref.one2many.todolist.TodoList.class).update(original,app.getApplicationModel());
    }

    @Override
    public io.skysail.server.app.ref.one2many.todolist.TodoList getEntity() {
        return (io.skysail.server.app.ref.one2many.todolist.TodoList)app.getRepository(io.skysail.server.app.ref.one2many.todolist.TodoList.class).findOne(id);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(TodoListsResourceGen.class);
    }
}