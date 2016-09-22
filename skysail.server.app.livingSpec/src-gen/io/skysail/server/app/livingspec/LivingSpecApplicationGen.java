package io.skysail.server.app.livingspec;

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

import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from application.stg
 */
public class LivingSpecApplicationGen extends SkysailApplication implements ApplicationProvider, MenuItemProvider {

    public static final String LIST_ID = "lid";
    public static final String TODO_ID = "id";
    public static final String APP_NAME = "LivingSpec";

    //@Reference(cardinality = ReferenceCardinality.OPTIONAL)
    //private volatile EventAdmin eventAdmin;

    public LivingSpecApplicationGen(String name, ApiVersion apiVersion, List<Class<? extends Identifiable>>  entityClasses) {
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
        router.attach(new RouteBuilder("/StoryMaps/{id}", StoryMapResourceGen.class));
        router.attach(new RouteBuilder("/StoryMaps/", PostStoryMapResourceGen.class));
        router.attach(new RouteBuilder("/StoryMaps/{id}/", PutStoryMapResourceGen.class));
        router.attach(new RouteBuilder("/StoryMaps", StoryMapsResourceGen.class));
        router.attach(new RouteBuilder("", io.skysail.server.app.livingspec.storymap.resources.StoryMapsResourceGen.class));
        router.attach(new RouteBuilder("/StoryMaps/{id}/UserStorys", StoryMapsUserStorysResource.class));
        router.attach(new RouteBuilder("/StoryMaps/{id}/UserStorys/", PostStoryMapToNewUserStoryRelationResource.class));
        router.attach(new RouteBuilder("/StoryMaps/{id}/UserStorys/{targetId}", StoryMapsUserStoryResource.class));
        router.attach(new RouteBuilder("/UserStorys/{id}", UserStoryResourceGen.class));
        router.attach(new RouteBuilder("/UserStorys/", PostUserStoryResourceGen.class));
        router.attach(new RouteBuilder("/UserStorys/{id}/", PutUserStoryResourceGen.class));
        router.attach(new RouteBuilder("/UserStorys", UserStorysResourceGen.class));

    }

    /*public EventAdmin getEventAdmin() {
        return eventAdmin;
    }*/

}