package getemployees;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetEmployeesAPI {

    private static String GET_EMPLOYEES = "http://dummy.restapiexample.com/api/v1/employees";

    @Step("Get list employees")
    public void getListEmployees(){
        SerenityRest.given().get(GET_EMPLOYEES);
    }
}