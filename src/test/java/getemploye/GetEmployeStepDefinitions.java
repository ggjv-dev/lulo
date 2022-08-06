package getemploye;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetEmployeStepDefinitions {

    @Steps
    GetEmployeAPI getEmployeAPI;

    @When("I query employee data by id {}")
    public void iQueryEmployeeDataByID(String id) {
        getEmployeAPI.getEmploye(id);
    }

    @Then("I verify the employe data")
    public void iVerifyTheEmployeData(DataTable dt) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(EmployeResponse.ID, equalTo(new Integer(dt.asList().get(0)))));
        restAssuredThat(response -> response.body(EmployeResponse.EMPLOYEE_NAME, equalTo(dt.asList().get(1))));
        restAssuredThat(response -> response.body(EmployeResponse.EMPLOYEE_SALARY, equalTo(new Integer(dt.asList().get(2)))));
        restAssuredThat(response -> response.body(EmployeResponse.EMPLOYEE_AGE, equalTo(new Integer(dt.asList().get(3)))));
    }
}
