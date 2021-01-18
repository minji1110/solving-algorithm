package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack=new Stack<>();

        String input=reader.readLine();
        for(int i=0;i<input.length();i++){
            char op=input.charAt(i);
            int tmp=0;
            switch (op){
                case ')':
                    while(true){
                        if(stack.empty()){
                            System.out.println(0);
                            return;
                        }
                        int top = stack.pop();
                        if(top==-3){
                            System.out.println(0);
                            return;
                        }
                        else if(top>0){
                            tmp+=top;
                        }
                        else{
                            if(tmp!=0) stack.push(2*tmp);
                            else stack.push(2);
                            break;
                        }
                    }
                    break;
                case ']':
                    while(true){
                        if(stack.empty()){
                            System.out.println(0);
                            return;
                        }
                        int top = stack.pop();
                        if(top==-2){
                            System.out.println(0);
                            return;
                        }
                        else if(top>0){
                            tmp+=top;
                        }
                        else{
                            if(tmp!=0) stack.push(3*tmp);
                            else stack.push(3);
                            break;
                        }
                    }
                    break;
                case '(':
                    stack.push(-2);
                    break;
                case '[':
                    stack.push(-3);
                    break;
            }
        }
        int answer=0;
        while (!stack.empty()){
            int number=stack.pop();
            if(number<0){
                System.out.println(0);
                return;
            }
            answer+=number;
        }
        System.out.println(answer);
    }

}
