package io.skysail.server.app.designer.codegen;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.server.app.designer.repo.DesignerRepository;
import io.skysail.server.ResourceContextId;
import io.skysail.server.restlet.resources.PostEntityServerResource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.restlet.resource.ResourceException;

public class PostAppDesignerAutomobilesBrandResource extends PostEntityServerResource<AppDesignerAutomobilesBrand> {

	private DesignerApplication app;

    public PostAppDesignerAutomobilesBrandResource() {
        addToContext(ResourceContextId.LINK_TITLE, "Create new AppDesignerAutomobilesBrand");
    }

    @Override
    protected void doInit() throws ResourceException {
        app = (DesignerApplication) getApplication();
    }

	@Override
    public AppDesignerAutomobilesBrand createEntityTemplate() {
        return new AppDesignerAutomobilesBrand();
    }

    @Override
    public SkysailResponse<?> addEntity(AppDesignerAutomobilesBrand entity) {
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
