package io.skysail.server.app.livingspec.storymap;
import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.restlet.resources.EntityServerResource;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from targetRelationResource.stg
 */
public class StoryMapsUserStoryResource extends EntityServerResource<UserStory> {

    @Override
    public SkysailResponse<?> eraseEntity() {
        return null;
    }

    @Override
    public UserStory getEntity() {
        return null;
    }

   /* @Override
    public List<Link> getLinks() {
        return super.getLinks(StoryMapsUserStorysResource.class, PostStoryMapsUserStoryRelationResource.class);
    }*/

}