package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testdatas.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C22_Put_DeSerialization extends BaseUrlJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

        Expected Response Body:

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
        Map<String, Object> reqMAPData= JsonPlaceHolderTestData.MAPDataOLustur("Ahmet","Merhaba",10.0,70.0);

        Map<String,Object> expMAPData=JsonPlaceHolderTestData.MAPDataOLustur("Ahmet","Merhaba",10.0,70.0);

        Response resp=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON).when().body(reqMAPData).put("/{pp1}/{pp2}");


        //4- Assertion yapılacak

/*
            expected                resp
              MAP                 Response--->MAP
              olduğu için aseertion yapabilmek amacıyla resp objesinin data türü MAP yapılır
 */

        Map<String,Object> respMAP=resp.as(HashMap.class);

        assertEquals(resp.getStatusCode(),JsonPlaceHolderTestData.basariliStatusCode);
        //Burada header özelliği sorgulandığı için data türünün bir önemi yoktur.

        assertEquals(expMAPData.get("title"),respMAP.get("title"));
        assertEquals(expMAPData.get("body"),respMAP.get("body"));
        assertEquals(expMAPData.get("userId"),respMAP.get("userId"));
        assertEquals(expMAPData.get("id"),respMAP.get("id"));



    }

}