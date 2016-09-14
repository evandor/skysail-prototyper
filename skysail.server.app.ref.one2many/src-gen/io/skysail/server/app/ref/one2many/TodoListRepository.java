package io.skysail.server.app.ref.one2many;


import org.osgi.service.component.annotations.*;

import io.skysail.domain.core.repos.DbRepository;
import io.skysail.server.db.*;

/**
 * generated from repository.stg
 */
@Component(immediate = true, property = "name=TodoListsRepository")
public class TodoListRepository extends GraphDbRepository<io.skysail.server.app.ref.one2many.todolist.TodoList> implements DbRepository {

    @Reference
    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

    public void unsetDbService(DbService dbService) {
        this.dbService = null;
    }

    @Activate
    public void activate() {
        //log.debug("activating io.skysail.server.app.ref.one2many.todolist.TodoList" Repository);
        //dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.ref.one2many.todolist.TodoList.class));
        //dbService.register(io.skysail.server.app.ref.one2many.todolist.TodoList.class);
        dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.ref.one2many.todolist.TodoList.class));

        dbService.register(io.skysail.server.app.ref.one2many.todolist.TodoList.class);
            
        dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.ref.one2many.todo.Todo.class));

        dbService.register(io.skysail.server.app.ref.one2many.todo.Todo.class);
            
    }

   /*
   	DesignerApplicationModel: one2manyApplication, projectName=skysail.server.app.ref.one2many, path=../
   	Entities: 
   	 * DesignerEntityModel: id='io.skysail.server.app.ref.one2many.todolist.TodoList', isAggregate=true
   	   Fields:
   	    - DesignerFieldModel(name=listname, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)
   	    - DesignerFieldModel(name=description, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)
   	   Relations:
   	    - EntityRelation(name=todos, targetEntityModel=Todo, type=ONE_TO_MANY)

   	 * DesignerEntityModel: id='io.skysail.server.app.ref.one2many.todo.Todo', isAggregate=false
   	   Fields:
   	    - DesignerFieldModel(name=todoname, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)

   	Repositories: 
   	Repositories(repositories={})


   	---

   	io.skysail.server.app.ref.one2many.todolist.TodoListio.skysail.server.app.ref.one2many.todo.Todo

   */
}