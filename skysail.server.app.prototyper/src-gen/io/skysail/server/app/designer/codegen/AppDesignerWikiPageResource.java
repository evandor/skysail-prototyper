package io.skysail.server.app.designer.codegen;

import io.skysail.api.responses.SkysailResponse;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.server.restlet.resources.EntityServerResource;
import io.skysail.server.ResourceContextId;

public class AppDesignerWikiPageResource  extends EntityServerResource<AppDesignerWikiPage > {

    private String listId;
    private DesignerApplication app;

    public AppDesignerWikiPageResource() {
        addToContext(ResourceContextId.LINK_TITLE, "details");
        addToContext(ResourceContextId.LINK_GLYPH, "search");
    }

    @Override
    protected void doInit() {
        //listId = getAttribute(TodoApplication.LIST_ID);
        app = (DesignerApplication) getApplication();
    }

    @Override
    public SkysailResponse<?> eraseEntity() {
       /* TodoList todoList = app.getRepository().getById(TodoList.class, listId);
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
    public AppDesignerWikiPage getEntity() {
        return null;// app.getRepository().getById(TodoList.class, listId);
    }
    
    /*@Override
    public AppDesignerWikiPage getEntity(String installation) {
        if (installation == null || installation.trim().length() == 0) {
            return getEntity();
        }
        String peersCredentialsName = "Credentials_" + installation;
        String peersCredentials = getRequest().getCookies().getFirstValue(peersCredentialsName);

        String path = app.getRemotePath(installation, "/Todos/Lists/" + listId);
        //String uri = path + "/Todos/Lists";
        
        if (peersCredentials == null) {
            getResponse().redirectSeeOther("/_remotelogin");
            return null;
        } 
        ClientResource cr = new ClientResource(path);
        cr.getCookies().add("Credentials", peersCredentials);
        //cr.get(MediaType.APPLICATION_JSON);

        return cr.get(TodoList.class);
    }*/

 /*
    @Override
    public List<Link> getLinks() {
        return super.getLinks(ListResource.class, TodosResource.class, PutListResource.class);
    }

    @Override
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
