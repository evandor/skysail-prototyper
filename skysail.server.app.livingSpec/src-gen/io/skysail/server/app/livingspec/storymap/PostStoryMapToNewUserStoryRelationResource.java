package io.skysail.server.app.livingspec.storymap;

import java.util.List;

import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.api.links.Link;
import io.skysail.server.restlet.resources.PostRelationResource2;
import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from postRelationToNewEntityResource.stg
 */
public class PostStoryMapToNewUserStoryRelationResource extends PostRelationResource2<UserStory> {

    private LivingSpecApplicationGen app;
    private StoryMapRepository repo;
    private String parentId;

    public PostStoryMapToNewUserStoryRelationResource() {
        // addToContext(ResourceContextId.LINK_TITLE, "add");
    }

    @Override
    protected void doInit() {
        app = (LivingSpecApplication) getApplication();
        repo = (StoryMapRepository) app.getRepository(io.skysail.server.app.livingspec.storymap.StoryMap.class);
        parentId = getAttribute("id");
    }

    public UserStory createEntityTemplate() {
        return new UserStory();
    }

    @Override
    public void addEntity(UserStory entity) {
        StoryMap parent = repo.findOne(parentId);
        parent.getUserStorys().add(entity);
        repo.save(parent, getApplication().getApplicationModel());
    }

    @Override
    public List<Link> getLinks() {
        return super.getLinks(StoryMapsUserStorysResource.class, PostStoryMapToNewUserStoryRelationResource.class);
    }
}