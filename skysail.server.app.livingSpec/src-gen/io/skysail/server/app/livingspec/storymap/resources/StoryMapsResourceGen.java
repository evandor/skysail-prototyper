package io.skysail.server.app.livingspec.storymap.resources;

import io.skysail.server.queryfilter.Filter;
import io.skysail.server.queryfilter.pagination.Pagination;
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.api.links.Link;

import java.util.*;

import io.skysail.server.ResourceContextId;
import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from listResource.stg
 */
public class StoryMapsResourceGen extends ListServerResource<io.skysail.server.app.livingspec.storymap.StoryMap> {

    private LivingSpecApplication app;
    private StoryMapRepository repository;

    public StoryMapsResourceGen() {
        super(StoryMapResourceGen.class);
        addToContext(ResourceContextId.LINK_TITLE, "list StoryMaps");
    }

    public StoryMapsResourceGen(Class<? extends StoryMapResourceGen> cls) {
        super(cls);
    }

    @Override
    protected void doInit() {
        app = (LivingSpecApplication) getApplication();
        repository = (StoryMapRepository) app.getRepository(io.skysail.server.app.livingspec.storymap.StoryMap.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<io.skysail.server.app.livingspec.storymap.StoryMap> getEntity() {
        Filter filter = new Filter(getRequest());
        Pagination pagination = new Pagination(getRequest(), getResponse(), repository.count(filter));
        return repository.find(filter, pagination);
    }

    @Override
    public List<Link> getLinks() {
              return super.getLinks(PostStoryMapResourceGen.class,StoryMapsResourceGen.class);
    }
}