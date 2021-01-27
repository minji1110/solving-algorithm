package Programmers.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length=100;
        int weight=100;
        int[] truck_weights={10,10,10,10,10,10,10,10,10,10};

        int answer=new Solution().solution(bridge_length,weight,truck_weights);
        System.out.println(answer);
    }
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int totalWeight=0;
            Queue<Integer> queue=new LinkedList<>();

            for (int truck : truck_weights) {
                while(true){
                    if(queue.isEmpty()){
                        queue.add(truck);
                        totalWeight+=truck;
                        answer++;
                        break;
                    }
                    else if(queue.size()==bridge_length){
                        totalWeight-=queue.poll();
                    }
                    else{
                        if(totalWeight+truck>weight){
                            queue.add(0);
                            answer++;
                        }
                        else{
                            queue.add(truck);
                            totalWeight+=truck;
                            answer++;
                            break;
                        }
                    }
                }
            }

            return answer+bridge_length;
        }
    }
}
