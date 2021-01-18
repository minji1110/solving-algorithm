package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class 외계인의기타연주_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer>[] stackList=new Stack[7];
//        for (Stack<Integer> stack : stackList) {
//            stack=new Stack<>();
//            stack.push(0);
//        }
        for (int i = 1; i <= 6; i++) {
            stackList[i] = new Stack<>();
            stackList[i].push(0);
        }

        int n = Integer.parseInt(reader.readLine().split(" ")[0]);
        int cnt=0;
        for(int i=0;i<n;i++){
            String[] pair = reader.readLine().split(" ");
            int num= Integer.parseInt(pair[0]);
            int p=Integer.parseInt(pair[1]);

            while(stackList[num].peek()>p){
                stackList[num].pop();
                cnt++;
            }
            if(stackList[num].peek()!=p){
                stackList[num].push(p);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
