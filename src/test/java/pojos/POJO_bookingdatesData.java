package pojos;

public class POJO_bookingdatesData {
    /*
            "bookingdates" : {
               "checkin" : "2021-06-01",
               "checkout" : "2021-06-10"
           }
     */

    private String checkin;
    private String checkout;


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public POJO_bookingdatesData(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public POJO_bookingdatesData() {
    }

    @Override
    public String toString() {
        return "POJO_bookingdatesData{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}