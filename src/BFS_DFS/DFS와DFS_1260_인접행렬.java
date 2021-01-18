package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와DFS_1260_인접행렬 {

    public static int[][] matrix;
    public static int n;
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input=br.readLine().split(" " );
        n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        int s=Integer.parseInt(input[2]);

        matrix=new int[n+1][n+1];
        initMatrix();

        for(int i=0;i<m;i++){
            String[] adjacent=br.readLine().split(" ");
            int a=Integer.parseInt(adjacent[0]);
            int b=Integer.parseInt(adjacent[1]);
            matrix[a][b]=matrix[b][a]=1;
        }

        boolean[] dfsVisited=new boolean[n+1];
        boolean[] bfsVisited=new boolean[n+1];

        dfs(dfsVisited,s);
        bw.newLine();
        bfs(bfsVisited,s);

        bw.flush();
        bw.close();
    }

    private static void dfs(boolean[] dfsVisited,int v) throws IOException {
            dfsVisited[v]=true;
            bw.write(v+" ");

            for(int i=1;i<n+1;i++) {
                if (matrix[v][i] == 1 && !dfsVisited[i]) {
                    dfs(dfsVisited,i);
                }
            }
    }

    private static void bfs(boolean[] bfsVisited,int s) throws IOException {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        bfsVisited[s]=true;

        while(!queue.isEmpty()){
            int v=queue.poll();
            bw.write(v+" ");

            for (int i=1;i<n+1;i++) {
                if(matrix[v][i]==1 && !bfsVisited[i]){
                    queue.add(i);
                    bfsVisited[i]=true;
                }
            }
        }
    }

    private static void initMatrix() {
        for (int i=0;i<=n;i++)
            for (int j=0;j<=n;j++)
                matrix[i][j]=0;
    }
}
