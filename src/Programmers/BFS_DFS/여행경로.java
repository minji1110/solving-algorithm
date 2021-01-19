package Programmers.BFS_DFS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {

    static boolean[] checked;
    static List<String> answerList = new ArrayList<>();
    static String str="";

    public static void main(String[] args) {
//        String[][] tickets={{"ICN", "aaa"}, {"ICN", "bbb"}, {"bbb", "ICN"}};
        String[][] tickets={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] tickets={{"ICN", "aaa"}, {"ICN", "ccc"}, {"ccc", "vvv"}, {"vvv","ICN"}};
        String[] answer=new Solution().solution(tickets);
        for (String a : answer) {
            System.out.println(a);
        };
    }

    public static class Solution{
        public String[] solution(String[][] tickets) {
            checked = new boolean[tickets.length];

            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i][0].equals("ICN")) {
                    str = "ICN";
                    DFS(tickets, i);
                }
                for (int c = 0; c < checked.length; c++)
                    checked[c] = false;
            }

            for(String s:answerList)
                System.out.println(s);
            Collections.sort(answerList);
            String[] answer = answerList.get(0).split(",");

        return answer;
        }
    }

    private static void DFS(String[][] tickets, int i) {
        checked[i]=true;
        str += ","+tickets[i][1];

        if(str.split(",").length==tickets.length+1) {
            answerList.add(str);
        }
        for(int next=0;next<tickets.length;next++){
            if(!checked[next] && tickets[i][1].equals(tickets[next][0])) {
                DFS(tickets, next);
                checked[next]=false;
                str=str.substring(0,str.length()-4);
            }
        }
    }
}
