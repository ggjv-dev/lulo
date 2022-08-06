package deleteemploye;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeletEmployeAPI {

    private static String URL = "http://dummy.restapiexample.com/api/v1/delete/{id}";

    @Step("Delete employee")
    public void deleteEmploye(String id) {
        SerenityRest.given()
                .pathParam("id", id)
                .delete(URL);
    }
}
