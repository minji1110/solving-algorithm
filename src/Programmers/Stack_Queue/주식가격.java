package Programmers.Stack_Queue;

import java.util.Stack;

public class 주식가격 {
    public static class Pair{
        int number;
        int index;
        Pair(int number,int index){
            this.number=number;
            this.index=index;
        }
    }

    public static void main(String[] args) {
        int[] prices={1,2,3,2,3};
        int[] answer=new Solution().solution(prices);
        for (int i : answer) {
            System.out.println(i);
        }
    }
    static class Solution {
        public int[] solution(int[] prices) {
            Stack<Pair> stack=new Stack<>();
            int[] answer = new int[prices.length];

            for(int i=0;i<prices.length;i++){
                int newNum=prices[i];

                while(!stack.isEmpty()&&stack.peek().number>newNum){
                    Pair popped=stack.pop();
                    answer[popped.index]=i-popped.index;
                }
                stack.push(new Pair(newNum,i));
            }

            while(!stack.isEmpty()){
                Pair popped=stack.pop();
                answer[popped.index]=prices.length-popped.index-1;
            }
            return answer;
        }
    }
}
