package practice;

public class splitString {

	public static void main(String[] args) {
		
		//how to split a string
		String str = "Hello/World/hey/you/we/can/see";
		String[] split = str.split("/");
		String split1 = split[3];
		System.out.println(split1);
	}
}
