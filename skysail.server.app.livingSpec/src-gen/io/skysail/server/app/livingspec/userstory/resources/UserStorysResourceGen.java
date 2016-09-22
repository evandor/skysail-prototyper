package io.skysail.server.app.livingspec.userstory.resources;

import io.skysail.server.db.DbClassName;
import io.skysail.server.queryfilter.Filter;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.api.links.Link;

import java.util.List;
import java.util.Map;

import io.skysail.server.ResourceContextId;
import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;



/**
 * generated from listResourceNonAggregate.stg
 */
public class UserStorysResourceGen extends ListServerResource<io.skysail.server.app.livingspec.userstory.UserStory> {

    private LivingSpecApplication app;

    public UserStorysResourceGen() {
        super(UserStoryResourceGen.class);
        addToContext(ResourceContextId.LINK_TITLE, "list UserStorys");
    }

    @Override
    protected void doInit() {
        app = (LivingSpecApplication) getApplication();
    }

    @Override
    public List<?> getEntity() {
       //return repository.find(new Filter(getRequest()));
        String sql = "SELECT from " + DbClassName.of(UserStory.class) + " WHERE #" + getAttribute("id") + " IN in('pages')";
        return null;//((SpaceRepository)app.getRepository(Space.class)).execute(UserStory.class, sql);   
    }

    public List<Link> getLinks() {
       return super.getLinks(PostUserStoryResourceGen.class);
    }
}