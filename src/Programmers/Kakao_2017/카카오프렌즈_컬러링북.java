package Programmers.Kakao_2017;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        int[][] picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] picture = new int[][]{{0,1,0}, {1, 1,0}, {0,0,0}};
        int[] answer = solution.solution(3,3,picture);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    static class Solution {
        class Node{
            int x;
            int y;
            int color;
            public Node(int x, int y, int color){
                this.x=x;
                this.y=y;
                this.color=color;
            }
        }

        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            Queue<Node> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];

            int sizeOfArea;
            for(int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if(!visited[i][j] && picture[i][j]!=0){
                        //System.out.println("i="+i+", j="+j);
                        numberOfArea++;
                        queue.add(new Node(i,j,picture[i][j]));
                        visited[i][j]=true;
                        sizeOfArea=BFS(queue, visited,picture, m, n);
                        if(sizeOfArea>maxSizeOfOneArea) maxSizeOfOneArea=sizeOfArea;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        private int BFS(Queue<Node> queue, boolean[][] visited, int[][] picture, int m, int n) {
            //오, 아래, 왼,
            int[] dx = {0,1,0};
            int[] dy = {1,0,-1};
            int sizeOfArea=0;

            while (!queue.isEmpty()) {
                Node now=queue.poll();
                //System.out.println("x="+now.x+", y="+now.y);
                sizeOfArea++;

                for (int i = 0; i < 3; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];
                    int nextColor;

                    if(isValid(m, n, nextX, nextY)) {
                        nextColor = picture[nextX][nextY];
                        if (!visited[nextX][nextY] && now.color == nextColor) {
                            queue.add(new Node(nextX, nextY, nextColor));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
            return sizeOfArea;
        }

        private boolean isValid(int m, int n,int nextX, int nextY) {
            return 0<=nextX&& 0<=nextY && nextX<m && nextY<n;
        }
    }
}
