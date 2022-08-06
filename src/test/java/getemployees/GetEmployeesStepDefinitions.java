package getemployees;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetEmployeesStepDefinitions {

    @Steps
    GetEmployeesAPI getEmployeesAPI;

    @When("I consult the list of employees")
    public void iConsultTheListOfEmployees() {
        getEmployeesAPI.getListEmployees();
    }

    @Then("list result contains employee data:")
    public void listResultContainsEmployeeData(DataTable dt) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(EmployeesResponse.NAME, equalTo(dt.asList().get(0))));
        restAssuredThat(response -> response.body(EmployeesResponse.SALARY, equalTo(new Integer(dt.asList().get(1)))));
    }
}
