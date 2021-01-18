package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Stack stack=new Stack();

        int n=Integer.parseInt(reader.readLine());
        for(int i=0;i<n;i++){
            String[] command=reader.readLine().split(" ");
            switch (command[0]){
                case "push":
                    stack.push(command[1]);
                    break;
                case "pop":
                    if(stack.empty()){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(stack.pop());
                    }
                    break;
                case "top":
                    if(stack.empty()){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(stack.peek());
                    }
                    break;
                case "empty":
                    if (stack.empty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
            }
        }
    }
}
