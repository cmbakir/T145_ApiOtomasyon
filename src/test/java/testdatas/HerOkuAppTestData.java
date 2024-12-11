package testdatas;

import org.json.JSONObject;

public class HerOkuAppTestData {
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
}