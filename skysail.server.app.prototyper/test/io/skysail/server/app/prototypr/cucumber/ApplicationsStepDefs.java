package io.skysail.server.app.prototypr.cucumber;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restlet.Application;
import org.restlet.data.Form;

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
import io.skysail.server.app.designer.repo.DesignerRepository;
import io.skysail.server.db.OrientGraphDbService;
import io.skysail.server.db.validators.UniqueNameValidator;
import io.skysail.server.testsupport.cucumber.CucumberStepContext;

public class ApplicationsStepDefs extends StepDefs {

    private ApplicationsResource getListResource;
    private List<DbApplication> applications;
    private PostApplicationResource postResource;
    private PutApplicationResource putResource;
    private ApplicationResource getApplicationResource;

    private EntityServerResponse<DbApplication> entity2;

    // === GIVEN ============================================================================

    @Given("^a running DesignerApplication$")
    public void a_clean_DesignerApplication() {
        super.setUp(new DesignerApplication(),new CucumberStepContext(DbApplication.class));

        Repositories repos = new Repositories();
        DesignerRepository repo = new DesignerRepository();
        OrientGraphDbService dbService = new OrientGraphDbService();
        dbService.activate();
        repo.setDbService(dbService);
        repo.activate();
        repos.setRepository(repo);
        ((DesignerApplication) application).setRepositories(repos);

        getListResource = setupResource(new ApplicationsResource());
        getApplicationResource = setupResource(new ApplicationResource());
        postResource = setupResource(new PostApplicationResource());
        putResource = setupResource(new PutApplicationResource());

        new UniqueNameValidator().setDbService(dbService);

    }

    // === WHENS ========================================================================

    @When("^I add an application like this:$")
    public void postData(Map<String, String> data) {
        stepContext.post(postResource, data);
    }

    @When("^I query all applications$")
    public void i_query_all_Applications() {
        applications = getListResource.getEntities(stepContext.getVariant()).getEntity();
    }

    @When("^I open the Application page$")
    public void i_open_the_Application_page() {
        prepareRequest(getApplicationResource);
        entity2 = getApplicationResource.getResource(stepContext.getVariant());
    }

    @When("^I change its '(.+)' to '(.+)'$")
    public void i_change_it_s_name_to(String key, String value) {
        prepareRequest(getApplicationResource);
        EntityServerResponse<DbApplication> lastEntity = getApplicationResource.getResource(stepContext.getVariant());
        Form form = new Form();
        form.add("id", lastEntity.getEntity().getId());
        form.add("name", value);
        //form.add("iban", lastEntity.getEntity().getIban());
        prepareRequest(putResource);
        putResource.put(stepContext.formFor(
                "id:" + lastEntity.getEntity().getId(),
                "name:" + value// ,
        // "iban:"+lastEntity.getEntity().getIban()
        ), stepContext.getVariant());
    }

    @When("^I delete it again$")
    public void i_delete_it_again() {
        prepareRequest(getApplicationResource);
        getApplicationResource.deleteEntity(stepContext.getVariant());
    }

    // === THENS ========================================================================

    @Then("^the applications list page contains such an application:$")
    public void the_result_contains_an_Application_with(Map<String, String> data) {
        assertThat(applications, hasItem(validApplicationWith(stepContext.substitute(data), "name")));
    }

//    @Then("^the page contains:$")
//    public void the_page_contains(Map<String, String> data) {
//        assertThat(ApplicationAsList(entity2), hasItem(validApplicationWith(stepContext.substitute(data), "name", "iban")));
//    }


    @Then("^I get a '(.+)' response$")
    public void i_get_specific_response(String responseType) {
        assertThat(stepContext.getLastResponse().toString(), containsString(responseType));
    }

    @Then("^the page contains '(.+)'$")
    public void the_page_contains_theString(String name) {
//        List<Application> Applications = getListResource.getEntities(stepContext.getVariant()).getEntity();
//        assertThat(Applications, org.hamcrest.Matchers.hasItem(validApplicationWith(substitute(null), "name", "iban")));
        assertThat(entity2.toString(), containsString(name));
    }

//    @Then("^the result does not contain an Application with name '(.+)'$")
//    public void the_result_does_not_contain_an_Application_with_name(String name) {
//        List<Application> Applications = getListResource.getEntities(stepContext.getVariant()).getEntity();
//        //assertThat(Applications, not(org.hamcrest.Matchers.hasItem(validApplicationWith(substitute(null), "name", "iban"))));
//        Optional<String> found = Applications.stream().map(Application -> Application.getName()).filter(n -> n.equals(name)).findFirst();
//        assertThat(found.isPresent(), is(false));
//    }

    @Then("^the page contains a newer created date$")
    public void the_page_contains_a_newer_created_date() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    // === Helper =======================================

    private List<Application> ApplicationAsList(EntityServerResponse<Application> entity22) {
        List<Application> list = new ArrayList<>();
        list.add(entity22.getEntity());
        return list;
    }


}