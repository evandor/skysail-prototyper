package io.skysail.server.app.storymapper.story.resources;

import java.util.Date;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.domain.core.repos.Repository;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.storymapper.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;



/**
 * generated from postResourceNonAggregate.stg
 */
public class PostStoryResourceGen extends PostEntityServerResource<io.skysail.server.app.storymapper.story.Story> {

	private StoryMapperApplication app;
    private Repository repository;

    public PostStoryResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new ");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (StoryMapperApplication) getApplication();
        repository = null;//app.getRepository(Space.class);
    }

    @Override
    public io.skysail.server.app.storymapper.story.Story createEntityTemplate() {
        return new Story();
    }

    @Override
    public void addEntity(io.skysail.server.app.storymapper.story.Story entity) {
        /*Subject subject = SecurityUtils.getSubject();
*/
        /*io.skysail.server.app.storymapper.map.Map entityRoot = (io.skysail.server.app.storymapper.map.Map) repository.findOne(getAttribute("id"));
        entityRoot.getStorys().add(entity);
        repository.update(entityRoot, app.getApplicationModel());*/
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(StorysResourceGen.class);
    }
}