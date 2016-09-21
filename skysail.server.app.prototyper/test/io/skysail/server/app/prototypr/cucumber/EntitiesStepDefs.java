package io.skysail.server.app.prototypr.cucumber;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.skysail.api.responses.EntityServerResponse;
import io.skysail.server.app.designer.application.DbApplication;
import io.skysail.server.app.designer.entities.DbEntity;
import io.skysail.server.app.designer.entities.resources.EntitiesResource;
import io.skysail.server.app.designer.entities.resources.EntityResource;
import io.skysail.server.app.designer.entities.resources.PostEntityResource;
import io.skysail.server.app.designer.entities.resources.PutEntityResource;

public class EntitiesStepDefs extends StepDefs {

    private EntitiesResource getListResource;
    private List<DbEntity> applications;
    private PostEntityResource postResource;
    private PutEntityResource putResource;
    private EntityResource getApplicationResource;

    private EntityServerResponse<DbApplication> entity2;

    // === GIVEN ============================================================================

    @Given("^an application like this:$")
    public void an_application_like_this(DataTable arg1)  {
    }


    // === WHENS ========================================================================

    @When("^I add an entity like this:$")
    public void i_add_an_entity_like_this( Map<String,String> data) {
    	stepContext.post(postResource, data);
    }

    // === THENS ========================================================================


    // === Helper =======================================


}
