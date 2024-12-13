package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import pojos.POJO_JsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P26_Get_PojoClass extends BaseUrlJsonPlaceHolder {
            /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */

    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");

        POJO_JsonPlaceHolder expBody=new POJO_JsonPlaceHolder("dolor sint quo a velit explicabo quia nam","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse",3,22);

        Response resp=given().spec(specJsonPlaceHolder).when().get("/{pp1}/{pp2}");

        POJO_JsonPlaceHolder respPOJO=resp.as(POJO_JsonPlaceHolder.class);
        assertEquals(200,resp.getStatusCode());
        assertEquals(expBody.getTitle(),respPOJO.getTitle());
        assertEquals(expBody.getBody(),respPOJO.getBody());
        assertEquals(expBody.getUserId(),respPOJO.getUserId());
        assertEquals(expBody.getId(),respPOJO.getId());
    }

}