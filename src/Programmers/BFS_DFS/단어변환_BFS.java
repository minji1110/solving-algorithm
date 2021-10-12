package Programmers.BFS_DFS;

import java.util.*;

public class 단어변환_BFS {
    public static void main(String[] args) {
        int answer=0;
        String begin="hit";
        String target="cog";
        String[] words={"hot", "dot", "dog", "lot", "log"};

        class Vertex{
            String str;
            int depth;

            public Vertex(String str, int depth){
                this.str=str;
                this.depth=depth;
            }
        }


        Queue<Vertex> queue=new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Vertex(begin,0));

        while(!queue.isEmpty()){
            Vertex v=queue.poll();

            if(v.str.equals(target)) {
                answer=v.depth;
                break;
            }

            for(int i=0;i<words.length;i++){
                if(!visited[i] && isAdjacent(v.str, words[i])){
                    visited[i]=true;
                    queue.add(new Vertex(words[i],v.depth+1));
                }
            }
        }

        System.out.println("answer = " + answer);
    }

    private static boolean isAdjacent(String str, String word) {
        int diff=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=word.charAt(i)) diff++;
            if(diff>1) break;
        }
        return diff==1;
    }
}
