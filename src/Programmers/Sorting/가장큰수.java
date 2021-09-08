package Programmers.Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    static int[] numbers={30,303};
    public static void main(String[] args) {
        String answer="";
        int[][] pairs=new int[numbers.length][2];
        int digit;
        String lastNum;
        String numToStr;

        for(int n=0;n< numbers.length;n++){
            pairs[n][0]=numbers[n];
            numToStr=String.valueOf(numbers[n]);
            digit=numToStr.length();    //자릿수
            lastNum= String.valueOf(numToStr.charAt(0));   //일의자리 숫자

            if(digit==1) pairs[n][1]=Integer.parseInt(numToStr+lastNum+lastNum);
            else if(digit==2) pairs[n][1]=Integer.parseInt(numToStr+lastNum);
            else pairs[n][1]= Integer.parseInt(numToStr);
        }

        for (int[] pair : pairs) {
            System.out.println("pair[1] = " + pair[1]);
        }

        Arrays.sort(pairs, Comparator.comparing(a->-a[1]));

        for (int[] pair : pairs)
            answer+=pair[0];

        if(answer.equals("00")||answer.equals("000"))
            answer="0";

        System.out.println("answer = " + answer);
    }
}
