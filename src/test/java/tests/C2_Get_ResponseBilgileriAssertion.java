package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C2_Get_ResponseBilgileriAssertion {
     /*
    https://restful-booker.herokuapp.com/booking/10 url'ine
    bir GET request gonderdigimizde donen Response'un,
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8,
    ve Server isimli Header'in degerinin Cowboy,
    ve status Line'in HTTP/1.1 200 OK
    ve response suresinin 5 sn'den kisa oldugunu olarak test ediniz.

 */

    @Test
    public void test(){
        //1-EndPoint Hazırlanır
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-ExpectedData hazırlanır


        //3- Donen Response bir obje içine kaydedilir

        Response resp = given().when().get(url);

        //4-Asset

        resp.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

        long respTime= resp.getTime();
        if(respTime<5000){
            System.out.println("Hata Bulunamadı\nResponse süresi 5 saniyeden kısadır");
        } else {
            System.out.println("Assertion işlemi REsponse Time acısından fail oldu");
        }


    }
}

