package BFS_DFS;

import java.io.*;
import java.util.*;

public class 단지번호붙이기_2667 {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,1,-1};
    static int n,totalCnt;
    static boolean[][] visited;
    static int[][] matrix;
    static Queue<Pair> queue=new LinkedList<>();
    static int[] cntList=new int[25*25];

    static class Pair {
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(br.readLine());
        initMatrix();
        visited=new boolean[n][n];

        totalCnt=0;
        for(int x=0;x<n;x++){
            for (int y=0;y<n;y++){
                if(!visited[x][y]&&matrix[x][y]==1) {
                    bfs(x, y);
                    totalCnt += 1;
                }
            }
        }

        Arrays.sort(cntList);
        bw.write(totalCnt+"\n");
        for (int c=cntList.length-totalCnt;c<cntList.length;c++)
            bw.write(cntList[c]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y){
        int cnt=1;
        queue.add(new Pair(x,y));
        visited[x][y]=true;

        while(!queue.isEmpty()){
            Pair pair=queue.poll();

            for(int xy=0;xy<4;xy++){
                int nextX=pair.x+dx[xy];
                int nextY=pair.y+dy[xy];
                if(nextX<0||nextX>=n||nextY<0||nextY>=n)
                    continue;
                if(!visited[nextX][nextY]&&matrix[nextX][nextY]==1){
                    visited[nextX][nextY]=true;
                    queue.add(new Pair(nextX,nextY));
                    cnt+=1;
                }
            }
        }
        cntList[totalCnt]=cnt;
    }

    private static void initMatrix() throws IOException {
        matrix = new int[n][n];

        for (int x = 0; x < n; x++) {
            String[] row = br.readLine().split("");
            for (int y = 0; y < n; y++)
                matrix[x][y] = Integer.parseInt(row[y]);
        }
    }

}
