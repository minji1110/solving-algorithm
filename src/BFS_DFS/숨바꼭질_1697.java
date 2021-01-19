package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질_1697 {
    static boolean[] visited;
    static int[] shortCut;
    static int[] moveTo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int k=Integer.parseInt(input[1]);
        visited=new boolean[100001];
        shortCut=new int[100001];

        BFS(n,k);
        bw.write(String.valueOf(shortCut[k]));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void BFS(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n]=true;

        while(!q.isEmpty()){
            int now=q.poll();
            if(now==k) return;

            moveTo= new int[]{now - 1, now + 1, 2 * now};

            for(int i=0;i<3;i++){
                int next=moveTo[i];
                if(0<=next && next<=100000 && !visited[next]){
                    visited[next]=true;
                    shortCut[next]=shortCut[now]+1;
                    q.add(next);
                }
            }
        }

    }
}
