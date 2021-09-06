package Programmers.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    static int[][] routes={{1,8},{2,7},{3,6},{4,5}};

    public static void main(String[] args) {
        int answer=1;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[0]));

        int prevEnd=routes[0][1];
        int start,end;
        for(int i=1;i<routes.length;i++){
            start=routes[i][0];
            end=routes[i][1];

            if(start<end&&end<prevEnd){
                prevEnd=end;
            }
            else if(prevEnd<start){
                prevEnd=end;
                answer++;
            }
        }
        System.out.println("answer = " + answer);
    }
}
