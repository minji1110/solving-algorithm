package Programmers.Sorting;

import java.util.Arrays;

public class k번째수 {
    static int[] array={1,5,2,6,3,7,4};
    static int[][] commands={{2,5,3},{4,4,1},{1,7,3}};

    public static void main(String[] args) {
        int[] answer={};
        answer=new int[commands.length];
        int[] tmp;
        int left,right,k;

        for(int i=0;i< commands.length;i++){
            left=commands[i][0]-1;
            right=commands[i][1];
            k=commands[i][2]-1;

            tmp= Arrays.copyOfRange(array,left,right);
            Arrays.sort(tmp);

            answer[i]=tmp[k];
        }
    }
}
