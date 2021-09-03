package Programmers.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 섬연결하기 {
    static int n=5;
    static int[][] costs={{0,1,2},{0,4,3},{1,4,1},{3,4,5},{2,3,4}};
    static class Edge implements Comparable<Edge>{
        int node1;
        int node2;
        int weight;

        public Edge(int node1,int node2, int weight){
            this.node1=node1;
            this.node2=node2;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge e) {
            if(weight>=e.weight) return 1;
            else return -1;
        }
    }

    static int[] parent;
    public static void main(String[] args) {
        int answer=0;
        parent=new int[n];
        int cnt=0;
        List<Edge> edgeList=new ArrayList<>();

        for (int i =0;i<n;i++)
            parent[i]=i;

        for (int[] cost : costs)
            edgeList.add(new Edge(cost[0],cost[1],cost[2]));

        Collections.sort(edgeList);

        for(Edge e:edgeList){
            if(cnt==n-1) break;
            //cycle 검사
            int p1=findParent(e.node1);
            int p2=findParent(e.node2);
            if(p1!=p2){
                //자식으로 만들기
                parent[p2]=p1;
                answer+=e.weight;
                cnt++;
            }
        }

        System.out.println("answer = " + answer);
    }

    static int findParent(int node){
        while(parent[node]!=node){
            node=parent[node];
        }
        return node;
    }
}
