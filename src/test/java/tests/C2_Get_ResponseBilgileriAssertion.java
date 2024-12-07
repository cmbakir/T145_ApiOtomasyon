package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class C2_Get_ResponseBilgileriAssertion {
    /*
         https://restful-booker.herokuapp.com/booking/10 url’ine
         bir GET request gonderdigimizde donen Response’un,
         status code’unun 200,
         ve content type’inin application/json; charset=utf-8,
         ve Server isimli Header’in degerinin Cowboy,
         ve status Line’in HTTP/1.1 200 OK
         ve response suresinin 5 sn’den kisa oldugunu test ediniz.

    */
    @Test
    public void test(){
        //1- EndPoint hazırlanır,
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- ExpectedData hazırlanır

        //3- Dönen Response bir obje içine kaydedilir
        Response resp=given().when().get(url);

        //4-Assertion işlemi yapılır
        resp.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");
        System.out.println();
        long respTime=resp.getTime();
        if (respTime<5000){
            System.out.println("Hata Bulunamadı\nResponse süresi 5 saniyeden kısadır");
        }else{
            System.err.println("HATA: Assertion işlemi Response Time açısından fail oldu");
        }


    }
}