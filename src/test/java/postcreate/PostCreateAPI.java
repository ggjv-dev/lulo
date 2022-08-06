package postcreate;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostCreateAPI {

    private static final String CREATE_EMPLOYE = "http://dummy.restapiexample.com/api/v1/create";

    @Step("Create employe")
    public void createEmploye(DataTable dt) {
        SerenityRest.given()
                .body("{name:"+dt.asList().get(0)+",salary:"+dt.asList().get(1)+",age:"+dt.asList().get(2)+"}")
                .post(CREATE_EMPLOYE);
    }
}
