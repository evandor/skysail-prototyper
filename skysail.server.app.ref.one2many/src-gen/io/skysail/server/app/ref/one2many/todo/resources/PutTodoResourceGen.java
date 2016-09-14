package io.skysail.server.app.ref.one2many.todo.resources;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.PutEntityServerResource;

import java.util.Date;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.ref.one2many.*;
import io.skysail.server.app.ref.one2many.todo.*;

/**
 * generated from putResource.stg
 */
public class PutTodoResourceGen extends PutEntityServerResource<io.skysail.server.app.ref.one2many.todo.Todo> {


    protected String id;
    protected one2manyApplicationApplication app;

    @Override
    protected void doInit() throws ResourceException {
        id = getAttribute("id");
        app = (one2manyApplicationApplication)getApplication();
    }

    @Override
    public void updateEntity(Todo  entity) {
        io.skysail.server.app.ref.one2many.todo.Todo original = getEntity();
        copyProperties(original,entity);

        app.getRepository(io.skysail.server.app.ref.one2many.todo.Todo.class).update(original,app.getApplicationModel());
    }

    @Override
    public io.skysail.server.app.ref.one2many.todo.Todo getEntity() {
        return (io.skysail.server.app.ref.one2many.todo.Todo)app.getRepository(io.skysail.server.app.ref.one2many.todo.Todo.class).findOne(id);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(TodosResourceGen.class);
    }
}