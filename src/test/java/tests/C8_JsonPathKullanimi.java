package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C8_JsonPathKullanimi {
    /*
    {
            "firstName":"Ahmet",
            "lastName":"Bulut",
            "address":{
                   "streetAddress":"Kurtulus cad.",
                   "city":"Ankara",
                "postalCode":"06100"
                      },
            "age":49,
            "phoneNumbers":[
                {
                   "number":"532-555 55 55",
                  "type":"cep"
                },
                {
                  "number":"0312-123 4567",
                  "type":"ev "
                }
              ]
      }

     */
    @Test
    public void test(){

        JSONObject kisiBilgisi=new JSONObject();
        JSONObject adresBilgisi=new JSONObject();
        JSONArray telefonBilgileri=new JSONArray();
        JSONObject evTelBilgisi=new JSONObject();
        JSONObject cepTelBilgisi=new JSONObject();

        cepTelBilgisi.put("number","532-555 55 55");
        cepTelBilgisi.put("type","cep");
        evTelBilgisi.put("number","216-555 55 55");
        evTelBilgisi.put("type","ev");
        telefonBilgileri.put(cepTelBilgisi);
        telefonBilgileri.put(evTelBilgisi);


        adresBilgisi.put("streetAddress","Kurtulus cad.");
        adresBilgisi.put("city","Ankara");
        adresBilgisi.put("postalCode","06100");

        kisiBilgisi.put( "firstName","Murat");
        kisiBilgisi.put( "lastName","Yiğit");
        kisiBilgisi.put("age","49");
        kisiBilgisi.put("address",adresBilgisi);
        kisiBilgisi.put("phoneNumbers",telefonBilgileri);

        //System.out.println(kisiBilgisi);
        System.out.println("\n");

        System.out.println("Adı: "+kisiBilgisi.get("firstName"));
        System.out.println("Soyadı: "+kisiBilgisi.get("lastName"));
        System.out.println("Yaş: "+kisiBilgisi.get("age"));
        System.out.println("Yaşadığı Şehir: "+kisiBilgisi.getJSONObject("address").get("city"));
        System.out.println("Cep Tel : "+kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Ev Tel : "+kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));
    }
}