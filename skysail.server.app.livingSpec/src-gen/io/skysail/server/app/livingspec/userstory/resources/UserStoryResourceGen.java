package io.skysail.server.app.livingspec.userstory.resources;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.ResourceContextId;
import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from entityResourceNonAggregate.stg
 */
public class UserStoryResourceGen extends EntityServerResource<io.skysail.server.app.livingspec.userstory.UserStory> {

    private String id;
    private LivingSpecApplication app;
    //private UserStoryRepository repository;

    public UserStoryResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        id = getAttribute("id");
        app = (LivingSpecApplication) getApplication();
       // repository = (UserStoryRepository) app.getRepository(io.skysail.server.app.livingspec.userstory.UserStory.class);
    }


    @Override
    public SkysailResponse<?> eraseEntity() {
        //repository.delete(id);
        return new SkysailResponse<>();
    }

    @Override
    public io.skysail.server.app.livingspec.userstory.UserStory getEntity() {
        return (io.skysail.server.app.livingspec.userstory.UserStory)app.getRepository().findOne(id);
    }

	@Override
    public List<Link> getLinks() {
        return super.getLinks(PutUserStoryResourceGen.class);
    }

}