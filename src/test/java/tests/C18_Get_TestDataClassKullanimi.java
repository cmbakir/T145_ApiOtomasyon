package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testdatas.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {
    /*
   *
       https://jsonplaceholder.typicode.com/posts/22 url'ine
       bir GET request yolladigimizda
       donen response’in
           status kodunun 200
           ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

       Response body (Expected Data:)
       {
           "userId":3,
           "id":22,
           "title":"dolor sint quo a velit explicabo quia nam",
           "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                        um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
       }
    */
    @Test
    public void test(){
        //1-Endpoint hazırlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",22);
        //2-Expected Data oluştur
        JSONObject expData= JsonPlaceHolderTestData.expDataOlsutur();

        //3-Response kaydetme
        Response resp=given().when().spec(specJsonPlaceHolder).get("/{pp1}/{pp2}");

        //4-Assertions

        Assertions.assertEquals(JsonPlaceHolderTestData.basariliStatusCode,resp.statusCode());

        JsonPath respJP=resp.jsonPath();
        Assertions.assertEquals(expData.getInt("userId"),respJP.getInt("userId"));
        Assertions.assertEquals(expData.getInt("id"),respJP.getInt("id"));
        Assertions.assertEquals(expData.getString("title"),respJP.getString("title"));
        Assertions.assertEquals(expData.getString("body"),respJP.getString("body"));


    }
}