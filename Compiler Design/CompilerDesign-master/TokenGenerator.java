package automata;
import java.util.Scanner;

public class TokenGenerator {
	public static String tokenizer(String s) {
		int state=1;
		int l=s.length();
		String token="";
		
		for(int i=0;i<l+1;i++) {
			System.out.println("Index "+i+" State "+state);
			if(state==1) {
				
				if(s.charAt(i)=='i')
					state=2;
				else if(s.charAt(i)>='a' && s.charAt(i)<='h' ||(s.charAt(i)>='j' && s.charAt(i)<='z'))
						state=4;
				else if(s.charAt(i)>='0' && s.charAt(i)<='9' )
						state=7;
				else if(s.charAt(i)=='.')
					state=5;
				else if(s.charAt(i)==' ')
					state=12;
				else if(s.charAt(i)=='-')
					state=9;
				else
					state=13;
				
			}
			
			else if (state==2) {
				if(i==l) {
					token="id";
					break;
				}
				
				if(s.charAt(i)=='f')
					state=3;
				else if(s.charAt(i)>='a' && s.charAt(i)<='e' || s.charAt(i)>='g' && s.charAt(i)<='z'||s.charAt(i)>='0' && s.charAt(i)<='9')
					state=4;
			}
			
			else if(state==3) {
				if(i==l) {
					token="if";
					break;
				}
				
				if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9')
					state=4;
			}
			
			else if(state==4) {
				if(i==l) {
					token="id";
					break;
				}
				
				if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9')
					continue;
				
			}
			
			else if(state==5) {
				if(i==l) {
					token="error";
					break;
				}
				
				if(s.charAt(i)>='0' && s.charAt(i)<='9')
					state=6;
			}
			
			else if(state==6) {
				if(i==l) {
					token="real";
					break;
				}
				
				if(s.charAt(i)>='0' && s.charAt(i)<='9')
					continue;
			}
			
			else if(state==7) {
				if(i==l) {
					token="num";
					break;
				}
				
				if(s.charAt(i)>='0' && s.charAt(i)<='9')
					continue;
				else if(s.charAt(i)=='.')
					state=8;
				
			}
			
			else if(state==8) {
				if(i==l) {
					token="real";
					break;
				}
				
				if(s.charAt(i)>='0' && s.charAt(i)<='9')
					continue;
			}
			
			else if(state==9) {
				if(i==l) {
					token="error";
					break;
				}
				
				if(s.charAt(i)=='-')
					state=10;
			}
			
           else if(state==10) {
				
				if(i==l || s.charAt(i)=='\n') {
					state=11;	
				}
				
				if(s.charAt(i)>='a' && s.charAt(i)<='z')
					continue;
				
				
			}
			else if(state==11) {
				
				if(i==l) {
					token="comment";
				}
				
				else
					continue;
			}
			
			else if(state==12) {
				
				if(i==l) {
					token="whitespace";
					break;
				}
				
				if(s.charAt(i)=='\n' || s.charAt(i)=='\t' || s.charAt(i)==' ' ) {
					continue;
				}
			}
			
			else {
				token="error";
				break;
			}
			
			
		}
		return token;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input=new Scanner(System.in);
		System.out.println("Enter string input:");
		String x=input.nextLine();
		String[] arr=x.split(" ");
		//System.out.println(arr);
		for(int j=0;j<arr.length;j++) {
			String s=arr[j];
			String token=tokenizer(s);
			System.out.println("Lexeme:"+s+" Token:"+token);
		}
		
		
	}
}
