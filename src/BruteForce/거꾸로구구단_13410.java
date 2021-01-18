package BruteForce;

import java.util.Scanner;

public class 거꾸로구구단_13410 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();   //단
        int k=scanner.nextInt();    //항
        int max = 0,changed=0;

        for(int i=1;i<=k;i++){
            int origin=n*i;
            int digit=0;    //자릿수-1
            int count=10;
            while(origin/count!=0){
                digit++;
                count*=10;
            }
            changed=0;
            while(digit>-1){
                int multiplied= (int) Math.pow(10,digit);
                changed+=origin%10*multiplied;
                origin/=10;
                digit--;
            }
            if(max<changed)
                max=changed;
        }
        System.out.println(max);
    }
}
