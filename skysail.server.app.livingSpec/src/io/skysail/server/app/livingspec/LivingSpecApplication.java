package io.skysail.server.app.livingspec;

import java.util.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import io.skysail.server.app.ApplicationProvider;
import io.skysail.domain.core.Repositories;
import io.skysail.server.app.ApiVersion;
import io.skysail.server.menus.MenuItemProvider;

import io.skysail.server.app.livingspec.*;

import io.skysail.server.app.livingspec.storymap.*;
import io.skysail.server.app.livingspec.storymap.resources.*;
import io.skysail.server.app.livingspec.userstory.*;
import io.skysail.server.app.livingspec.userstory.resources.*;


/**
 * generated from applicationExtended.stg
 */
@Component(immediate = true)
public class LivingSpecApplication extends LivingSpecApplicationGen implements ApplicationProvider, MenuItemProvider {

    public  LivingSpecApplication() {
        super("LivingSpec", new ApiVersion(1), Arrays.asList());
        //addToAppContext(ApplicationContextId.IMG, "/static/img/silk/page_link.png");
    }

    @Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.MANDATORY)
    public void setRepositories(Repositories repos) {
        super.setRepositories(repos);
    }

    public void unsetRepositories(Repositories repo) {
        super.setRepositories(null);
    }

}
