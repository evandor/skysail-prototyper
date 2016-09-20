package io.skysail.server.app.storymapper.map;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.server.ResourceContextId;
import io.skysail.server.db.DbClassName;
import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


/**
 * generated from relationResource.stg
 */
public class MapsStorysResource extends ListServerResource<Story> {

    private StoryMapperApplicationGen app;
    private MapRepository oeRepo;

    public MapsStorysResource() {
        super(MapsStoryResource.class);//, MapsMapResource.class);
        addToContext(ResourceContextId.LINK_TITLE, "["+this.getClass().getSimpleName()+"]");
    }

    @Override
    protected void doInit() {
        app = (StoryMapperApplication) getApplication();
        oeRepo = (MapRepository) app.getRepository(Map.class);
    }

    @Override
    public List<Story> getEntity() {
        return (List<Story>) oeRepo.execute(Story.class, "select * from " + DbClassName.of(Story.class) + " where #"+getAttribute("id")+" in IN(folders)");
    }

    @Override
    public List<Link> getLinks() {
        return super.getLinks(MapsStorysResource.class, PostMapToNewStoryRelationResource.class);
    }
}