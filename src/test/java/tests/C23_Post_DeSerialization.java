package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testdatas.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C23_Post_DeSerialization extends BaseUrlHerokuApp {
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
                        "bookingid":24,
                        "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                "checkin":"2021-06-01",
                                "checkout":"2021-06-10"
                            ,
                            "additionalneeds":"wi-fi"
                        }
         */

    @Test
    public void test01(){
        specHerokuApp.pathParam("pp1","booking");

        Map<String, Object> reqMapData= HerOkuAppTestData.mapDataOlustur();

        Map<String,Object> expMapData= HerOkuAppTestData.expMapDataOlustur();

        Response resp=given().spec(specHerokuApp).contentType(ContentType.JSON)
                .when().body(reqMapData).post("/{pp1}");

        assertEquals(resp.getStatusCode(),HerOkuAppTestData.basariliStatusCode);

        Map<String, Object> respMAP=resp.as(HashMap.class);

        assertEquals(((Map)expMapData.get("booking")).get("firstname"),((Map)respMAP.get("booking")).get("firstname"));

        assertEquals(((Map)expMapData.get("booking")).get("lastname"),((Map)respMAP.get("booking")).get("lastname"));
        assertEquals(((Map)expMapData.get("booking")).get("totalprice"),((Map)respMAP.get("booking")).get("totalprice"));
        assertEquals(((Map)expMapData.get("booking")).get("depositpaid"),((Map)respMAP.get("booking")).get("depositpaid"));
        assertEquals(((Map)expMapData.get("booking")).get("additionalneeds"),((Map)respMAP.get("booking")).get("additionalneeds"));

        assertEquals((((Map)((Map)expMapData.get("booking")).get("bookingdates"))).get("checkin"),(((Map)((Map)respMAP.get("booking")).get("bookingdates"))).get("checkin"));
        assertEquals((((Map)((Map)expMapData.get("booking")).get("bookingdates"))).get("checkout"),(((Map)((Map)respMAP.get("booking")).get("bookingdates"))).get("checkout"));






    }

}