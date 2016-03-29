package io.skysail.server.app.designer.codegen;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.server.app.designer.repo.DesignerRepository;
import io.skysail.server.restlet.resources.PutEntityServerResource;

import java.util.Date;

import org.restlet.resource.ResourceException;

public class PutAppDesignerAutomobilesBrandResource extends PutEntityServerResource<AppDesignerAutomobilesBrand> {

    private String id;
	private DesignerApplication app;

	@Override
    protected void doInit() throws ResourceException {
        super.doInit();
        id = getAttribute("id");
        app = (DesignerApplication)getApplication();
    }
    
    @Override
    public SkysailResponse<?> updateEntity(AppDesignerAutomobilesBrand entity) {
        AppDesignerAutomobilesBrand original = getEntity();

        original.setName(entity.getName());;

        original.setDescription(entity.getDescription());
app.getRepository().update(id, original);

        return new SkysailResponse<>();
    }

    @Override
    public AppDesignerMoneyBank getEntity() {
         return app.getRepository().getById(AppDesignerAutomobilesBrand.class, id);
    }
    
    @Override
    public String redirectTo() {
        return super.redirectTo(AppDesignerAutomobilesBrandsResource.class);
    }

}
