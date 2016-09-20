package io.skysail.server.app.storymapper.map;

import java.util.List;

import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.api.links.Link;
import io.skysail.server.restlet.resources.PostRelationResource2;
import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


/**
 * generated from postRelationToNewEntityResource.stg
 */
public class PostMapToNewStoryRelationResource extends PostRelationResource2<Story> {

    private StoryMapperApplicationGen app;
    private MapRepository repo;
    private String parentId;

    public PostMapToNewStoryRelationResource() {
        // addToContext(ResourceContextId.LINK_TITLE, "add");
    }

    @Override
    protected void doInit() {
        app = (StoryMapperApplication) getApplication();
        repo = (MapRepository) app.getRepository(io.skysail.server.app.storymapper.map.Map.class);
        parentId = getAttribute("id");
    }

    public Story createEntityTemplate() {
        return new Story();
    }

    @Override
    public void addEntity(Story entity) {
        Map parent = repo.findOne(parentId);
        parent.getStorys().add(entity);
        repo.save(parent, getApplication().getApplicationModel());
    }

    @Override
    public List<Link> getLinks() {
        return super.getLinks(MapsStorysResource.class, PostMapToNewStoryRelationResource.class);
    }
}