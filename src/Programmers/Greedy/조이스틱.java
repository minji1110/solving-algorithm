package Programmers.Greedy;

public class 조이스틱 {
    static String name="AAA";
    static int answer=0;
    static boolean[] isComplete;

    public static void main(String[] args) {

        isComplete=new boolean[name.length()];
        for(int i=0;i<name.length();i++) {
            isComplete[i]=name.charAt(i)=='A';
        }

        int currPtr=0;
        int leftPtr,rightPtr;
        boolean complete=false;

        while(!complete){
            leftPtr=getLeftPtr();
            rightPtr=getRightPtr();
            int leftGap=getSmallerGap(currPtr,leftPtr);
            int rightGap=getSmallerGap(currPtr,rightPtr);

            if(leftPtr==rightPtr){
                answer+=leftGap;
                currPtr=leftPtr;
                complete=true;
            }
            else if(leftGap<=rightGap){
                answer+=leftGap;
                currPtr=leftPtr;
            }
            else{
                answer+=rightGap;
                currPtr=rightPtr;
            }

            isComplete[currPtr]=true;
            answer+=getUpDownCnt(name.charAt(currPtr));
        }
        System.out.println("answer = " + answer);
    }

    //오-왼 중 더 적은 횟수 구하기
    static int getSmallerGap(int curr, int dest){
        int straight = Math.abs(curr-dest);
        int reverse = name.length()-straight;
        return Math.min(straight,reverse);
    }

    static int getLeftPtr(){
        int leftPtr=0;
        for(int i=0;i<name.length();i++){
            if(!isComplete[i]) {
                leftPtr=i;
                break;
            }
        }
        return leftPtr;
    }

    static int getRightPtr(){
        int rightPtr=0;
        for(int i=name.length()-1;i>=0;i--){
            if(!isComplete[i]) {
                rightPtr=i;
                break;
            }
        }
        return rightPtr;
    }

    // 아래-위 조작 횟수 구하기
    static int getUpDownCnt(char alphabet){
        if(alphabet<='N') return alphabet-'A';
        else return 'A'-alphabet+26;
    }
}
