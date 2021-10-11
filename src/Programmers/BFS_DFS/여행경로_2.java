package Programmers.BFS_DFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class 여행경로_2 {
    static String[][] tickets={{"ICN", "aaa"}, {"ICN", "bbb"}, {"bbb", "ICN"}};
//    static String[][] tickets={{"ICN", "a"}, {"a", "b"}, {"a", "c"},{"c","a"},{"b","d"}};
//    static String[][] tickets={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    public static void main(String[] args) {
        String[] answer = new String[tickets.length+1];
        boolean[] visited=new boolean[tickets.length];

        Comparator<String[]> comparator=(ticket1, ticket2)->{
            if(ticket1[0].equals(ticket2[0]))
                return ticket1[1].compareTo(ticket2[1]);
            else return ticket1[0].compareTo(ticket2[0]);
        };

        Arrays.sort(tickets, comparator);

        for(int i=0;i<tickets.length;i++){
            String[] ticket = tickets[i];

            if(ticket[0].equals("ICN")){
                answer[0]="ICN";
                DFS(tickets,visited,answer,i,1);
                if(answer[tickets.length]!=null) break;
                reset(visited);
            }
        }

        for (String s : answer) {
            System.out.println("s = " + s);
        }
    }

    static private void DFS(String[][] tickets, boolean[] visited,String[] answer,int index, int cnt){
//        System.out.println("ticket[0] = " + tickets[index][0]+", ticket[1]= "+tickets[index][1]+", cnt= "+cnt);
        answer[cnt]=tickets[index][1];
        visited[index] = true;

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && isRouteExist(tickets[index],tickets[i])){
                DFS(tickets, visited, answer, i,cnt+1);
                if(answer[tickets.length]!=null) break;
                visited[i]=false;
                answer[cnt+1]=null;
            }
        }
    }

    static private boolean isRouteExist(String[] now, String[] next){
        return now[1].equals(next[0]);
    }

    static private void reset(boolean[] visited){
        for(int i=0;i<visited.length;i++) visited[i]=false;
    }
}
