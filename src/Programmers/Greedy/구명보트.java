package Programmers.Greedy;

import java.util.Arrays;

public class 구명보트 {
    static int[] people=new int[]{50,160,150,40};
    static int limit=200;

    public static void main(String[] args) {
        int answer = 0; //사용될 구명보트의 수
        int left=0;
        int right=people.length-1;

        Arrays.sort(people);

        while(left<right){
            //둘이 같이 탈 수 있음
            if(people[left]+people[right]<=limit){
                answer++;
                left++;
                right--;
            }
            //무게 초과
            else{
                answer++;
                right--;
            }
        }
        if(left==right) answer++;

        System.out.println("answer = " + answer);
    }
}
