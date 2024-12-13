package pojos;

public class POJO_HerokuAppRespData {

    /*
        {
    "bookingid": 24,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
     */
    private int bookingid;
    private POJO_HerokuAppReqData booking;


    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public POJO_HerokuAppReqData getBooking() {
        return booking;
    }

    public void setBooking(POJO_HerokuAppReqData booking) {
        this.booking = booking;
    }

    public POJO_HerokuAppRespData(int bookingid, POJO_HerokuAppReqData booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public POJO_HerokuAppRespData() {
    }

    @Override
    public String toString() {
        return "POJO_HerokuAppRespData{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}