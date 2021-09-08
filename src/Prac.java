import java.util.Arrays;
import java.util.Comparator;

public class Prac {
    public static void main(String[] args) {
        int[] intArray={1,5,2,3,4};
        int[][] intArray2={{1,2},{1,5},{1,4},{1,3},{1,1}};
        String[] strArray={"blue","apple","cat"};

        System.out.println("============1차원 배열 오름차순============");
        Arrays.sort(intArray);
        for (int i : intArray) System.out.println(i);

        System.out.println("============2차원 배열 2번째 원소 기준============");
        Arrays.sort(intArray2, Comparator.comparingInt(i->i[1]));
        for(int i[] :intArray2) System.out.println(i[0]+" , " + i[1]);

        System.out.println("============문자열 오름차순============");
        Arrays.sort(strArray);
        for (String s : strArray) System.out.println(s);

        System.out.println("===========문자열 길이순============");
        Arrays.sort(strArray,Comparator.comparing(String::length));
        for (String s : strArray) System.out.println(s);

        System.out.println("===========문자열 길이 역순============");
        Arrays.sort(strArray,Comparator.comparing(String::length).reversed());
        for (String s : strArray) System.out.println(s);


        //사용자 정의 정렬
        strArray= new String[]{"bbb","aac","aaz","aaw","aaa"};

        Comparator<String> comparator= (s1, s2) -> {
            //첫글자가 같으면 마지막글자로 비교
            if(s1.charAt(0)==s2.charAt(0)){
                if(s1.charAt(s1.length()-1)>s2.charAt(s2.length()-1)) return 1;
                else return -1;
            }
            else return s1.charAt(0)>s2.charAt(0)?1:-1;
        };

        System.out.println("===========사용자정의 순서============");
        Arrays.sort(strArray,comparator);
        for (String s : strArray) System.out.println(s);
    }
}
