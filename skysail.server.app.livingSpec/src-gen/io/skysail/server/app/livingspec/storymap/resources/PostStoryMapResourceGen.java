package io.skysail.server.app.livingspec.storymap.resources;

import java.util.Date;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.livingspec.*;
import io.skysail.server.app.livingspec.storymap.*;

/**
 * generated from postResource.stg
 */
public class PostStoryMapResourceGen extends PostEntityServerResource<io.skysail.server.app.livingspec.storymap.StoryMap> {

	protected LivingSpecApplication app;

    public PostStoryMapResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new ");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (LivingSpecApplication) getApplication();
    }

    @Override
    public io.skysail.server.app.livingspec.storymap.StoryMap createEntityTemplate() {
        return new StoryMap();
    }

    @Override
    public void addEntity(io.skysail.server.app.livingspec.storymap.StoryMap entity) {
        Subject subject = SecurityUtils.getSubject();
        String id = app.getRepository(io.skysail.server.app.livingspec.storymap.StoryMap.class).save(entity, app.getApplicationModel()).toString();
        entity.setId(id);

    }

    @Override
    public String redirectTo() {
        return super.redirectTo(StoryMapsResourceGen.class);
    }
}