package Stack;

import java.io.*;
import java.util.Stack;

public class 크게만들기_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);   //n 자리수
        int k=Integer.parseInt(input[1]);   //k개 삭제
        String number=br.readLine();

        Stack<Integer> stack = new Stack<>();   //스택의 수는 내림차순이어야

        int i=0;
        for(i=0;i<n;i++) {
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            while (k > 0 && !stack.isEmpty()) {
                if (stack.peek() >= num) {
                    break;
                } else {
                    stack.pop();
                    k--;
                }
            }
            stack.push(num);
        }

        for(int s=0;s<stack.size()-k;s++)
           bw.write(stack.get(s).toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
