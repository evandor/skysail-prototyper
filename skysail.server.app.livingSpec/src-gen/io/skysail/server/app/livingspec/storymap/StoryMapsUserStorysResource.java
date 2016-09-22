package io.skysail.server.app.livingspec.storymap;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.server.ResourceContextId;
import io.skysail.server.db.DbClassName;
import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from relationResource.stg
 */
public class StoryMapsUserStorysResource extends ListServerResource<UserStory> {

    private LivingSpecApplicationGen app;
    private StoryMapRepository oeRepo;

    public StoryMapsUserStorysResource() {
        super(StoryMapsUserStoryResource.class);//, StoryMapsStoryMapResource.class);
        addToContext(ResourceContextId.LINK_TITLE, "["+this.getClass().getSimpleName()+"]");
    }

    @Override
    protected void doInit() {
        app = (LivingSpecApplication) getApplication();
        oeRepo = (StoryMapRepository) app.getRepository(StoryMap.class);
    }

    @Override
    public List<UserStory> getEntity() {
        return (List<UserStory>) oeRepo.execute(UserStory.class, "select * from " + DbClassName.of(UserStory.class) + " where #"+getAttribute("id")+" in IN(folders)");
    }

    @Override
    public List<Link> getLinks() {
        return super.getLinks(StoryMapsUserStorysResource.class, PostStoryMapToNewUserStoryRelationResource.class);
    }
}