package tests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C4_PUT_ResponseBilgileriAssertion {
    /*

         https://jsonplaceholder.typicode.com/posts/70 url’ine
         asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
            {
                “title”: “Ahmet”,
                “body”: “Merhaba”,
                “userId”: 10,
                “id”: 70
            }
            donen Response’un,
             status code’unun 200,
             ve content type’inin application/json; charset=utf-8,
             ve Server isimli Header’in degerinin cloudflare,
             ve status Line’in HTTP/1.1 200 OK

     */
    @Test
    public void PUTTest(){
        // 1-Endpoint ve Request Body Hazırlama
        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody=new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        // 2-Expected Data Hazırlanır

        // 3-Response Kaydetme
        Response resp=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        //4-Assertion
        resp.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");
        System.out.println("Tüm testler başarıyla tamamlandı.");

    }
}