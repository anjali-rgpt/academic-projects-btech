package automata;
import java.util.*;
import java.lang.Math;
public class SodaMachine {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input=new Scanner(System.in);
        System.out.println("Enter string input(N,D,Q are valid chars):");
        String x=input.nextLine();
         int state=1;  //0 cash
        int total=0;
        int l= x.length();
        for(int i=0;i<=l;i++){

            if(i==l){
                if (total>=25){
                    System.out.println("Number of sodas:"+Math.round(total/25));
                    System.out.println("Change:"+total%25);
                    break;
                }

                else{
                    System.out.println("Not enough coins.");
                    total=0;
                    state=1;
                    System.out.println("Enter string input(N,D,Q are valid chars):");
                    x=input.nextLine();
                    i=-1;
                    l= x.length();

                }
            }
           System.out.println(x.charAt(i));
            if(x.charAt(i) != 'Q' && x.charAt(i)!='N' && x.charAt(i)!='D'){
                System.out.println("Invalid coin");
                break;
            }



            if(state==1){
                if(x.charAt(i)=='Q') {
                    state = 6;
                    total += 25;
                }
                else if(x.charAt(i)=='N') {
                    state = 2;
                    total+=5;
                }
                else {
                    state = 3;
                    total += 10;
                }
            }

            else if (state == 2) {

                if(x.charAt(i)=='Q') {
                    state = 7;
                    total += 25;
                }
                else if(x.charAt(i)=='N') {
                    state = 3;
                    total+=5;
                }
                else {
                    state = 4;
                    total += 10;
                }

            }

            else if (state == 3) {

                if(x.charAt(i)=='Q') {
                    state = 8;
                    total += 25;
                }
                else if(x.charAt(i)=='N') {
                    state = 4;
                    total+=5;
                }
                else {
                    state = 5;
                    total += 10;
                }

            }

            else if (state == 4) {

                if(x.charAt(i)=='Q') {
                    state = 9;
                    total += 25;
                }
                else if(x.charAt(i)=='N') {
                    state = 5;
                    total+=5;
                }
                else {
                    state = 6;
                    total += 10;
                }

            }

            else if (state == 5) {

                if(x.charAt(i)=='Q') {
                    state = 10;
                    total += 25;
                }
                else if(x.charAt(i)=='N') {
                    state = 6;
                    total+=5;
                }
                else {
                    state = 7;
                    total += 10;
                }

            }

            else if (state >=6 && state<=10) {

                System.out.println("Number of sodas:"+Math.round(total/25));
                System.out.println("Change:"+total%25);
                total=0;
                state=1;
                i=-1;
                System.out.println("Enter string input(N,D,Q are valid chars):");
                x=input.nextLine();
                 l= x.length();

            }


        }






    }

}
