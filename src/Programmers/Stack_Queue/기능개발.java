package Programmers.Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses={93,30,55};
        int[] speeds={1,30,5};
        int[] answer=new Solution().solution(progresses,speeds);
        for (int i : answer) {
            System.out.println(i);
        }
    }
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] required=new int[progresses.length];
            requiredDuration(required,progresses,speeds);

            List<Integer> list=new ArrayList<>();
            Stack<Integer> stack=new Stack<>();

            int cnt=1;
            stack.push(required[0]);

            for(int i=1;i<required.length;i++){
                if(stack.peek()>=required[i]) cnt++;
                else{
                    stack.pop();
                    list.add(cnt);
                    stack.add(required[i]);
                    cnt=1;
                }
            }
            list.add(cnt);
            int[] answer=new int[list.size()];
            for(int i=0;i<list.size();i++){
                answer[i]=list.get(i);
            }
            return answer;
        }

        private void requiredDuration(int[] required, int[] progresses, int[] speeds) {
            for(int i=0;i<required.length;i++){
                int toDo=100-progresses[i];
                int requiredTime= (int) Math.ceil((double)toDo/speeds[i]);
                required[i]=requiredTime;
            }
        }
    }
}
