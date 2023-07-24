//package rest;
//
//import static org.testng.Assert.assertEquals;
//
//import org.json.simple.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import io.restassured.specification.RequestSpecification;
//
//public class GetPsychiccardList_android {
//
//	@Test
//	public void listVerify() 
//		
//		
//	{ 
//	    RestAssured.baseURI ="https://oapi.anytimeastro.com/api/psychic/GetPsychicCardListAsync"; 
//	    RequestSpecification request = RestAssured.given();
//	    JSONObject requestParams = new JSONObject();
//	    
//										     requestParams.put("cid", 4956);
//										     requestParams.put("ctid", 0); 
//										     requestParams.put("cul", 1);
//										     requestParams.put("eftr", 1); 
//										     requestParams.put("gfav", false);
//										     requestParams.put("pg", 1); 
//										     requestParams.put("pgs", 10); 
//										     requestParams.put("src", "ata_freechat");
//										     requestParams.put("ste", false); 
//	     
//	     request.header("Content-Type", "application/json");
//	     request.body(requestParams.toJSONString());
//	    
//	    Response response = request.post("");
//	    ResponseBody body = response.getBody();
//	    
//	   // JsonPath jsonPathEvaluator = response.jsonPath();
//	  /*  String pageSizeNo = jsonPathEvaluator.get("result.card.items.edn");
//	    System.out.println(pageSizeNo);
//	    Assert.assertEquals(pageSizeNo, "Garima" );
//	    */
//	    int i = response.jsonPath().get("result.card.pageSize");
//	    System.out.println("PageSize is " + i);
//	    Assert.assertEquals(i, 10 );
//	    
//	   
//	 //   System.out.println(response.getStatusLine());
//	    System.out.println(body.prettyPrint());
//	    
//	     
//	}
//}
