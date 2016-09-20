package io.skysail.server.app.storymapper.map.resources;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.PutEntityServerResource;

import java.util.Date;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.storymapper.*;
import io.skysail.server.app.storymapper.map.*;

/**
 * generated from putResource.stg
 */
public class PutMapResourceGen extends PutEntityServerResource<io.skysail.server.app.storymapper.map.Map> {


    protected String id;
    protected StoryMapperApplication app;

    @Override
    protected void doInit() throws ResourceException {
        id = getAttribute("id");
        app = (StoryMapperApplication)getApplication();
    }

    @Override
    public void updateEntity(Map  entity) {
        io.skysail.server.app.storymapper.map.Map original = getEntity();
        copyProperties(original,entity);

        app.getRepository(io.skysail.server.app.storymapper.map.Map.class).update(original,app.getApplicationModel());
    }

    @Override
    public io.skysail.server.app.storymapper.map.Map getEntity() {
        return (io.skysail.server.app.storymapper.map.Map)app.getRepository(io.skysail.server.app.storymapper.map.Map.class).findOne(id);
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(MapsResourceGen.class);
    }
}