package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import testdatas.HerOkuAppTestData;
import testdatas.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C21_Get_TestDataClassKullanimiDinamik extends BaseUrlJsonPlaceHolder {
    /*
        https://jsonplaceholder.typicode.com/posts/40 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":4,
            "id":40,
            "title":"enim quo cumque",
            "body":"ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
     */
    @Test
    public void test(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","40");
        String body="ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam";
        JSONObject expData= JsonPlaceHolderTestData.JsonDataOlustur("enim quo cumque",body,4,40);

        Response resp=given().spec(specJsonPlaceHolder).when().get("/{pp1}/{pp2}");

        JsonPath respJP=resp.jsonPath();

        assertEquals(resp.getStatusCode(),JsonPlaceHolderTestData.basariliStatusCode);
        assertEquals(respJP.getString("title"),expData.getString("title"));
        assertEquals(respJP.getString("body"),expData.getString("body"));
        assertEquals(respJP.getInt("userId"),expData.getInt("userId"));
        assertEquals(respJP.getInt("id"),expData.getInt("id"));


    }
}