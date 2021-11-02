package hongik_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 초콜릿뺏어먹기_23322 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input=bufferedReader.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int k=Integer.parseInt(input[1]);

        input=bufferedReader.readLine().split(" ");
        Integer[] arr=new Integer[n+1];
        arr[0]=-1;
        for(int i=1;i<=n;i++) arr[i]=Integer.parseInt(input[i-1]);

        int cnt=0;
        int days=0;
        int firstCnt=arr[1];
        for(int i=2;i<arr.length;i++){
            if(arr[i]!=firstCnt) {
                days++;
                cnt+=(arr[i]-firstCnt);
            }
        }

        System.out.println(cnt+" "+days);
    }
}
