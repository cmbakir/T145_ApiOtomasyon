package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Post_SoftAssertTest {
    /*
           https://restful-booker.herokuapp.com/booking url’ine
           asagidaki body’ye sahip bir POST request gonderdigimizde
                    {
                         “firstname” : “Ahmet”,
                         “lastname” : “Bulut”,
                         “totalprice” : 500,
                         “depositpaid” : false,
                         “bookingdates” : {
                             "checkin" : "2021-06-01",
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
        innerData.put("checkin" , "2021-06-01");
        innerData.put("checkout" , "2021-06-10");
        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Sena");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",200);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates",innerData);
        reqBody.put("additionalneeds","wi-fi");

        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        Response resp=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        JsonPath respJP=resp.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resp.statusCode(),200);
        softAssert.assertEquals(resp.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(respJP.get("booking.firstname"),expBody.getJSONObject("booking").get("firstname"));
        softAssert.assertEquals(respJP.get("booking.lastname"),expBody.getJSONObject("booking").get("lastname"));
        softAssert.assertEquals(respJP.get("booking.totalprice"),expBody.getJSONObject("booking").get("totalprice"));
        softAssert.assertEquals(respJP.get("booking.depositpaid"),expBody.getJSONObject("booking").get("depositpaid"));
        softAssert.assertEquals(respJP.get("booking.bookingdates.checkin"),expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        softAssert.assertEquals(respJP.get("booking.bookingdates.checkout"),expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"));

        softAssert.assertAll();

    }
}