package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C12_GET_SofassertTest {
    /*

    https://jsonplaceholder.typicode.com/posts/44 url’ine
    bir GET request yolladigimizda
    donen Response’in
     status code’unun 200,
     ve content type’inin application/json; charset=utf-8,

        "userId": 5,
        "id": 44,
        "title": "optio dolor molestias sit",

    ile aynı olduğunu test edin.,

*/
    @Test
    public void test(){

        String url="https://jsonplaceholder.typicode.com/posts/44";

        JSONObject expBody=new JSONObject();
        expBody.put("userId", 5);
        expBody.put("id", 44);
        expBody.put("title", "optio dolor molestias sit");

        Response resp=given().when().get(url);

        // resp.prettyPrint();

        //Bir expBody ile response body karşılaştırılacaksa response muhakkak jsonPath yapılmalıdır
        JsonPath respJP=resp.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resp.statusCode(),200);
        softAssert.assertEquals(resp.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(respJP.get("userId"),expBody.get("userId"));
        softAssert.assertEquals(respJP.get("id"),expBody.get("id"));
        softAssert.assertEquals(respJP.get("title"),expBody.get("title"));


        softAssert.assertAll();


    }

}