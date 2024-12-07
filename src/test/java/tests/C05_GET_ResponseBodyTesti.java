package tests;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C05_GET_ResponseBodyTesti {
     /*

        https://jsonplaceholder.typicode.com/posts/44 url’ine
        bir GET request yolladigimizda
        donen Response’in
         status code’unun 200,
         ve content type’inin application/json,
         ve response body’sinde bulunan userId’nin 5,
         ve response body’sinde bulunan title’in “optio dolor molestias sit”
        oldugunu test edin.,

  */

    @Test
    public void test(){

        String url="https://jsonplaceholder.typicode.com/posts/44";



        Response resp=given().when().get(url);

        resp.then().assertThat().statusCode(200).contentType("application/json")
                .body("userId",equalTo(5))
                .body("title",equalTo("optio dolor molestias sit")) ;

        System.out.println("Tüm testler başarıyla tamamlandı.");
    }
}