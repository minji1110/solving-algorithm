package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack=new Stack();
        List list=new ArrayList();
        int count=1;

        int n = Integer.parseInt(reader.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(reader.readLine());
            while (count<=num){
                stack.push(count++);
                list.add("+");
            }
            if(stack.empty()||stack.peek()<num){
                System.out.println("NO");
                return;
            }
            while (!stack.empty()&&stack.peek()>=num){
                stack.pop();
                list.add("-");
            }
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
