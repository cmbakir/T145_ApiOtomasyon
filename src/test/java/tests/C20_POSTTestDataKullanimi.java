package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testdatas.HerOkuAppTestData;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C20_POSTTestDataKullanimi extends BaseUrlHerokuApp {

    @Test
    public void test() {
        /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un bookingid haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
         */

        specHerokuApp.pathParam("pp1", "booking");
        JSONObject reqBody = HerOkuAppTestData.jsonReqDataOlustur();

        JSONObject expBody = HerOkuAppTestData.jsonExpDataOlustur();

        Response resp=given().spec(specHerokuApp).contentType(ContentType.JSON)
                .when().body(reqBody.toString()).post("/{pp1}");

        JsonPath respJP=resp.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"),respJP.getString("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),respJP.getString("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),respJP.getInt("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),respJP.getBoolean("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),respJP.getString("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.getString("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.getString("booking.bookingdates.checkout"));



    }
}