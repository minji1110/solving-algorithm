package Programmers.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        int n=6;
        int[][] edge = new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        Solution solution=new Solution();
        int answer=solution.solution(n,edge);
        System.out.println("answer = " + answer);
    }

    static class Solution {

        static class Vertex{
            int index;
            int edge;

            Vertex(int index, int edge){
                this.index=index;
                this.edge=edge;
            }
        }

        public int solution(int n, int[][] edge) {
            int answer = 0;
            boolean[][] adjacent = new boolean[n+1][n+1];
            boolean[] visited = new boolean[n+1];
            Queue<Vertex> queue= new LinkedList<>();

            for(int i=0;i<edge.length;i++){
                adjacent[edge[i][0]][edge[i][1]] = adjacent[edge[i][1]][edge[i][0]]= true;
            }

            int maxEdge=0;
            queue.add(new Vertex(1,0));
            visited[1]=true;

            while(!queue.isEmpty()){
                Vertex v=queue.poll();

                if(v.edge>maxEdge) {
                    maxEdge=v.edge;
                    answer=0;
                }
                if(v.edge==maxEdge) answer++;

                for(int i=1;i<n+1;i++){
                    if(!visited[i] && adjacent[v.index][i]){
                        queue.add(new Vertex(i,v.edge+1));
                        visited[i]=true;
                    }
                }
            }
            return answer;
        }
    }
}
