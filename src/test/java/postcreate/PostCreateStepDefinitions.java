package postcreate;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostCreateStepDefinitions {

    @Steps
    PostCreateAPI postCreateAPI;

    @When("I create an employee")
    public void iCreateAnEmployee(DataTable dt) {
        postCreateAPI.createEmploye(dt);
    }

    @Then("I verify the data and the message")
    public void iVerifyTheDataAndTheMessage(DataTable dt) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(EmployeResponse.STATUS, equalTo(dt.asList().get(0))));
        restAssuredThat(response -> response.body(EmployeResponse.MESSAGE, equalTo(dt.asList().get(1))));
    }
}
