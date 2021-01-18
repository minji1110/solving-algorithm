package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 탑_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack=new Stack<>();

        int n=Integer.parseInt(reader.readLine());
        String[] heights=reader.readLine().split(" ");

        //first top
        stack.push(new int[]{1,Integer.parseInt(heights[0])});
        System.out.print(0+" ");

        //second~
        for(int i=1;i<n;i++){
            int height=Integer.parseInt(heights[i]);
            while(height>=stack.peek()[1]){
                stack.pop();
                if(stack.empty()){
                    System.out.print(0+" ");
                    break;
                }
            }
            if(!stack.empty()){
                System.out.print(stack.peek()[0]+" ");
            }
            stack.push(new int[]{i+1,height});
        }
    }
}
