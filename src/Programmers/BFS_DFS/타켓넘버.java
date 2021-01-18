package Programmers.BFS_DFS;

public class 타켓넘버 {
    static int[] numbers=new int[]{1,1,1,1,1};
    static int target=3;
    static int answer=0;

    public static void main(String[] args) {

        DFS(numbers,0,0,target);
        System.out.println(answer);
        }

    private static void DFS(int[] numbers, int now, int sum, int target) {
        if (now >= numbers.length) {
            if (target == sum) {
                answer += 1;
                return;
            }
            return;
        }
        DFS(numbers,now+1,sum+numbers[now],target);
        DFS(numbers,now+1,sum-numbers[now],target);
    }
}
