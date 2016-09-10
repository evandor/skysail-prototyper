package io.skysail.server.app.prototypr.cucumber;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.ClientInfo;
import org.restlet.data.Reference;
import org.restlet.security.Authenticator;

import io.skysail.api.um.AuthenticationService;
import io.skysail.api.um.AuthorizationService;
import io.skysail.api.validation.DefaultValidationImpl;
import io.skysail.server.app.ServiceListProvider;
import io.skysail.server.app.SkysailApplication;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.server.app.designer.application.DbApplication;
import io.skysail.server.restlet.resources.SkysailServerResource;
import io.skysail.server.testsupport.cucumber.CucumberStepContext;

public class StepDefs {

    public static Matcher<DbApplication> validApplicationWith(Map<String, String> data, String... keys) {
        return new TypeSafeMatcher<DbApplication>() {

            @Override
            public void describeTo(Description desc) {
                desc.appendText("expected result: account with non-null id, creationDate");
                Arrays.stream(keys).forEach(key -> {
                    desc.appendText(", " + key + " = ")
                        .appendValue(data.get(key));
                });

            }

            @Override
            protected boolean matchesSafely(DbApplication account) {
                if (account.getId() == null) {
                    return false;
                }
                if (!account.getName().equals(data.get("name"))) {
                    return false;
                }
                return true;
            }
        };
    }

    @Mock
    protected ServiceListProvider serviceListProvider;

    @Mock
    protected AuthenticationService authenticationService;

    @Mock
    protected AuthorizationService authorizationService;

    @Mock
    protected Authenticator authenticator;

    @Mock
    protected Request request;

    @Mock
    protected Reference resourceRef;

    @Mock
    protected Reference targetRef;

    protected ConcurrentMap<String, Object> requestAttributes;

    protected Context context;

    protected SkysailApplication application;

    protected SkysailServerResource<?> resource;

    protected CucumberStepContext stepContext;

    public void setUp(DesignerApplication app, CucumberStepContext stepContext) {
        this.stepContext = stepContext;

        MockitoAnnotations.initMocks(this);

        this.application = app;
        Context context = new Context();
        Mockito.when(authenticationService.getApplicationAuthenticator(context)).thenReturn(authenticator);
        Mockito.when(serviceListProvider.getAuthenticationService()).thenReturn(authenticationService);
        Mockito.when(serviceListProvider.getAuthorizationService()).thenReturn(authorizationService);
        Mockito.when(serviceListProvider.getValidatorService()).thenReturn(new DefaultValidationImpl());
        requestAttributes = new ConcurrentHashMap<>();
        SkysailApplication.setServiceListProvider(serviceListProvider);
        application.setContext(context);
        application.createInboundRoot();


        org.restlet.Application.setCurrent(application);

        Mockito.when(resourceRef.getTargetRef()).thenReturn(targetRef);
        Mockito.when(request.getResourceRef()).thenReturn(resourceRef);
        Mockito.when(request.getAttributes()).thenReturn(requestAttributes);
        Mockito.when(request.getClientInfo()).thenReturn(new ClientInfo());
    }

    protected void prepareRequest(SkysailServerResource<?> resource) {
        String id = stepContext.getLastResponse().getEntity().getId().toString();
        requestAttributes.put("id", id.replace("#", ""));
        resource.init(context, request, new Response(request));
    }

    protected <T extends SkysailServerResource<?>> T setupResource(T resource) {
        resource.setRequest(request);
        resource.init(context, request, new Response(request));
        return resource;
    }

}
