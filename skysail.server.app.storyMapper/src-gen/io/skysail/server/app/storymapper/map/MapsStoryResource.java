package io.skysail.server.app.storymapper.map;
import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.EntityServerResource;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


/**
 * generated from targetRelationResource.stg
 */
public class MapsStoryResource extends EntityServerResource<Story> {

    @Override
    public SkysailResponse<?> eraseEntity() {
        return null;
    }

    @Override
    public Story getEntity() {
        return null;
    }

   /* @Override
    public List<Link> getLinks() {
        return super.getLinks(MapsStorysResource.class, PostMapsStoryRelationResource.class);
    }*/

}