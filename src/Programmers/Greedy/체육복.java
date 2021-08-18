package Programmers.Greedy;

import java.util.Arrays;

public class 체육복 {
    static int n=5;
    static int[] lost={2,4};
    static int[] reserve={1,3,5};

    public static void main(String[] args) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int possible=n-lost.length;


        //겹치는 번호 삭제하기
        for (int l=0;l<lost.length;l++) {
            for (int r=0;r<reserve.length;r++) {
                if(lost[l]==reserve[r]){
                    possible++;
                    lost[l]=-1;
                    reserve[r]=-1;
                }
            }
        }

        for(int l=0;l<lost.length;l++){
            for(int r=0;r<reserve.length;r++){
                if(Math.abs(lost[l]-reserve[r])==1) {
                    possible++;
                    reserve[r]=-1;
                    break;
                }
            }
        }
        System.out.println(possible);
    }
}
