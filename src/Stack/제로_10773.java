package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack=new Stack<>();

        int n=Integer.parseInt(reader.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(reader.readLine());

            if(num!=0)
                stack.push(num);
            else
                stack.pop();
        }

        int sum=0;
        for (Integer i : stack) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
