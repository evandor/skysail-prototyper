package io.skysail.server.app.designer.codegen;
                
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.api.links.Link;
                
import java.util.List;
import java.util.Map;

import io.skysail.server.ResourceContextId;
                
public class AppDesignerAutomobilesBrandsResource extends ListServerResource<AppDesignerAutomobilesBrand> {

    public AppDesignerAutomobilesBrandsResource() {
        super(AppDesignerAutomobilesBrandResource.class);
        addToContext(ResourceContextId.LINK_TITLE, "list AppDesignerAutomobilesBrands");
    }
    
    public List<AppDesignerAutomobilesBrand> getEntity() {
        return ((DesignerApplication) getApplication()).getRepository().findAll("select from AppDesignerAutomobilesBrand");
    }

    public List<Link> getLinks() {
       return super.getLinks(PostAppDesignerAutomobilesBrandResource.class);
    }
}
