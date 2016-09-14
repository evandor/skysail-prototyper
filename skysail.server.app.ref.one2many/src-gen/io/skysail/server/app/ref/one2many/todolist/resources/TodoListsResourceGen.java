package io.skysail.server.app.ref.one2many.todolist.resources;

import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.api.links.Link;

import java.util.*;

import io.skysail.server.ResourceContextId;
import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


/**
 * generated from listResource.stg
 */
public class TodoListsResourceGen extends ListServerResource<io.skysail.server.app.ref.one2many.todolist.TodoList> {

    private one2manyApplicationApplication app;
    private TodoListRepository repository;

    public TodoListsResourceGen() {
        super(TodoListResourceGen.class);
        addToContext(ResourceContextId.LINK_TITLE, "list TodoLists");
    }

    public TodoListsResourceGen(Class<? extends TodoListResourceGen> cls) {
        super(cls);
    }

    @Override
    protected void doInit() {
        app = (one2manyApplicationApplication) getApplication();
        repository = (TodoListRepository) app.getRepository(io.skysail.server.app.ref.one2many.todolist.TodoList.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<io.skysail.server.app.ref.one2many.todolist.TodoList> getEntity() {
        Filter filter = new Filter(getRequest());
        Pagination pagination = new Pagination(getRequest(), getResponse(), repository.count(filter));
        return repository.find(filter, pagination);
    }

    @Override
    public List<Link> getLinks() {
              return super.getLinks(PostTodoListResourceGen.class,TodoListsResourceGen.class);
    }
}