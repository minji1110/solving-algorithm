package Programmers.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public static class Printer{
        int index;
        int priority;

        Printer(int index,int priority){
            this.index=index;
            this.priority=priority;
        }
    }

    public static void main(String[] args) {
        int[] priorities={1,2,3,4};
        int location=3;
        int answer=new Solution().solution(priorities,location);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = priorities.length;
            Queue<Printer> queue=new LinkedList<>();

            for(int i=0;i<priorities.length;i++){
                queue.add(new Printer(i,priorities[i]));
            }

            while(!queue.isEmpty()) {
                boolean isBiggest=true;
                Printer top = queue.peek();
                for (Printer printer : queue) {
                    if (printer.priority > top.priority) {  //더 큰 중요도 존재
                        queue.add(queue.poll());
                        isBiggest=false;
                        break;
                    }
                }
                if(isBiggest) {
                    Printer popped = queue.poll();
                    if (location == popped.index) {
                        return priorities.length - queue.size();
                    }
                }
            }
            return answer;
        }
    }
}
