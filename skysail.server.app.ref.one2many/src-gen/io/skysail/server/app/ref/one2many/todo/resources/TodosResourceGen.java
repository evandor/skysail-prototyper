package io.skysail.server.app.ref.one2many.todo.resources;

import io.skysail.server.db.DbClassName;
import io.skysail.server.queryfilter.Filter;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.api.links.Link;

import java.util.List;
import java.util.Map;

import io.skysail.server.ResourceContextId;
import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;



/**
 * generated from listResourceNonAggregate.stg
 */
public class TodosResourceGen extends ListServerResource<io.skysail.server.app.ref.one2many.todo.Todo> {

    private one2manyApplicationApplication app;

    public TodosResourceGen() {
        super(TodoResourceGen.class);
        addToContext(ResourceContextId.LINK_TITLE, "list Todos");
    }

    @Override
    protected void doInit() {
        app = (one2manyApplicationApplication) getApplication();
    }

    @Override
    public List<?> getEntity() {
       //return repository.find(new Filter(getRequest()));
        String sql = "SELECT from " + DbClassName.of(Todo.class) + " WHERE #" + getAttribute("id") + " IN in('pages')";
        return null;//((SpaceRepository)app.getRepository(Space.class)).execute(Todo.class, sql);   
    }

    public List<Link> getLinks() {
       return super.getLinks(PostTodoResourceGen.class);
    }
}