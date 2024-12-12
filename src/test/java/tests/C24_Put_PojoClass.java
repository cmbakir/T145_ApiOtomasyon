package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojos.POJO_JsonPlaceHolder;
import testdatas.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C24_Put_PojoClass extends BaseUrlJsonPlaceHolder {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’0e sahip bir PUT request yolladigimizda
        donen response’in
        status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body : // expected data
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        POJO_JsonPlaceHolder reqBody=new POJO_JsonPlaceHolder("Ahmet","Merhaba",10,70);

        POJO_JsonPlaceHolder expBody=new POJO_JsonPlaceHolder("Ahmet","Merhaba",10,70);

        Response resp=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON).when().body(reqBody).put("/{pp1}/{pp2}");

        POJO_JsonPlaceHolder respPOJO=resp.as(POJO_JsonPlaceHolder.class);

        assertEquals(expBody.getTitle(),respPOJO.getTitle());
        assertEquals(expBody.getBody(),respPOJO.getBody());
        assertEquals(expBody.getUserId(),respPOJO.getUserId());
        assertEquals(expBody.getId(),respPOJO.getId());

        assertEquals(JsonPlaceHolderTestData.basariliStatusCode,resp.statusCode());
        assertEquals(JsonPlaceHolderTestData.contentType,resp.contentType());
        assertEquals(JsonPlaceHolderTestData.connetionHeader,resp.header("Connection"));




    }

}