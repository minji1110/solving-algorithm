package Programmers.BFS_DFS;

public class 네트워크 {
        static boolean[] visited;
        static int n=3;
        static int[][] computers={{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    public static void main(String[] args) {
        int answer = 0;
        visited=new boolean[n];

        for(int v=0;v<n;v++){
            if(!visited[v]){
                answer+=1;
                DFS(computers,v,n);
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int[][] computers, int v, int n){
        visited[v]=true;
        for(int i=0;i<n;i++){
            if(!visited[i] && computers[v][i]==1){
                visited[i]=true;
                DFS(computers,i,n);
            }
        }
    }
}
