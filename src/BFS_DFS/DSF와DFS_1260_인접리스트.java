package BFS_DFS;

import java.io.*;
import java.util.*;

public class DSF와DFS_1260_인접리스트 {

    public static List<Integer>[] adjacentList;
    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input=br.readLine().split(" " );
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        int s=Integer.parseInt(input[2]);

        adjacentList=new List[n+1];
        for(int i=0;i<n+1;i++){
            adjacentList[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            String[] adjacent=br.readLine().split(" ");
            int a=Integer.parseInt(adjacent[0]);
            int b=Integer.parseInt(adjacent[1]);
            adjacentList[a].add(b);
            adjacentList[b].add(a);
        }

        for(List<Integer> integers:adjacentList) Collections.sort(integers);

        bfsVisited=new boolean[n+1];
        dfsVisited=new boolean[n+1];

        dfs(dfsVisited,s);
        bw.newLine();
        bfs(bfsVisited,s);

        bw.flush();
        bw.close();

    }

    private static void bfs(boolean[] bfsVisited, int s) throws IOException {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        bfsVisited[s]=true;

        while(!queue.isEmpty()){
            int v=queue.poll();
            bw.write(v+" ");
            for (Integer u : adjacentList[v]) {
                if(bfsVisited[u]==false){
                    bfsVisited[u]=true;
                    queue.add(u);
                }
            }
        }
    }

    private static void dfs(boolean[] dfsVisited, int v) throws IOException {
        dfsVisited[v]=true;
        bw.write(v+" ");
        for(Integer u : adjacentList[v]){
            if(dfsVisited[u]==false){
                dfs(dfsVisited,u);
            }
        }
    }
}
