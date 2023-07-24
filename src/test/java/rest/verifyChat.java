/*
 * package rest;
 * 
 * import static org.testng.Assert.assertEquals;
 * 
 * import org.testng.annotations.Test;
 * 
 * import io.restassured.RestAssured; import io.restassured.response.Response;
 * 
 * public class verifyChat {
 * 
 * @Test public void firsTtest() { RestAssured.baseURI =
 * "https://oapi.anytimeastro.com/api/psychics/2182/reviews?page=1&pageSize=10";
 * Response response = null; try { response = RestAssured.given().param("page",
 * 1).and().param("pageSize", 10) .when() .get(); } catch(Exception e ) {
 * e.printStackTrace(); }
 * 
 * System.out.println("Status code is " + response.getStatusCode());
 * assertEquals(200, response.getStatusCode());
 * System.out.println(response.asString()); }
 * 
 * }
 */