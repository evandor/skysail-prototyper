package io.skysail.server.app.ref.one2many.todolist;
import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.EntityServerResource;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


/**
 * generated from targetRelationResource.stg
 */
public class TodoListsTodoResource extends EntityServerResource<Todo> {

    @Override
    public SkysailResponse<?> eraseEntity() {
        return null;
    }

    @Override
    public Todo getEntity() {
        return null;
    }

   /* @Override
    public List<Link> getLinks() {
        return super.getLinks(TodoListsTodosResource.class, PostTodoListsTodoRelationResource.class);
    }*/

}