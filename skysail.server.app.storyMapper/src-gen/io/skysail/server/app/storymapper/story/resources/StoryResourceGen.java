package io.skysail.server.app.storymapper.story.resources;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.ResourceContextId;
import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


/**
 * generated from entityResourceNonAggregate.stg
 */
public class StoryResourceGen extends EntityServerResource<io.skysail.server.app.storymapper.story.Story> {

    private String id;
    private StoryMapperApplication app;
    //private StoryRepository repository;

    public StoryResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        id = getAttribute("id");
        app = (StoryMapperApplication) getApplication();
       // repository = (StoryRepository) app.getRepository(io.skysail.server.app.storymapper.story.Story.class);
    }


    @Override
    public SkysailResponse<?> eraseEntity() {
        //repository.delete(id);
        return new SkysailResponse<>();
    }

    @Override
    public io.skysail.server.app.storymapper.story.Story getEntity() {
        return (io.skysail.server.app.storymapper.story.Story)app.getRepository().findOne(id);
    }

	@Override
    public List<Link> getLinks() {
        return super.getLinks(PutStoryResourceGen.class);
    }

}