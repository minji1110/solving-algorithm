package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최단경로_1753 {
    static final Integer INF = 987654321;
    static boolean[] visited;
    static List<Node>[] adjacentList;
    static int[] shortCuts;
    static PriorityQueue<Node> pq;

    public static class Node implements Comparable<Node>{
        int index;
        int weight;
        public Node(int index,int weight){
            this.index=index;
            this.weight=weight;
        }
        @Override
        public int compareTo(Node node) {
            return this.weight-node.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        int v=Integer.parseInt(input[0]);
        int e=Integer.parseInt(input[1]);
        int s=Integer.parseInt(br.readLine());

        visited=new boolean[v+1];
        adjacentList=new List[v+1];
        for(int i=0;i<v+1;i++){
               adjacentList[i]=new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            String[] adjacent=br.readLine().split(" ");
            int a=Integer.parseInt(adjacent[0]);
            int b=Integer.parseInt(adjacent[1]);
            int weight=Integer.parseInt(adjacent[2]);
            adjacentList[a].add(new Node(b,weight));
        }

        shortCuts=new int[v+1];
        Arrays.fill(shortCuts,INF);
        shortCuts[s]=0;

        pq=new PriorityQueue<>();
        dijkstra(s);

        for(int i=1;i<v+1;i++){
            if(shortCuts[i]==INF)
                bw.write("INF\n");
            else
                bw.write(shortCuts[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start) {
        pq.add(new Node(start,0));
        visited[start]=true;

        while(!pq.isEmpty()){
            Node v=pq.poll();
            for(Node u:adjacentList[v.index]) {
                if(!visited[u.index])
                visited[u.index] = true;
                relaxation(v,u,u.weight);
            }
        }
    }

    private static void relaxation(Node v, Node u, int weight) {
        if(shortCuts[u.index]>shortCuts[v.index]+weight){
            shortCuts[u.index]=shortCuts[v.index]+weight;
            pq.add(new Node(u.index,shortCuts[u.index]));
        }
    }
}
