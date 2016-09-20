package io.skysail.server.app.storymapper.story.resources;

import io.skysail.server.db.DbClassName;
import io.skysail.server.queryfilter.Filter;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.api.links.Link;

import java.util.List;
import java.util.Map;

import io.skysail.server.ResourceContextId;
import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;



/**
 * generated from listResourceNonAggregate.stg
 */
public class StorysResourceGen extends ListServerResource<io.skysail.server.app.storymapper.story.Story> {

    private StoryMapperApplication app;

    public StorysResourceGen() {
        super(StoryResourceGen.class);
        addToContext(ResourceContextId.LINK_TITLE, "list Storys");
    }

    @Override
    protected void doInit() {
        app = (StoryMapperApplication) getApplication();
    }

    @Override
    public List<?> getEntity() {
       //return repository.find(new Filter(getRequest()));
        String sql = "SELECT from " + DbClassName.of(Story.class) + " WHERE #" + getAttribute("id") + " IN in('pages')";
        return null;//((SpaceRepository)app.getRepository(Space.class)).execute(Story.class, sql);   
    }

    public List<Link> getLinks() {
       return super.getLinks(PostStoryResourceGen.class);
    }
}