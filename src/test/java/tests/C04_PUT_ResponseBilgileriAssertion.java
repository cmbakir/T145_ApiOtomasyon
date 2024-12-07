package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C04_PUT_ResponseBilgileriAssertion {
   /*
C04_PUT_ResponseBilgileriAssertion
     https://jsonplaceholder.typicode.com/posts/70 url'ine
     asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }
        donen Response'un,
         status code'unun 200,
         ve content type'inin application/json; charset=utf-8,
         ve Server isimli Header'in degerinin cloudflare,
         ve status Line'in HTTP/1.1 200 OK

 */

    @Test
    public void PUTTest(){

        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody = new JSONObject();
        reqBody.put(  "title", "Ahmet");
        reqBody.put(    "body", "Merhaba");
        reqBody.put( "userId", 10);
        reqBody.put(    "id", 70);

    }
}
