package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_jSONObjesiOlusturma {

    /*

    C03_jSONObjesiOlusturma
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":1
    }


 */

    /*
    /*
        {
     "firstname":"Jim",
     "additionalneeds":"Breakfast",
     "bookingdates": {
             "checkin":"2018-01-01",
             "checkout":"2019-01-01"
                    },
      "totalprice":111,
      "depositpaid":true,
      "lastname":"Brown"
 }

 */

    @Test
    public void dataCreate(){
    JSONObject data = new JSONObject();
    data.put("title","Ahmet");
    data.put("body","Merhaba");
    data.put("userId",1);


        }

}

