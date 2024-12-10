
package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseUrlHerokuApp {
    protected RequestSpecification specHerokuApp;

    @BeforeEach
    public void setup(){
        specHerokuApp=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
