package practice;

public class splitString1 {

	public static void main(String[] args) {
		
		//how to split a string
		String str = "Innov jawa jpr,raj,rj,hd doc,pio_1,fas1,fas2,tom,ashish kumar,testing";
		String[] split = str.split(",");
		String split1 = split[3] + split[4];
		System.out.println(split1);
	}
}
