package io.skysail.server.app.livingspec.storymap.resources;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from entityResource.stg
 */
public class StoryMapResourceGen extends EntityServerResource<io.skysail.server.app.livingspec.storymap.StoryMap> {

    private String id;
    private LivingSpecApplication app;
    private StoryMapRepository repository;

    public StoryMapResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        id = getAttribute("id");
        app = (LivingSpecApplication) getApplication();
        repository = (StoryMapRepository) app.getRepository(io.skysail.server.app.livingspec.storymap.StoryMap.class);
    }


    @Override
    public SkysailResponse<?> eraseEntity() {
        repository.delete(id);
        return new SkysailResponse<>();
    }

    @Override
    public StoryMap getEntity() {
        return (StoryMap)app.getRepository().findOne(id);
    }

	@Override
    public List<Link> getLinks() {
        return super.getLinks(PutStoryMapResourceGen.class,PostStoryMapToNewUserStoryRelationResource.class,StoryMapsUserStorysResource.class);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(StoryMapsResourceGen.class);
    }


}