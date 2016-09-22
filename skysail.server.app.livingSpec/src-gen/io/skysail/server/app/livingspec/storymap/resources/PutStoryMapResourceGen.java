package io.skysail.server.app.livingspec.storymap.resources;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.PutEntityServerResource;

import java.util.Date;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.livingspec.*;
import io.skysail.server.app.livingspec.storymap.*;

/**
 * generated from putResource.stg
 */
public class PutStoryMapResourceGen extends PutEntityServerResource<io.skysail.server.app.livingspec.storymap.StoryMap> {


    protected String id;
    protected LivingSpecApplication app;

    @Override
    protected void doInit() throws ResourceException {
        id = getAttribute("id");
        app = (LivingSpecApplication)getApplication();
    }

    @Override
    public void updateEntity(StoryMap  entity) {
        io.skysail.server.app.livingspec.storymap.StoryMap original = getEntity();
        copyProperties(original,entity);

        app.getRepository(io.skysail.server.app.livingspec.storymap.StoryMap.class).update(original,app.getApplicationModel());
    }

    @Override
    public io.skysail.server.app.livingspec.storymap.StoryMap getEntity() {
        return (io.skysail.server.app.livingspec.storymap.StoryMap)app.getRepository(io.skysail.server.app.livingspec.storymap.StoryMap.class).findOne(id);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(StoryMapsResourceGen.class);
    }
}