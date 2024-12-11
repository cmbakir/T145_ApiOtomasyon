package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends BaseUrlHerokuApp {
         /*
         C17_BaseUrlHerokuappQueryParam
            https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
                “firstname” degeri “Susan”
                ve “lastname” degeri “Jones” olan
            rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
            donen response’un
                status code’unun 200 oldugunu
                ve “Susan Jones” ismine sahip en az bir booking oldugunu test edin
         */

    @Test
    public void test(){
        specHerokuApp.pathParam("pp1","booking")
                .queryParams("firstname","Susan","lastname","Jones");

        Response resp=given().when().spec(specHerokuApp).get("/{pp1}");

        resp.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(1));
    }
}