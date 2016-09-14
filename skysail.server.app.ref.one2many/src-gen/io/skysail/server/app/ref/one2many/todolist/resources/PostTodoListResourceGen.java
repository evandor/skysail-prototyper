package io.skysail.server.app.ref.one2many.todolist.resources;

import java.util.Date;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.ref.one2many.*;
import io.skysail.server.app.ref.one2many.todolist.*;

/**
 * generated from postResource.stg
 */
public class PostTodoListResourceGen extends PostEntityServerResource<io.skysail.server.app.ref.one2many.todolist.TodoList> {

	protected one2manyApplicationApplication app;

    public PostTodoListResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new ");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (one2manyApplicationApplication) getApplication();
    }

    @Override
    public io.skysail.server.app.ref.one2many.todolist.TodoList createEntityTemplate() {
        return new TodoList();
    }

    @Override
    public void addEntity(io.skysail.server.app.ref.one2many.todolist.TodoList entity) {
        Subject subject = SecurityUtils.getSubject();
        String id = app.getRepository(io.skysail.server.app.ref.one2many.todolist.TodoList.class).save(entity, app.getApplicationModel()).toString();
        entity.setId(id);

    }

    @Override
    public String redirectTo() {
        return super.redirectTo(TodoListsResourceGen.class);
    }
}