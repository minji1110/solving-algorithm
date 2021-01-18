package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 경로찾기_11403 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] matrix;
    static int[][] pathList;
    static Queue<Integer> queue=new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(br.readLine());
        visited=new boolean[n][n];
        pathList=new int[n][n];

        initMatrix();
        for(int i=0;i<n;i++){
            findPath(i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                bw.write(pathList[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void findPath(int start) {
        queue.add(start);
        while(!queue.isEmpty()){
            int v=queue.poll();
            for(int u=0;u<n;u++) {
                if (matrix[v][u]==1 && !visited[start][u]){
                    visited[start][u]=true;
                    queue.add(u);
                    pathList[start][u]=1;
                }
            }
        }
    }

    private static void initMatrix() throws IOException {
        matrix=new int[n][n];
        for(int i=0;i<n;i++){
            String[] row=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                matrix[i][j]=Integer.parseInt(row[j]);
            }
        }
    }
}
