package io.skysail.server.app.prototypr.cucumber;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restlet.data.Form;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.skysail.api.responses.EntityServerResponse;
import io.skysail.domain.core.Repositories;
import io.skysail.server.app.designer.DesignerApplication;
import io.skysail.server.app.designer.application.DbApplication;
import io.skysail.server.app.designer.application.resources.ApplicationResource;
import io.skysail.server.app.designer.application.resources.ApplicationsResource;
import io.skysail.server.app.designer.application.resources.PostApplicationResource;
import io.skysail.server.app.designer.application.resources.PutApplicationResource;
import io.skysail.server.app.designer.entities.DbEntity;
import io.skysail.server.app.designer.entities.resources.EntitiesResource;
import io.skysail.server.app.designer.entities.resources.EntityResource;
import io.skysail.server.app.designer.entities.resources.PostEntityResource;
import io.skysail.server.app.designer.entities.resources.PutEntityResource;
import io.skysail.server.app.designer.repo.DesignerRepository;
import io.skysail.server.db.OrientGraphDbService;
import io.skysail.server.db.validators.UniqueNameValidator;
import io.skysail.server.testsupport.cucumber.CucumberStepContext;

public class EntitiesStepDefs extends StepDefs {

    private EntitiesResource getListResource;
    private List<DbEntity> applications;
    private PostEntityResource postResource;
    private PutEntityResource putResource;
    private EntityResource getApplicationResource;

    private EntityServerResponse<DbApplication> entity2;

    // === GIVEN ============================================================================


    // === WHENS ========================================================================

    @When("^I add an entity like this:$")
    public void i_add_an_entity_like_this( Map<String,String> data) {
    	stepContext.post(postResource, data);
    }

    // === THENS ========================================================================


    // === Helper =======================================


}
