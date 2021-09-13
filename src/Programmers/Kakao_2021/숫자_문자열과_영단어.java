package Programmers.Kakao_2021;

import java.util.HashMap;
import java.util.Map;

public class 숫자_문자열과_영단어 {
    static String s="threefourfivesixseven";

    public static void main(String[] args) {
        Map<String,Integer> pair=new HashMap<>();
        pair.put("zero",0);
        pair.put("one",1);
        pair.put("two",2);
        pair.put("three",3);
        pair.put("four",4);
        pair.put("five",5);
        pair.put("six",6);
        pair.put("seven",7);
        pair.put("eight",8);
        pair.put("nine",9);

        int answer=0;
        String answer_s="";

        int i=0;
        int j=0;
        String num_s="";

        while(i<s.length()){
            j=i+1;
            if(isInt(s.charAt(i))){
                answer_s+=s.charAt(i);
                i++;
            }
            else{
                while(j<s.length() && !isInt(s.charAt(j))){
                    num_s=s.substring(i,j+1);
                    if(pair.get(num_s)!=null) break;
                    else j++;
                }
                answer_s+=pair.get(num_s);
                i=j+1;
            }
        }

        answer=Integer.parseInt(answer_s);
        System.out.println("answer = " + answer);
    }

    public static boolean isInt(char c){
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
