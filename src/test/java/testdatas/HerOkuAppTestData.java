package testdatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {
    public static int basariliStatusCode=200;
    public static String contentType="application/json; charset=utf-8";
    public static String connectionHeader="keep-alive";
    /*
                        {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
     */
    public static JSONObject jsonReqDataOlustur(){
        JSONObject reqData=new JSONObject();
        JSONObject innerData=new JSONObject();
        innerData.put("checkin" , "2021-06-01");
        innerData.put("checkout" ,"2021-06-10");

        reqData.put("firstname","Ahmet");
        reqData.put("lastname","Bulut");
        reqData.put("totalprice" ,500);
        reqData.put("depositpaid" , false);
        reqData.put("bookingdates",innerData);
        reqData.put("additionalneeds" , "wi-fi");
        return reqData;
    }

    public static JSONObject jsonExpDataOlustur(){
        JSONObject expData=new JSONObject();
        JSONObject bookingBody=HerOkuAppTestData.jsonReqDataOlustur();

        expData.put("bookingid",24);
        expData.put("booking",bookingBody);

        return expData;
    }

    /*
    {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
     */

    public static Map<String, Object> bookingdatesMAPOlustur(){
        Map<String,Object> bookingdatesMAP=new HashMap<>();
        bookingdatesMAP.put("checkin" , "2021-06-01");
        bookingdatesMAP.put("checkout" , "2021-06-10");

        return bookingdatesMAP;
    };

    public static Map<String,Object> mapDataOlustur(){ // (String firstname, String  lastname, int totalprice, boolean depositpaid, Map<String,Object> bookingdates,String additionalneeds)
        Map<String,Object> mapData=new HashMap<>();
        mapData.put("firstname" , "Ahmet");
        mapData.put("lastname" , "Bulut");
        mapData.put("totalprice" , 500.0);
        mapData.put("depositpaid" , false);
        mapData.put("bookingdates",bookingdatesMAPOlustur());
        mapData.put("additionalneeds" , "wi-fi");

        return mapData;
    }

    public static Map<String,Object> expMapDataOlustur(){
        Map<String,Object> expMap=new HashMap<>();
        expMap.put("bookingid",499.0);
        expMap.put("booking",mapDataOlustur());
        return expMap;
    }




}