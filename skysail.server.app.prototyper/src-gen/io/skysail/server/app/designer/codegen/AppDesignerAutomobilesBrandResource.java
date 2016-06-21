package io.skysail.server.app.designer.codegen;

import java.util.List;

import io.skysail.api.links.Link;
import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.ResourceContextId;

public class AppDesignerAutomobilesBrandResource  extends EntityServerResource<AppDesignerAutomobilesBrand > {

    private String id;
    private DesignerApplication app;

    public AppDesignerAutomobilesBrandResource() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        id = getAttribute("id");
        app = (DesignerApplication) getApplication();
    }

    @Override
    public SkysailResponse<?> eraseEntity() {
       /* TodoList todoList = app.getRepository().getById(AppDesignerAutomobilesBrand.class, listId);
        if (todoList.getTodosCount() > 0) {
            // TODO revisit: make a business violation from that
            getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST, new IllegalStateException(),
                    "cannot delete list as it is not empty");
            return new SkysailResponse<String>();
        }
        app.getRepository().delete(TodoList.class, listId);*/
        return new SkysailResponse<String>();
    }

    @Override
    public AppDesignerAutomobilesBrand getEntity() {
        return app.getRepository().getById(AppDesignerAutomobilesBrand.class, id);
    }
    
    @Override
    public List<Link> getLinks() {
        return super.getLinks(PutAppDesignerAutomobilesBrandResource.class);
    }

/*    @Override
    public String redirectTo() {
        return super.redirectTo(ListsResource.class);
    }

    @Override
    public Consumer<? super Link> getPathSubstitutions() {
        return l -> {
            l.substitute("lid", listId);
        };
    }*/
}