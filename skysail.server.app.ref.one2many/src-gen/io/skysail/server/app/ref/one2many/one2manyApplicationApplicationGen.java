package io.skysail.server.app.ref.one2many;

import java.util.List;

import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.event.EventAdmin;

import io.skysail.domain.Identifiable;
import io.skysail.domain.core.Repositories;
import io.skysail.server.app.ApiVersion;
import io.skysail.server.app.ApplicationProvider;
import io.skysail.server.app.SkysailApplication;
import io.skysail.server.menus.MenuItemProvider;
import io.skysail.server.restlet.RouteBuilder;
import io.skysail.server.security.config.SecurityConfigBuilder;

import io.skysail.server.app.ref.one2many.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


/**
 * generated from application.stg
 */
public class one2manyApplicationApplicationGen extends SkysailApplication implements ApplicationProvider, MenuItemProvider {

    public static final String LIST_ID = "lid";
    public static final String TODO_ID = "id";
    public static final String APP_NAME = "one2manyApplication";

    //@Reference(cardinality = ReferenceCardinality.OPTIONAL)
    //private volatile EventAdmin eventAdmin;

    public one2manyApplicationApplicationGen(String name, ApiVersion apiVersion, List<Class<? extends Identifiable>>  entityClasses) {
        super(name, apiVersion, entityClasses);
    }

    @Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.MANDATORY)
    public void setRepositories(Repositories repos) {
        super.setRepositories(repos);
    }

    public void unsetRepositories(Repositories repo) {
        super.setRepositories(null);
    }



    @Override
    protected void defineSecurityConfig(SecurityConfigBuilder securityConfigBuilder) {
    	securityConfigBuilder
    		.authorizeRequests()
    			.startsWithMatcher("").authenticated();
    		;
    }

    @Override
    protected void attach() {
        super.attach();
        router.attach(new RouteBuilder("/TodoLists/{id}", TodoListResourceGen.class));
        router.attach(new RouteBuilder("/TodoLists/", PostTodoListResourceGen.class));
        router.attach(new RouteBuilder("/TodoLists/{id}/", PutTodoListResourceGen.class));
        router.attach(new RouteBuilder("/TodoLists", TodoListsResourceGen.class));
        router.attach(new RouteBuilder("", io.skysail.server.app.ref.one2many.todolist.resources.TodoListsResourceGen.class));
        router.attach(new RouteBuilder("/TodoLists/{id}/Todos", TodoListsTodosResource.class));
        router.attach(new RouteBuilder("/TodoLists/{id}/Todos/", PostTodoListToNewTodoRelationResource.class));
        router.attach(new RouteBuilder("/TodoLists/{id}/Todos/{targetId}", TodoListsTodoResource.class));
        router.attach(new RouteBuilder("/Todos/{id}", TodoResourceGen.class));
        router.attach(new RouteBuilder("/Todos/", PostTodoResourceGen.class));
        router.attach(new RouteBuilder("/Todos/{id}/", PutTodoResourceGen.class));
        router.attach(new RouteBuilder("/Todos", TodosResourceGen.class));

    }

    /*public EventAdmin getEventAdmin() {
        return eventAdmin;
    }*/

}