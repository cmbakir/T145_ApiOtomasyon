package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testdatas.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C19_PUTTestDataKullanimi extends BaseUrlJsonPlaceHolder {
    /*
  https://jsonplaceholder.typicode.com/posts/70 url'ine
  asagidaki body’e sahip bir PUT request yolladigimizda
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
  Response body (Expected Data) :
      {
      "title":"Ahmet",
      "body":"Merhaba",
      "userId":10,
      "id":70
      }
*/
    @Test
    public void test(){
        specJsonPlaceHolder.pathParams("first","posts","second","70");
        JSONObject reqData= JsonPlaceHolderTestData.JsonDataOlustur("Ahmet","Merhaba",7,70);

        JSONObject expData=JsonPlaceHolderTestData.JsonDataOlustur("Ahmet","Merhaba",7,70);

        Response resp=given().spec(specJsonPlaceHolder).when().body(reqData.toString()).contentType(ContentType.JSON).put("/{first}/{second}");

        assertEquals(JsonPlaceHolderTestData.basariliStatusCode,resp.getStatusCode());
        assertEquals(JsonPlaceHolderTestData.contentType,resp.getContentType());

        JsonPath respJP=resp.jsonPath();
        assertEquals(JsonPlaceHolderTestData.connetionHeader,resp.header("Connection"));
        assertEquals(expData.getString("title"),respJP.getString("title"));
        assertEquals(expData.getString("body"),respJP.getString("body"));
        assertEquals(expData.getInt("id"),respJP.getInt("id"));
        assertEquals(expData.getInt("userId"),respJP.getInt("userId"));




    }
}