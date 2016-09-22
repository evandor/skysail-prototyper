package io.skysail.server.app.livingspec.userstory.resources;

import java.util.Date;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.domain.core.repos.Repository;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;
import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;



/**
 * generated from postResourceNonAggregate.stg
 */
public class PostUserStoryResourceGen extends PostEntityServerResource<io.skysail.server.app.livingspec.userstory.UserStory> {

	private LivingSpecApplication app;
    private Repository repository;

    public PostUserStoryResourceGen() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new ");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (LivingSpecApplication) getApplication();
        repository = null;//app.getRepository(Space.class);
    }

    @Override
    public io.skysail.server.app.livingspec.userstory.UserStory createEntityTemplate() {
        return new UserStory();
    }

    @Override
    public void addEntity(io.skysail.server.app.livingspec.userstory.UserStory entity) {
        /*Subject subject = SecurityUtils.getSubject();
*/
        /*io.skysail.server.app.livingspec.storymap.StoryMap entityRoot = (io.skysail.server.app.livingspec.storymap.StoryMap) repository.findOne(getAttribute("id"));
        entityRoot.getUserStorys().add(entity);
        repository.update(entityRoot, app.getApplicationModel());*/
    }

    @Override
    public String redirectTo() {
        return super.redirectTo(UserStorysResourceGen.class);
    }
}