package Programmers.Kakao_2021;

public class 신규아이디추천 {
    static String new_id="...!@BaT#*..y.abcdefghijklm";

    public static void main(String[] args) {
        String answer="";
        answer=new_id;

        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        answer=answer.toLowerCase();
        System.out.println("1단계 후 answer = " + answer);

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        answer=answer.replaceAll("[^a-z0-9-_.]","");
        answer=answer.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]","");
        System.out.println("2단계 후 answer = " + answer);

        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        answer=answer.replaceAll("[.]+",".");
        System.out.println("3단계 후 answer = " + answer);

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        answer=answer.replaceAll("^[.]|[.]$","");
        System.out.println("4단계 후 answer = " + answer);


        //        if(answer.charAt(0)=='.') answer=answer.replaceFirst(".","");
//        if(!answer.equals("") && answer.charAt(answer.length()-1)=='.') answer=answer.substring(0,answer.length()-1);

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(answer.equals("")) answer="a";
        System.out.println("5단계 후 answer = " + answer);

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.length()>=16) answer=answer.substring(0,15);
        answer=answer.replaceAll("[.]$","");
        System.out.println("6단계 후 answer = " + answer);

        //if(!answer.equals("")&&answer.charAt(answer.length()-1)=='.') answer=answer.substring(0,answer.length()-1);

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(answer.length()<=2) {
            char lastChar=answer.charAt(answer.length()-1);
            while(answer.length()!=3){
                answer=answer+lastChar;
            }
        }
        System.out.println("7단계 후 answer = " + answer);
    }
}
