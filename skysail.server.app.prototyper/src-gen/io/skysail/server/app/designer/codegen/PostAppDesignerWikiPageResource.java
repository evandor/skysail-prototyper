package io.skysail.server.app.designer.codegen;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.server.app.designer.repo.DesignerRepository;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;

public class PostAppDesignerWikiPageResource extends PostEntityServerResource<AppDesignerWikiPage> {

	private DesignerApplication app;

    public PostAppDesignerWikiPageResource() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new AppDesignerWikiPage");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (DesignerApplication) getApplication();
    }

	@Override
    public AppDesignerWikiPage createEntityTemplate() {
        return new AppDesignerWikiPage();
    }

    @Override
    public SkysailResponse<?> addEntity(AppDesignerWikiPage entity) {
        Subject subject = SecurityUtils.getSubject();
        //entity.setOwner(subject.getPrincipal().toString());
        String id = DesignerRepository.add(entity).toString();
        entity.setId(id);
        return new SkysailResponse<String>();
    }
    
    //@Override
    //public String redirectTo() {
    //    return super.redirectTo(ApplicationsResource.class);
    //}
   
}
