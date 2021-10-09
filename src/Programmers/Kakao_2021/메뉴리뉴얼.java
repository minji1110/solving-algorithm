package Programmers.Kakao_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 메뉴리뉴얼 {
    static String[] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    static int[] course={2,3,4};

    public static void main(String[] args) {
        String[] answer={};
        List<String> tmp=new ArrayList<>();

        //각 order을 알파벳순 정렬
        for(int i=0;i<orders.length;i++){
            String order=orders[i];
            Arrays.sort(order.toCharArray());

            orders[i]=order;
        }
        //문자열 길이 오름차순으로 정렬
        Arrays.sort(orders, Comparator.comparing(String::length));

        String dupStr;
        for(int i=0;i<orders.length-1;i++){
            String order=orders[i];
            //나머지 각 문자열들에 대해 겹치는 메뉴 검사
            for(int j=i+1;j<orders.length;j++){
                dupStr="";
                String other=orders[j];

                for(int k=0;k<order.length();k++){
                    char menu=order.charAt(k);
                    if(other.contains(menu+"")) dupStr+=menu;
                }

                if(dupStr.length()>=2) tmp.add(dupStr);
//                System.out.println("order = " + order+", other= "+other+", 공통메뉴= "+dupStr);
            }
        }

        for (String s : tmp) {
            System.out.println("s = " + s);
        }
//        System.out.println("answer = " + answer);
    }

}
