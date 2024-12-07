package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C3_JsonObjeOlusturmak {
/*

    Asagidaki JSON Objesini olusturup konsolda yazdirin.

	{
	"title":"Ahmet",
	"body":"Merhaba",
	"userId":1
	}


 */

    @Test
    public void dataCreate(){

        JSONObject data=new JSONObject();
        data.put("title","Ahmet");
        data.put("body","Merhaba");
        data.put("userId",1);


        System.out.println(data);
    }



    /*
           {
        "firstname":"Jim",
        "lastname":"Brown",
        "totalprice":111,
        "depositpaid":true,
        "bookingdates": {
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                       },
        "additionalneeds":"Breakfast"
    }
     */
    @Test
    public void NestedJsonData(){
        // Bu tip iç içe veri içeren dataları JSON yaparken önce en içerdeki datadan başlanır
        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");

        JSONObject data=new JSONObject();
        data.put("firstname","Jim");
        data.put("lastname","Brown");
        data.put("totalprice",111);
        data.put("depositpaid",true);
        data.put("bookingdates",innerData);
        data.put("additionalneeds","Breakfast");

        System.out.println(data);
    }
}