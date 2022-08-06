package deleteemploye;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DeleteEmployeStepDefinitions {

    @Steps
    DeletEmployeAPI deletEmployeAPI;

    @When("I delete employe data by {}")
    public void iDeleteEmployeDataByID(String id) {
        deletEmployeAPI.deleteEmploye(id);
    }

    @Then("I see the message {string}")
    public void iSeeTheMessage(String message) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(DeleteEmployeResponse.MESSAGE, equalTo(message)));
    }
}
