package Programmers.BFS_DFS;

public class 단어변환_2 {
    static int answer=51;
    public static void main(String[] args) {
//        int answer=0;
        String begin="hit";
        String target="cog";
        String[] words={"cog", "log", "lot", "dog", "dot", "hot"};

        boolean[] visited=new boolean[words.length];
        boolean[][] adjacent=new boolean[words.length][words.length];

        makeMatrix(words,adjacent);
        for(int i=0;i<words.length;i++){
            if(isAdjacent(begin, words[i])){
                reset(visited);
                DFS(words,visited, adjacent,i, target,1);
            }
        }
        if(answer==51) answer=0;
        System.out.println("answer = " + answer);
    }

    static private void DFS(String[] words,boolean[] visited, boolean[][] adjacent, int index, String target, int cnt){
        System.out.println("i = " + index+", word= "+words[index]);
        if(words[index].equals(target)) {
            if(answer>cnt) answer=cnt;
            return;
        }
        else {
            visited[index] = true;
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && (adjacent[index][i] || adjacent[i][index])){
                    DFS(words, visited, adjacent, i, target, cnt + 1);
                }
            }
        }
    }

    static private void reset(boolean[] visited){
        for(int i=0;i<visited.length;i++) visited[i]=false;
    }

    static private void makeMatrix(String[] words, boolean[][] adjacent){
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isAdjacent(words[i], words[j]))
                    adjacent[i][j]=true;
            }
        }
    }
    static private boolean isAdjacent(String s1, String s2){
        int diffCnt=0;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) diffCnt++;
            if(diffCnt>1) return false;
        }
        return diffCnt==1?true:false;
    }
}
