package io.skysail.server.app.ref.one2many.todo.resources;

import java.util.Date;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.domain.core.repos.Repository;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;



/**
 * generated from postResourceNonAggregate.stg
 */
public class PostTodoResourceGen extends PostEntityServerResource<io.skysail.server.app.ref.one2many.todo.Todo> {

	private one2manyApplicationApplication app;
    private Repository repository;

    public PostTodoResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new ");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (one2manyApplicationApplication) getApplication();
        repository = null;//app.getRepository(Space.class);
    }

    @Override
    public io.skysail.server.app.ref.one2many.todo.Todo createEntityTemplate() {
        return new Todo();
    }

    @Override
    public void addEntity(io.skysail.server.app.ref.one2many.todo.Todo entity) {
        Subject subject = SecurityUtils.getSubject();

        io.skysail.server.app.ref.one2many.todolist.TodoList entityRoot = (io.skysail.server.app.ref.one2many.todolist.TodoList) repository.findOne(getAttribute("id"));
        entityRoot.getTodos().add(entity);
        repository.update(entityRoot, app.getApplicationModel());
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(TodosResourceGen.class);
    }
}