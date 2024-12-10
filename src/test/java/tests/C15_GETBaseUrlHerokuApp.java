package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C15_GETBaseUrlHerokuApp extends BaseUrlHerokuApp {
    //1-  https://restful-booker.herokuapp.com/booking endpointine
    //    bir GET request gonderdigimizde
    //    donen response’un
    //          status code’unun 200 oldugunu
    //          ve Response’ta 1200'den fazla booking oldugunu test edin

    @Test
    public void test(){
        specHerokuApp.pathParam("pp1","booking"); //burada da endpoint hazırlanıyor

        Response resp=given().spec(specHerokuApp).when().get("/{pp1}");

        //resp.prettyPrint();
        JsonPath respJP=resp.jsonPath();

        System.out.println("Rezervasyon Sayısı: "+respJP.getList("bookingid").size());
        if (respJP.getList("bookingid").size()>1200) {
            resp.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(respJP.getList("bookingid").size()));
            System.out.println("Status Code:200\nRezervasyon Sayısı 1200'den fazladır.");
        }else{
            resp.then().assertThat().statusCode(200);
            System.out.println("Status Code:200\nRezervasyon Sayısı 1200'den fazla değildir.");
        }


    }
}