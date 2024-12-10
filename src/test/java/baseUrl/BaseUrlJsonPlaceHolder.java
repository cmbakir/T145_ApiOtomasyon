package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseUrlJsonPlaceHolder {
    // https://jsonplaceholder.typicode.com

    protected RequestSpecification specJsonPlaceHolder;

    @BeforeEach
    public void setup(){

        specJsonPlaceHolder=new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }
}