package BFS_DFS;

import java.io.*;

public class 알파벳_1987 {
    static boolean[] alphabet=new boolean[26];
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int rows,columns,answer=0;
    static char[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        rows=Integer.parseInt(input[0]);
        columns=Integer.parseInt(input[1]);

        list=new char[rows][columns];

        for(int r=0;r<rows;r++){
            String row=br.readLine();
            for(int c=0;c<columns;c++){
                list[r][c]=row.charAt(c);
            }
        }

        DFS(0,0,1);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

        private static void DFS(int nowX, int nowY,int cnt) {
            char thisAlphabet=list[nowX][nowY];

            alphabet[thisAlphabet-'A']=true;
            if(answer<cnt) answer=cnt;

            for(int xy=0;xy<4;xy++){
                int nextX=nowX+dx[xy];
                int nextY=nowY+dy[xy];
                if(nextX<0 || rows<=nextX)
                    continue;
                if(nextY<0 || columns<=nextY)
                    continue;

                char nextAlphabet=list[nextX][nextY];
                if(!alphabet[nextAlphabet-'A']){
                    DFS(nextX,nextY,cnt+1);
                    alphabet[nextAlphabet-'A']=false;
                }
            }

        }
}
