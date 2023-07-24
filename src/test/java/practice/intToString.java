package practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class intToString {

	public static void main(String[] args) {
		
	    // to convert int to string java
		int x = 5;
		String s = Integer.toString(x);
		System.out.println("Integer changed to string = "+ s );
		String str = "5";
		
		//Two verification methods
		
		// 1. Using Assertion
		Assert.assertEquals(str, s);

		// 2. Using if & else statement
		if(s.equalsIgnoreCase("5")) {
			System.out.println("String verified");
		}
		else
		{
			System.out.println("Not a string");
		}
	}
}
