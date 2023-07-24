package Expert_api;

import java.sql.Timestamp;
import java.util.Date;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class summary {
	String expertToken="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkc3QiLCJzdWIiOiJ0YWJpc2hAaW5ub3ZhbmF0aGlua2xhYnMuY29tIiwiYXVkIjoiZHN0IiwiZXhwIjoiMTY2OTEwMzE3Ny41NzM2OCIsIm5iZiI6IjE2Njc4OTM1NzcuNTczNjgiLCJpYXQiOiIxNjY3ODkzNTc3LjU3MzY4IiwianRpIjoiMzQ4NGI2ZmQ4MmQyNDVhZGJjMTY1N2NlMWQ5OWM2ODkiLCJyb2wiOiIzIiwidWlkIjoyMDMyNSwiZGlkIjo1NTA3MTR9.6NDSaE0iMlrQYYh5sLsUf1xY5HB5Wv0CeLP4mTHUFhI";
	String chatid ="-NGQM3ccZnV6yyrcGXmw";

	@Test
	public void expertLogin() {
		String requestBody = "{\"reason\":1,\"firstMessageTimeStamp\":\"2022-11-09 06:01:24\",\"lastMessageTimeStamp\":\"2022-11-09 06:02:28\",\"chatEndedFrom\":1}";
		RequestSpecification res =  RestAssured.given();
		res.baseUri("https://api.anytimeastro.com/api");
		res.body(requestBody);
		res.contentType(ContentType.JSON);
		res.header("Authorization", expertToken);
		Response response = res.post("/chats/"+chatid+"/summary");
		String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);
        
        ValidatableResponse validatableResponse = response.then();
        // It will check if status code is 200
        validatableResponse.statusCode(200);
        // It will give specific record 
        System.out.println("response time is " + response.time());
       long i = response.jsonPath().get("result.beginTimestamp");
		 System.out.println("BeginTime : " + i );
		 long j = response.jsonPath().get("result.endTimestamp");
		 System.out.println("endTime : " + j );
		//Assert.assertEquals("1667973683396", i);
       // validatableResponse.body("beginTimestamp", Matchers.equalTo("1667973683396"));
		 Timestamp firsttimestamp = new Timestamp(i);
		 Date startdate = new Date(firsttimestamp.getTime());
		 System.out.println(startdate);
		 Timestamp endtimestamp = new Timestamp(j);
		 Date enddate = new Date(endtimestamp.getTime());
		 System.out.println(enddate);
}
}
