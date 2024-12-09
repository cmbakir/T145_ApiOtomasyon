package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {

     /*
           https://restful-booker.herokuapp.com/booking url’ine
           asagidaki body’ye sahip bir POST request gonderdigimizde
                    {
                         “firstname” : “Ahmet”,
                         “lastname” : “Bulut”,
                         “totalprice” : 500,
                         “depositpaid” : false,
                         “bookingdates” : {
                             “checkin” : “2021-06-01”,
                             “checkout” : “2021-06-10”
                          “additionalneeds” : “wi-fi”
                     }  },

            donen Response’un,
            status code’unun 200,
             ve content type’inin application/json,
             ve response body’sindeki
                   firstname”in,“Ahmet”,
               ve “lastname”in, “Bulut”,
               ve “totalprice”in,500,
               ve “depositpaid”in,false,
               ve “checkin” tarihinin 2021-06-01
               ve “checkout” tarihinin 2021-06-10
               ve “additionalneeds”in,“wi-fi”
               oldugunu test edin
  */

    @Test
    public void test(){

        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2025-07-01");
        innerData.put("checkout","2025-07-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Berk");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerData);
        reqBody.put("additionalneeds","wifi");


        Response resp=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);


        resp.then().assertThat().statusCode(200).contentType("application/json")
                .body("booking.firstname", equalTo("Berk"),
                        "booking.lastname",equalTo("Yiğit"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2025-07-01"),
                        "booking.bookingdates.checkout",equalTo("2025-07-10"));

        resp.prettyPrint();



    }

}