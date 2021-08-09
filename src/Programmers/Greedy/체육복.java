package Programmers.Greedy;

import java.util.Arrays;

public class 체육복 {
    static int n=5;
    static int[] lost={2,4};
    static int[] reserve={1,3,5};

    public static void main(String[] args) {
        boolean[] complete=new boolean[reserve.length];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int possible=n-lost.length;

        for(int l=0;l<lost.length;l++){
            boolean borrowed=false;
            for(int r=0;r<reserve.length;r++){
                if(!complete[r] && Math.abs(lost[l]-reserve[r])==1) {
                    possible++;
                    complete[r] = true;
                    borrowed=true;
                }
                else if(lost[l]==reserve[r]){
                    if(!complete[r]){
                        if(!borrowed){
                            possible++;
                            borrowed=true;
                        }
                        complete[r]=true;
                    }
                    break;
                }
                else if(borrowed)break;
            }
        }
        System.out.println(possible);
    }
}
