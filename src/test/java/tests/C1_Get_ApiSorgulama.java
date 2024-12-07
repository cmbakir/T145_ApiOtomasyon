package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiSorgulama {
     /*
     https://restful-booker.herokuapp.com/booking/10 url’ine
     bir GET request gonderdigimizde donen Response’un,
     status code’unun 200,
     ve content type’inin application/json; charset=utf-8,
     ve Server isimli Header’in degerinin Cowboy,
     ve status Line’in HTTP/1.1 200 OK
     ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

  */

    /*
        TÜM API Testleri otomasyon ile çalıştırılırken 4 adım izlenir
            1- EndPoint hazırlanır
            2- Soruda verilmiş ise Expected Data Hazırlanır. Verilmemişse bu adım atlanır
            3- Request karşılığı olarak gelen response bir obje oluşlturularak içine kaydedilir
            4-Assertion işlemi yapılır
     */

    @Test
    public void GetApiTest() {
        //  1- EndPoint hazırlanır
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Soruda verilmiş ise Expected Data Hazırlanır. Verilmemişse bu adım atla
        //verilmemiş

        // 3- Request karşılığı olarak gelen response bir obje oluşlturularak içine kaydedilir
        Response response = given().when().get(url);


        // response.prettyPrint(); Sadece cevap datası yazdırır
        // response.prettyPeek(); Cevabı Header değerleri ile birlikte yazdırır

        //4-Assertion işlemi yapılır
        System.out.println("Status Code: " + response.getStatusCode()); //200
        System.out.println("Content Type: " + response.getContentType()); //application/json; charset=utf-8
        System.out.println("Header[Server]: " + response.getHeader("Server")); //Cowboy
        System.out.println("Status Line: " + response.getStatusLine()); //HTTP/1.1 200 OK
        System.out.println("Response Time: " + response.getTime()); //1877 ms < 5 s


    }

}