package io.skysail.server.app.designer.codegen;
                
import io.skysail.server.restlet.resources.ListServerResource;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.api.links.Link;
                
import java.util.List;
import java.util.Map;

import io.skysail.server.ResourceContextId;
                
public class AppDesignerWikiSpacesResource extends ListServerResource<AppDesignerWikiSpace> {

    public AppDesignerWikiSpacesResource() {
        //super(AppDesignerWikiSpace.class);
        addToContext(ResourceContextId.LINK_TITLE, "list AppDesignerWikiSpaces");
    }
    
    public List<AppDesignerWikiSpace> getEntity() {
        return ((DesignerApplication) getApplication()).getRepository().findAll("select from AppDesignerWikiSpace");
    }

    public List<Link> getLinks() {
       return super.getLinks(PostAppDesignerWikiSpaceResource.class);
    }
}
