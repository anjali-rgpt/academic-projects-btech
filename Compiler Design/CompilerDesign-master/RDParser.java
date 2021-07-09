import java.util.*;
public class RDParser {
	
	static Scanner scan=new Scanner(System.in);
	static char token=scan.next().charAt(0);
	public static void error(){
		System.out.println("Error");
	}
	public static void match(char x){
		if(token!=x)
			error();
		token=scan.next().charAt(0);
	}
	public static void A(){
		if(token=='a')
			match('a');
		else
			return;
	}
	
	public static void B(){
		if(token=='b')
			match('b');
		else
			return;
	}
	
	public static void S(){
		A();
		B();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S();
		if(token=='$')
			System.out.println("Success");
		
	}

}
