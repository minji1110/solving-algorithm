package Programmers.Hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    static String[] participant=new String[]{"marina", "josipa", "nikola", "filipa", "filipa"};
    static String[] completion=new String[]{"josipa", "filipa", "marina", "nikola"};

    public static void main(String[] args) {
        String answer="";

        Map<String,Integer> map=new HashMap<>();
        for(String name:participant){
            if(map.get(name)==null) map.put(name,1);
            else map.put(name,map.get(name)+1);
        }

        for(String part:completion)
            if(map.get(part)!=null) map.put(part,map.get(part)-1);

        for(String name:map.keySet())
            if(map.get(name)==1) answer=name;

        System.out.println("answer = " + answer);

//시간초과
//        String toArray=Arrays.toString(participant);
//        for(int i=0;i<completion.length;i++){
//            toArray=toArray.replaceFirst(completion[i],"" );
//        }
//        answer=toArray.replaceAll("[,\\[\\]\\s]","");
    }
}
