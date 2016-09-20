package io.skysail.server.app.storymapper.story.resources;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.PutEntityServerResource;

import java.util.Date;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.storymapper.*;
import io.skysail.server.app.storymapper.story.*;

/**
 * generated from putResource.stg
 */
public class PutStoryResourceGen extends PutEntityServerResource<io.skysail.server.app.storymapper.story.Story> {


    protected String id;
    protected StoryMapperApplication app;

    @Override
    protected void doInit() throws ResourceException {
        id = getAttribute("id");
        app = (StoryMapperApplication)getApplication();
    }

    @Override
    public void updateEntity(Story  entity) {
        io.skysail.server.app.storymapper.story.Story original = getEntity();
        copyProperties(original,entity);

        app.getRepository(io.skysail.server.app.storymapper.story.Story.class).update(original,app.getApplicationModel());
    }

    @Override
    public io.skysail.server.app.storymapper.story.Story getEntity() {
        return (io.skysail.server.app.storymapper.story.Story)app.getRepository(io.skysail.server.app.storymapper.story.Story.class).findOne(id);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(StorysResourceGen.class);
    }
}