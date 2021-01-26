package Programmers.BFS_DFS;

import java.util.Arrays;

public class 단어변환 {
    static boolean[] visited;
    static int wordLen;
    static int answer;

    public static void main(String[] args) {
        String begin="hit";
        String target = "cog";
        String[] words={"hot", "dot", "dog", "lot", "log","cog"};

        answer=51;
        wordLen=words[0].length();

        if(!Arrays.stream(words).anyMatch(word->word.equals(target))){
            System.out.println("0");
            return;
        }
        for(int i=0;i<words.length;i++){
            visited=new boolean[words.length];

            if(possibleToChange(begin,words[i])){
                visited[i]=true;
                DFS(words,i,1,target);
            }
        }

        if(answer==51) answer=0;
        System.out.println(answer);
    }

    private static void DFS(String[] words, int i,int shortCut ,String target) {
        if(words[i].equals(target)){
            answer=Math.min(answer,shortCut);
            return;
        }

        for(int v=0;v<words.length;v++){
            if(!visited[v] && possibleToChange(words[i],words[v])){
                visited[v]=true;
                DFS(words,v,shortCut+1,target);
                visited[v]=false;
            }
        }
    }

    private static boolean possibleToChange(String begin,String end) {
        int notMatched=0;
        for(int i=0;i<wordLen&&notMatched<2;i++){
            if(begin.charAt(i)!=end.charAt(i)) {
                notMatched++;
            }
        }
        return notMatched==1;
    }
}
