package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C14_GET_BaseUrlJsonPlaceHolder extends BaseUrlJsonPlaceHolder {
    //  SORU-1
    //      https://jsonplaceholder.typicode.com/posts endpointine
    //      bir GET request gonderdigimizde donen response'un
    //      status code'unun 200 oldugunu ve Response'ta 100 kayit oldugunu test

    @Test
    public void test01(){
        //1-endpoint hazırlama

        specJsonPlaceHolder.pathParam("pp1","posts");

        //2-Expedted Data istenirse hazırlanır

        //3-Response kaydetme

        Response resp=given().when().spec(specJsonPlaceHolder).get("/{pp1}");

        resp.then().assertThat().statusCode(200).body("title", Matchers.hasSize(100));

    }
    //Soru-2
    // https://jsonplaceholder.typicode.com/posts/44 endpointine
    //   bir GET request gonderdigimizde donen response’un
    //   status code’unun 200 oldugunu
    //   ve “title” degerinin “optio dolor molestias sit” oldugunu test edin

    @Test
    public void test02(){
        specJsonPlaceHolder.pathParams("first","posts","second",44);
        Response resp=given().when().spec(specJsonPlaceHolder).get("/{first}/{second}");
        resp.prettyPrint();
        resp.then().assertThat().statusCode(200).body("title", Matchers.equalTo("optio dolor molestias sit"));

    }

    //Soru-3
    //  https://jsonplaceholder.typicode.com/posts/50 endpointine
    //   bir DELETE request gonderdigimizde donen response’un
    //   status code’unun 200 oldugunu ve response body’sinin null oldugunu test edin

    @Test
    public void test03(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",50);
        Response resp=given().when().spec(specJsonPlaceHolder).delete("/{pp1}/{pp2}");
        resp.prettyPrint();
        resp.then().assertThat().statusCode(200).body("title", Matchers.nullValue());

    }
}