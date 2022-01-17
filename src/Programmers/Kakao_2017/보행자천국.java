package Programmers.Kakao_2017;

public class 보행자천국 {

    public static void main(String[] args) {
        int[][] cityMap=new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        Solution solution=new Solution();
        int answer = solution.solution(3,6,cityMap);
        System.out.println("answer = " + answer);
    }

    static class Solution {
        static int MOD = 20170805;
        static int cnt = 0;
        static int answer=0;
        public int solution(int m, int n, int[][] cityMap) {
            walk(0,1,true,cityMap);
            walk(1,0,false,cityMap);
            return answer;
        }

        public void walk(int row, int col, boolean isFromLeft, int[][] cityMap){
            int m=cityMap.length;
            int n=cityMap[0].length;

            if(row==m-1 && col==n-1) {
                cnt++;
                answer=cnt%MOD;
                return;
            }

            else switch(cityMap[row][col]){
                case 0:
                    if(row+1<m) walk(row+1,col,false,cityMap);   //아래 이동
                    if(col+1<n) walk(row,col+1,true,cityMap);    //오른쪽 이동
                    break;
                case 2:
                    if(isFromLeft && col+1<n)  walk(row,col+1,true,cityMap);
                    else if(!isFromLeft && row+1<m) walk(row+1,col,false,cityMap);
                    break;
                default: break;
            }
        }
    }
}
