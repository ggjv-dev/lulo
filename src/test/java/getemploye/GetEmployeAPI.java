package getemploye;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetEmployeAPI {
    private static String URL = "http://dummy.restapiexample.com/api/v1/employee/{id}";

    @Step("Get employe")
    public void getEmploye(String id){
        SerenityRest.given()
                .pathParam("id", id)
                .get(URL);
    }
}
