package Programmers.BFS_DFS;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    static boolean[] visited;
    static int[] shortCut;
    static Queue<Integer> queue = new LinkedList<>();
    static int wordLen;

    public static void main(String[] args) {
        String begin="hit";
        String target = "cog";
        String[] words={"hot", "dot", "dog", "lot", "log","cog"};

        visited=new boolean[words.length];
        shortCut=new int[words.length];

        int answer=100;
        wordLen=words[0].length();

        if(!Arrays.stream(words).anyMatch(word->word==target)){
            System.out.println("0");
            return;
        }
        for(int i=0;i<words.length;i++){
            if(possibleToChange(begin,words[i])){
                int cnt=BFS(words,i,target);
                if(cnt>0 && answer>cnt) answer=cnt;
            }
            for(boolean bool:visited)
                bool=false;
            for(int s:shortCut)
                s=0;
        }
        if(answer==100) answer=0;
        System.out.println(answer);
    }

    private static int BFS(String[] words,int i, String target) {
        queue.add(i);
        visited[i]=true;
        shortCut[i]=1;

        while(!queue.isEmpty()){
            int now=queue.poll();
            for(int v=0;v<words.length;v++){
                if(!visited[v] && possibleToChange(words[now],words[v])){
                    shortCut[v]=shortCut[now]+1;
                    visited[v]=true;
                    queue.add(v);
                    if(target==words[v]) return shortCut[v];
                }
            }
        }
        return -1;
    }

    private static boolean possibleToChange(String begin,String end) {
        int notMatched=0;
        for(int i=0;i<wordLen;i++){
            if(begin.charAt(i)!=end.charAt(i)) {
                notMatched++;
            }
        }
        return notMatched==1;
    }
}
