package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack=new Stack<>();

        int cnt=0;
        int bars=0; //겹쳐진 쇠막대 수

        String input=reader.readLine();
        for(int i=0;i<input.length();i++){
            stack.push(input.charAt(i));
        }

        char prev=')';
        while(!stack.empty()){
            if(stack.pop()==')'){
                    bars+=1;
                    prev=')';
            }
            else{
                bars-=1;
                if(prev==')'){  // 레이저
                    cnt+=bars;
                }
                else{           //막대끝
                    cnt+=1;
                }
                prev='(';
            }
        }
        System.out.println(cnt);
    }
}
