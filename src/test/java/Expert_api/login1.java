package Expert_api;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class login1 {
	@Test
	public void expertLogin() {
		String requestBody = "{\"user\":{\"email\":\"14apr@mailinator.com\",\"password\":\"Test@123!\",\"role\":3,\"macaddress\":\"342fa3bd2914c9b7\",\"appVersion\":\"1.3.21.25\",\"osVersion\":\"12\"},\"device\":{\"identificationType\":2,\"identification\":\"342fa3bd2914c9b7\",\"platform\":1,\"brand\":\"OnePlus\",\"model\":\"DN2101\"},\"fcmToken\":\"dvdRq_juTDOnQdVu_uqgMa:APA91bHrc6KJh-xmMQYTzREdyKjC20XgzgXs1ANhXnQSR3t_-J58ItTUMhlLpvsIl8Sg1qxcePIVgmdqcZOpPEGrliH5ZUABlV4K8IgwgE6e_2gp6nktnHbHsgSEpQS42yLvVFm_FCAg\"}";
		RequestSpecification res =  RestAssured.given();
		res.baseUri("https://oapi.anytimeastro.com/api");
		res.body(requestBody);
		res.contentType(ContentType.JSON);
		
		Response response = res.post("/accounts/me/tokens?role=3");
		String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);
        
        ValidatableResponse validatableResponse = response.then();
        // It will check if status code is 200
        validatableResponse.statusCode(200);
        // It will give specific record 
        System.out.println("response time is " + response.time());
        int i = response.jsonPath().get("result.user.userId");
		 System.out.println("Expert Id " + i );
		 Assert.assertEquals(3176, i);
        //validatableResponse.body("userId", Matchers.equalTo("2182"));
}
	}


