package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());

        if(n<=99){
            System.out.println(n);
            reader.close();
            return;
        }

        int cnt=99;
        for(int i=100;i<=n;i++){
            String num=String.valueOf(i);
            if(num.charAt(0)-num.charAt(1) == num.charAt(1)-num.charAt(2))
                cnt++;
        }

        System.out.println(cnt);
        reader.close();
    }
}
