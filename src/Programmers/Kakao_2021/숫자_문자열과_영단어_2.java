package Programmers.Kakao_2021;

public class 숫자_문자열과_영단어_2 {
    static String s="1three5seven9";
    public static void main(String[] args) {
        int answer=0;
        String[] int_num={"0","1","2","3","4","5","6","7","8","9"};
        String[] str_num={"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0;i<10;i++){
            s=s.replaceAll(str_num[i],int_num[i]);
        }

        answer=Integer.parseInt(s);
        System.out.println("answer = " + answer);
    }
}
