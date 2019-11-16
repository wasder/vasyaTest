package request;

import auth.AuthorizationContext;

import static base.Base.BASE_URI;
import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.nullValue;

public class Request {

    public void authorize() {
        String accessToken = given()
                .baseUri(BASE_URI)
                .expect()
                .statusCode(SC_OK)
                .body("access_token", not(nullValue()))
                .when()
                .post("/oauth/token")
                .body().jsonPath().getString("access_token");
        AuthorizationContext.setAuthToken(accessToken);
    }

}
