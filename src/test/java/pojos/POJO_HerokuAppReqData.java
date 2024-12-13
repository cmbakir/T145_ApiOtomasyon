package pojos;

public class POJO_HerokuAppReqData {
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


    //1-Keyleri kullanarak private variable oluşturulur
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private POJO_bookingdatesData bookingdates;
    private String additionalneeds;

    //2-Getter ve Setter metodları ayarlanır


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public POJO_bookingdatesData getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(POJO_bookingdatesData bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    //3-Bu variable'larla bir parametreli constructor oluşturulur

    public POJO_HerokuAppReqData(String firstname, String lastname, int totalprice, boolean depositpaid, POJO_bookingdatesData bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }
    //4-Default Constructor öldüğü için Parametresiz constructor oluşturulur
    public POJO_HerokuAppReqData() {
    }

    //5-Raporlama ihtiyacında kullanmak için toString() metdo uygulanır


    @Override
    public String toString() {
        return "POJO_HerokuAppReqData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}