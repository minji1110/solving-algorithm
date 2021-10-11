package Programmers.BFS_DFS;

public class 타켓넘버 {
    static int[] numbers=new int[]{1,1,1,1,1};
    static int target=3;

    public static void main(String[] args) {
        int answer=0;
        DFS(numbers,target,0,0, answer);
        System.out.println(answer);
        }

    private static void DFS(int[] numbers, int target, int now, int sum, int answer) {
        if (now >= numbers.length) {
            if (target == sum){ answer += 1;}
            return;
        }
        DFS(numbers,target, now+1,sum+numbers[now], answer);
        DFS(numbers,target, now+1,sum-numbers[now], answer);
    }
}
