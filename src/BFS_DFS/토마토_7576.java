package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7576 {
    //오,왼,위,아래
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,1,-1};

    static class Node{
        int a;
        int b;
        int days;
        Node(int a,int b,int days){
            this.a=a;
            this.b=b;
            this.days=days;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String input[] = bufferedReader.readLine().split(" ");

        int col=Integer.parseInt(input[0]);
        int row=Integer.parseInt(input[1]);

        //인접행렬 생성
        int[][] matrix= new int[row][col];

        for(int i=0;i<row;i++){
            input= bufferedReader.readLine().split(" ");
            for(int j=0;j<col;j++){
                matrix[i][j]=Integer.parseInt(input[j]);
            }
        }

        if(isComplete(matrix,row,col)) System.out.println("0");
        else BFS(matrix,row,col);
    }

    private static boolean isComplete(int[][] matrix,int row,int col) {
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    private static void BFS(int[][] matrix,int row,int col) {
        int days=0;
        boolean flag=false;
        Queue<Node> queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==1){
                    queue.add(new Node(i,j,0));
                }
            }
        }

        while(!queue.isEmpty()){
            Node node=queue.poll();

            for(int i=0;i<4;i++){
                int adjacentA=node.a+dx[i];
                int adjacentB=node.b+dy[i];

                if(isAdjacent(adjacentA,adjacentB,row,col,matrix)){
                    matrix[adjacentA][adjacentB]=1;
                    queue.add(new Node(adjacentA,adjacentB,node.days+1));
                }
            }

            days=node.days;
        }

        if(isComplete(matrix,row,col)) System.out.println(days);
        else System.out.println("-1");
    }

    private static boolean isAdjacent(int a,int b,int row,int col, int[][] matrix){
        return (0<=a && a<row) && (0<=b && b<col) && (matrix[a][b]==0);
    }

    private static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
