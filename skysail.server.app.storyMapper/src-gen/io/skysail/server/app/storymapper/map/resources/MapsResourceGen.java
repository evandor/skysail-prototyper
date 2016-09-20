package io.skysail.server.app.storymapper.map.resources;

import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.api.links.Link;

import java.util.*;

import io.skysail.server.ResourceContextId;
import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


/**
 * generated from listResource.stg
 */
public class MapsResourceGen extends ListServerResource<io.skysail.server.app.storymapper.map.Map> {

    private StoryMapperApplication app;
    private MapRepository repository;

    public MapsResourceGen() {
        super(MapResourceGen.class);
        addToContext(ResourceContextId.LINK_TITLE, "list Maps");
    }

    public MapsResourceGen(Class<? extends MapResourceGen> cls) {
        super(cls);
    }

    @Override
    protected void doInit() {
        app = (StoryMapperApplication) getApplication();
        repository = (MapRepository) app.getRepository(io.skysail.server.app.storymapper.map.Map.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<io.skysail.server.app.storymapper.map.Map> getEntity() {
        Filter filter = new Filter(getRequest());
        Pagination pagination = new Pagination(getRequest(), getResponse(), repository.count(filter));
        return repository.find(filter, pagination);
    }

    @Override
    public List<Link> getLinks() {
              return super.getLinks(PostMapResourceGen.class,MapsResourceGen.class);
    }
}