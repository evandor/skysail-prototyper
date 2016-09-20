package io.skysail.server.app.storymapper.map.resources;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


/**
 * generated from entityResource.stg
 */
public class MapResourceGen extends EntityServerResource<io.skysail.server.app.storymapper.map.Map> {

    private String id;
    private StoryMapperApplication app;
    private MapRepository repository;

    public MapResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        id = getAttribute("id");
        app = (StoryMapperApplication) getApplication();
        repository = (MapRepository) app.getRepository(io.skysail.server.app.storymapper.map.Map.class);
    }


    @Override
    public SkysailResponse<?> eraseEntity() {
        repository.delete(id);
        return new SkysailResponse<>();
    }

    @Override
    public Map getEntity() {
        return (Map)app.getRepository().findOne(id);
    }

	@Override
    public List<Link> getLinks() {
        return super.getLinks(PutMapResourceGen.class,PostMapToNewStoryRelationResource.class,MapsStorysResource.class);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(MapsResourceGen.class);
    }


}