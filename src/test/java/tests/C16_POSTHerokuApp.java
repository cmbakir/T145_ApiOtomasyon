package tests;

import baseUrl.BaseUrlHerokuApp;;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C16_POSTHerokuApp extends BaseUrlHerokuApp {
    /*
        2- https://restful-booker.herokuapp.com/booking endpointine
        asagidaki body’ye sahip bir POST request gonderdigimizde
         {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                   "checkin" : "2021-06-01",
                   "checkout" : "2021-06-10"
                      },
            "additionalneeds" : "wi-fi" }

        donen response’un
            status code’unun 200 oldugunu
            ve “firstname” degerinin “Ahmet” oldugunu test edin


         */

    @Test
    public void test(){
        specHerokuApp.pathParam("pp1","booking");
        JSONObject innerData=new JSONObject();
        innerData.put("checkin" , "2021-06-01");
        innerData.put("checkin" , "2021-06-10");

        JSONObject reqData=new JSONObject();
        reqData.put("firstname" , "Ahmet");
        reqData.put("lastname" , "Bulut");
        reqData.put( "totalprice", 500);
        reqData.put("depositpaid" , false);
        reqData.put("bookingdates",innerData);
        reqData.put("additionalneeds" , "wi-fi");

        Response resp=given().contentType(ContentType.JSON).when().spec(specHerokuApp).body(reqData.toString()).post("/{pp1}");

        resp.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Ahmet"));

        System.out.println("Tüm Testler Başarıyla Sonuçlandı");
    }


}