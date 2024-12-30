package tests;

import baseUrl.BaseUrlHerokuApp;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class C15_GETBaseUrlHerokuApp_AyseHoca_Odev extends BaseUrlHerokuApp {

    @Test
    public void get02(){

        specHerokuApp.pathParam("pp1", "booking").queryParam("firstname","Jim", "lastname");

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");


        response.then().assertThat().statusCode(200).body("booking", Matchers.contains("Jim Jackson"));











    }
}
