package io.skysail.server.app.designer.codegen;
                
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.api.links.Link;
                
import java.util.List;
import java.util.Map;

import io.skysail.server.ResourceContextId;
                
public class AppDesignerWikiPagesResource extends ListServerResource<AppDesignerWikiPage> {

    public AppDesignerWikiPagesResource() {
        //super(AppDesignerWikiPage.class);
        addToContext(ResourceContextId.LINK_TITLE, "list AppDesignerWikiPages");
    }
    
    public List<AppDesignerWikiPage> getEntity() {
        return ((DesignerApplication) getApplication()).getRepository().findAll("select from AppDesignerWikiPage");
    }

    public List<Link> getLinks() {
       return super.getLinks(PostAppDesignerWikiPageResource.class);
    }
}
