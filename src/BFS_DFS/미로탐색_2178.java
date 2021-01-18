package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색_2178 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int totalRows,totalColumns;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,1,-1};

    private static class Pair {
        int row;
        int column;
        public Pair(int row,int column){
            this.row=row;
            this.column=column;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] input=br.readLine().split(" ");
        totalRows=Integer.parseInt(input[0]);
        totalColumns = Integer.parseInt(input[1]);

        initMatrix();

        bfs();
        bw.write(String.valueOf(matrix[totalRows][totalColumns]));

        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs() throws IOException {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1,1));

        visited=new boolean[totalRows+1][totalColumns+1];
        visited[1][1]=true;


        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            if(pair.row==totalRows&&pair.column==totalColumns)
                break;

            for(int xy=0;xy<4;xy++){
                int row=pair.row+dx[xy];
                int column=pair.column+dy[xy];

                if(row<1||row>totalRows||column<1||column>totalColumns)
                    continue;
                if(visited[row][column]||matrix[row][column]==0)
                    continue;

                visited[row][column]=true;
                matrix[row][column]=matrix[pair.row][pair.column]+1;
                queue.add(new Pair(row,column));

            }
        }
    }

    private static void initMatrix() throws IOException {
        matrix=new int[totalRows+1][totalColumns+1];
        for(int row=1;row<=totalRows;row++){
            String[] line=br.readLine().split("");
            for(int column=1;column<=totalColumns;column++){
                matrix[row][column]=Integer.parseInt(line[column-1]);
            }
        }
    }

}
