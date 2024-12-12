package pojos;

public class POJO_JsonPlaceHolder {
    /*
    {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    //1-Tüm variable'lar private olarak oluşturulur

    private String title;
    private String body;
    private int userId;
    private int id;


    //2-Bu variable'ları getter and setter ayarlayalım
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3-Tüm Parametreleri içeren constructor oluşturalım


    public POJO_JsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4-Default Constructor
    public POJO_JsonPlaceHolder() {
    }

    //5-ToString uygulanır

    @Override
    public String toString() {
        return "POJO_JsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}