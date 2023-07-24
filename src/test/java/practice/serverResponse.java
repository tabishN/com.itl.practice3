/*package practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class serverResponse {
	public static void main(String[] args) {
		
	
	//create instance of chrome driver with remote debugging

	int freePort = findFreePort();

	chromeOptions.addArguments("--remote-debugging-port=" + freePort);

	ChromeDriver driver = new ChromeDriver(chromeOptions);`
// make a get call to http://127.0.0.1:freePort

	String response = makeGetCall( "http://127.0.0.1" + freePort  + "/json" );
//Extract chrome's webSocket Url to listen, you can see response and figure out how to extract

	String webSocketUrl = response.substring(response.indexOf("ws://127.0.0.1"), response.length() - 4);
//Connect to this socket, u can use asyncHttp

	socket = maketSocketConnection( webSocketUrl );
// Enable network capture

	socket.send( { "id" : 1, "method" : "Network.enable" } );
// Now chrome will send all network related events and captures them as follows

	socket.onMessageReceived( String message ){

    Json responseJson = toJson(message);
    if( responseJson.method == "Network.responseReceived" ){
       //extract status code
    }
}

driver.get("http://stackoverflow.com");

}
}
*/
