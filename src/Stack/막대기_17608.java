package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 막대기_17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack=new Stack<>();

        int n=Integer.parseInt(reader.readLine());
        for (int i=0;i<n;i++){
            stack.push(Integer.parseInt(reader.readLine()));
        }
        int max=stack.pop();
        int cnt=1;
        while (!stack.empty()){
            int poped=stack.pop();
            if(poped>max){
                max=poped;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
