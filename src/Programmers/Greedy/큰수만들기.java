package Programmers.Greedy;

public class 큰수만들기 {
    static String answer="";
    static String number="11111";
    static int k=4;

    public static void main(String[] args) {
        int kTmp=k;
        int start=0;
        int end=start+k;

        while (k>0 && start<end){
            for(int i=start+1;i<=end;i++){
                if(number.charAt(start)<number.charAt(i)){
                    k-=(i-start);
                    start=i;
                    end= Math.min(start+k,number.length()-1);
                    break;
                }
                 if(i==end){
                    //범위내에 더 큰 숫자 없음 -> 해당 자릿수는 정해지는 것
                    answer+=number.charAt(start);
                    start++;
                    end= Math.min(start+k,number.length()-1);
                    break;
                }
            }
        }

        if(k==0)
            for(int i=start;i<number.length();i++)
                answer+=number.charAt(i);

        else answer=answer.substring(0,number.length()-kTmp);
        System.out.println(answer);
    }
}
