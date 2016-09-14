package io.skysail.server.app.ref.one2many.todolist;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.server.ResourceContextId;
import io.skysail.server.db.DbClassName;
import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


/**
 * generated from relationResource.stg
 */
public class TodoListsTodosResource extends ListServerResource<Todo> {

    private one2manyApplicationApplicationGen app;
    private TodoListRepository oeRepo;

    public TodoListsTodosResource() {
        super(TodoListsTodoResource.class);//, TodoListsTodoListResource.class);
        addToContext(ResourceContextId.LINK_TITLE, "["+this.getClass().getSimpleName()+"]");
    }

    @Override
    protected void doInit() {
        app = (one2manyApplicationApplication) getApplication();
        oeRepo = (TodoListRepository) app.getRepository(TodoList.class);
    }

    @Override
    public List<Todo> getEntity() {
        return (List<Todo>) oeRepo.execute(Todo.class, "select * from " + DbClassName.of(Todo.class) + " where #"+getAttribute("id")+" in IN(folders)");
    }

    @Override
    public List<Link> getLinks() {
        return super.getLinks(TodoListsTodosResource.class, PostTodoListToNewTodoRelationResource.class);
    }
}