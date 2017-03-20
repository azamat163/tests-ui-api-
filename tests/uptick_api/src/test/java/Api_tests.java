import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

/**
 * Created by azamat on 20.03.17.
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class Api_tests {
public static String tracking_id;
public static String token;
    @BeforeClass
    public static void setUp() {

        baseURI = "https://testkk-identityservice.azurewebsites.net";
    }

    @Step("Check POST sign up")
    @Test
    public void signUp(){
        Map<String,String> param = new HashMap<String,String>();
        param.put("firstName", "abccd");
        param.put("lastName", "abcd");
        param.put("accountName", "abc");
        param.put("email", "abggcfffvfffffdgve@gmail.com");
        param.put("phoneNumber", "123");
        param.put("password", "123");
        Response signUp_response =     given().
                log().all().
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(param).
                when().
                post(baseURI + "/identityservice/v1/signup").
                then().
                statusCode(200).
                extract().response();
        System.out.println("sign UP response : " + signUp_response.asString());
        tracking_id = JsonPath.with(signUp_response.asString()).get("trackingId");
    }

    @Step("Check GET status")
    @Test
    public void getStatus() throws InterruptedException {
        Thread.sleep(60000);
        Response getStatus_response;
        getStatus_response = given().
                pathParam("trackingId",tracking_id).
                log().all().
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                when().
                get(baseURI + "/identityservice/v1/TenantCreation/{trackingId}").
                then().
                statusCode(200).
                extract().response();
        System.out.println("getStatus response : " + getStatus_response.asString());
        String Content = JsonPath.with(getStatus_response.asString()).get("eventData.content");
        token = JsonPath.with(Content).get("Token");
        System.out.print(token);
    }

    @Step("Check GET Person")
    @Test
    public void t_getPerson() throws Throwable{
        Response getPerson_response;
        getPerson_response = given().
                log().all().
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                header("Authorisation","Bearer " + token).
                when().
                get(baseURI + "/identityservice/v1/PersonDescription").
                then().
                statusCode(200).
                extract().response();
        System.out.println("getPerson response : " + getPerson_response.asString());
    }
}
