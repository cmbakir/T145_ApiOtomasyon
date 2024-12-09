package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_GET_BodyTekrarlardanKurtulma {

    /*
    C07_GET_BodyTekrarlardanKurtulma
    https://restful-booker.herokuapp.com/booking/10 url'ine
    bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json,
        ve response body'sindeki
           "firstname"in, "Eric",
        ve "lastname"in, "Ericsson",
        ve "totalprice"in, 869,
        ve "depositpaid"in, true,
        ve "additionalneeds"in, "Breakfast"
   oldugunu test edin

 */

    @Test
    public void test(){

        // 1-Endpoint Hazırlama
        String url=" https://restful-booker.herokuapp.com/booking/10";

        // 2-Expected Body Hazırlama
        //istenmemis

        // 3-Response kaydetme
        Response resp = given().when().get(url);


        // 4-Assertion İşlemi
        resp.then().assertThat().statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Eric"), "lastname",equalTo("Ericsson"),
                        "totalprice", equalTo(869), "depositpaid", equalTo(true),
                        "additionalneeds",equalTo("Breakfast"));


    }
}
