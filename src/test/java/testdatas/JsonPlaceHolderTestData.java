package testdatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public static int basariliStatusCode=200;
    public static String contentType="application/json; charset=utf-8";
    public static String connetionHeader="keep-alive";
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
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */
    public static JSONObject expDataOlsutur(){
        JSONObject expData=new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;
    }

    /*
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    public static JSONObject JsonDataOlustur(String title, String body,int userId,int id){
        JSONObject jsonData=new JSONObject();
        jsonData.put("title",title);
        jsonData.put("body",body);
        jsonData.put("userId",userId);
        jsonData.put("id",id);


        return jsonData;
    }

    public static Map<String,Object> MAPDataOLustur(String title, String body,double userId, double id){
        Map<String, Object> bodyData=new HashMap<>();
        bodyData.put("title",title);
        bodyData.put("body",body);
        bodyData.put("userId",userId);
        bodyData.put("id",id);

        return bodyData;
    }




}