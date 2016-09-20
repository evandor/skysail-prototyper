package io.skysail.server.app.prototypr.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features
        //tags = {"@JustMe"},
        tags = {"@applications","~@Ignore"},
        plugin = {"pretty", "json:generated/cucumber.json"}
)
public class RunCucumberTests { // NOSONAR

}
