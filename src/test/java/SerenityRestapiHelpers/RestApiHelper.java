package SerenityRestapiHelpers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static net.serenitybdd.rest.RestRequests.given;

public class RestApiHelper {

    public static Response doGetRequest(String endpoint) throws IOException {
        return  given()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get("")
                .then().contentType(ContentType.JSON)
                .extract()
                .response();
    }


}
