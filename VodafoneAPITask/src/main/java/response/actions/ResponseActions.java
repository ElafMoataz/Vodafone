package response.actions;
import Models.NationalizeModel;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class ResponseActions{
    public static Response response;
    public static void sendNationalizeGetRequest(String name){
        response = given().param("name", name).get(System.getProperty("NationalizeEndpoint"));
    }
    public static int responseStatusCode()
    {
        return response.getStatusCode();
    }
    public static String responseStatusMessage()
    {
        return response.getStatusLine();
    }
    public static long responseTime()
    {
        return response.time();
    }
    public static String responseBody()
    {
        return response.asPrettyString();
    }
    public static ValidatableResponse response()
    {
        return response.then();
    }
    public static NationalizeModel responseJsonBody()
    {
        return response.as(NationalizeModel.class);
    }
}
