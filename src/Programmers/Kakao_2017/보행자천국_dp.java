package Programmers.Kakao_2017;

public class 보행자천국_dp {
    public static void main(String[] args) {
        int[][] cityMap=new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        Solution solution = new Solution();
        int answer = solution.solution(3, 6, cityMap);
        System.out.println("answer = " + answer);
    }

    static class Solution {
        public int solution(int m, int n, int[][] cityMap) {
            int MOD = 20170805;
            int answer = 0;

            //0 : 오른쪽으로 가능한 경로 수 , 1 : 아래
            int[][][] dp = new int[m+1][n+1][2];
            dp[0][1][1]=1;

            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    switch(cityMap[i-1][j-1]){
                        case 0 :
                            dp[i][j][0] =dp[i][j][1]= (dp[i][j-1][0]+dp[i-1][j][1])%MOD;
                            break;
                        case 2:
                            dp[i][j][0]=dp[i][j-1][0];
                            dp[i][j][1]=dp[i-1][j][1];
                            break;
                        default: break;
                    }
                }
            }

            answer=dp[m][n][0];
            return answer;
        }
    }
}
