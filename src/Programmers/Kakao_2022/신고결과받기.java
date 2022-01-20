package Programmers.Kakao_2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 신고결과받기 {

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = {};
            int n=id_list.length;
            Map<String,Integer> pair=new HashMap<>();

            answer=new int[n];
            boolean[][] reportMatrix=new boolean[n][n];
            int[] reportCnt=new int[n];

            for(int i=0;i<n;i++) pair.put(id_list[i],i);

            for(int i=0;i<report.length;i++){
                String[] str=report[i].split(" ");
                int from=pair.get(str[0]);
                int to=pair.get(str[1]);

                if(!reportMatrix[from][to]){
                    reportMatrix[from][to]=true;
                    reportCnt[to]++;
                }
            }

            List<Integer> overK=new ArrayList<>();
            for(int i=0;i<n;i++) if(reportCnt[i]>=k) overK.add(i);

            for(int from=0;from<n;from++){
                int cnt=0;
                for(int to : overK) if(reportMatrix[from][to]) cnt++;
                answer[from]=cnt;
            }

            return answer;
        }
    }
}
