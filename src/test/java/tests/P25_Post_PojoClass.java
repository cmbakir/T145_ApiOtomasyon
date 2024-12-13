package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojos.POJO_HerokuAppReqData;
import pojos.POJO_HerokuAppRespData;
import pojos.POJO_bookingdatesData;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P25_Post_PojoClass extends BaseUrlHerokuApp {
    /*
           https://restful-booker.herokuapp.com/booking url’ine
           asagidaki body'ye sahip bir POST request gonderdigimizde
           donen response’un id haric asagidaki gibi oldugunu test edin.

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

          Response Body // expected data
    {
       "bookingid": 24,
       "booking": {
           "firstname": "Ahmet",
           "lastname": "Bulut",
           "totalprice": 500,
           "depositpaid": false,
           "bookingdates": {
               "checkin": "2021-06-01",
               "checkout": "2021-06-10"
           },
           "additionalneeds": "wi-fi"
       }
   }


     */
    @Test
    public void test01(){
        specHerokuApp.pathParam("pp1","booking");
        POJO_bookingdatesData bookingdates=new POJO_bookingdatesData("2021-06-01","2021-06-10");
        POJO_HerokuAppReqData reqBody=new POJO_HerokuAppReqData("Ahmet","Bulut",500,false,bookingdates,"wi-fi");


        POJO_HerokuAppRespData expBody=new POJO_HerokuAppRespData(24,reqBody);

        Response resp=given().spec(specHerokuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

        POJO_HerokuAppRespData respPOJOData=resp.as(POJO_HerokuAppRespData.class);

        assertEquals(expBody.getBooking().getFirstname(),respPOJOData.getBooking().getFirstname());
        assertEquals(expBody.getBooking().getLastname(),respPOJOData.getBooking().getLastname());
        assertEquals(expBody.getBooking().getTotalprice(),respPOJOData.getBooking().getTotalprice());
        assertEquals(expBody.getBooking().isDepositpaid(),respPOJOData.getBooking().isDepositpaid());
        assertEquals(expBody.getBooking().getAdditionalneeds(),respPOJOData.getBooking().getAdditionalneeds());
        assertEquals(expBody.getBooking().getBookingdates().getCheckin(),respPOJOData.getBooking().getBookingdates().getCheckin());
        assertEquals(expBody.getBooking().getBookingdates().getCheckout(),respPOJOData.getBooking().getBookingdates().getCheckout());




    }


}