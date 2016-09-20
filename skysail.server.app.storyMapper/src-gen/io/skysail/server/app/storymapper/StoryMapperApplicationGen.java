package io.skysail.server.app.storymapper;

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

import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


/**
 * generated from application.stg
 */
public class StoryMapperApplicationGen extends SkysailApplication implements ApplicationProvider, MenuItemProvider {

    public static final String LIST_ID = "lid";
    public static final String TODO_ID = "id";
    public static final String APP_NAME = "StoryMapper";

    //@Reference(cardinality = ReferenceCardinality.OPTIONAL)
    //private volatile EventAdmin eventAdmin;

    public StoryMapperApplicationGen(String name, ApiVersion apiVersion, List<Class<? extends Identifiable>>  entityClasses) {
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
        router.attach(new RouteBuilder("/Maps/{id}", MapResourceGen.class));
        router.attach(new RouteBuilder("/Maps/", PostMapResourceGen.class));
        router.attach(new RouteBuilder("/Maps/{id}/", PutMapResourceGen.class));
        router.attach(new RouteBuilder("/Maps", MapsResourceGen.class));
        router.attach(new RouteBuilder("", io.skysail.server.app.storymapper.map.resources.MapsResourceGen.class));
        router.attach(new RouteBuilder("/Maps/{id}/Storys", MapsStorysResource.class));
        router.attach(new RouteBuilder("/Maps/{id}/Storys/", PostMapToNewStoryRelationResource.class));
        router.attach(new RouteBuilder("/Maps/{id}/Storys/{targetId}", MapsStoryResource.class));
        router.attach(new RouteBuilder("/Storys/{id}", StoryResourceGen.class));
        router.attach(new RouteBuilder("/Storys/", PostStoryResourceGen.class));
        router.attach(new RouteBuilder("/Storys/{id}/", PutStoryResourceGen.class));
        router.attach(new RouteBuilder("/Storys", StorysResourceGen.class));

    }

    /*public EventAdmin getEventAdmin() {
        return eventAdmin;
    }*/

}