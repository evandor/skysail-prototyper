package io.skysail.server.app.storymapper.map.resources;

import java.util.Date;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.storymapper.*;
import io.skysail.server.app.storymapper.map.*;

/**
 * generated from postResource.stg
 */
public class PostMapResourceGen extends PostEntityServerResource<io.skysail.server.app.storymapper.map.Map> {

	protected StoryMapperApplication app;

    public PostMapResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new ");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (StoryMapperApplication) getApplication();
    }

    @Override
    public io.skysail.server.app.storymapper.map.Map createEntityTemplate() {
        return new Map();
    }

    @Override
    public void addEntity(io.skysail.server.app.storymapper.map.Map entity) {
        Subject subject = SecurityUtils.getSubject();
        String id = app.getRepository(io.skysail.server.app.storymapper.map.Map.class).save(entity, app.getApplicationModel()).toString();
        entity.setId(id);

    }

    @Override
    public String redirectTo() {
        return super.redirectTo(MapsResourceGen.class);
    }
}