package Programmers.Kakao_2022;

import java.util.*;

public class 주차요금계산 {
    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};
            final int maxMin=23 * 60 + 59;
            Map<String,int[]> cars=new HashMap<>();

            for(String record : records){
                String[] info=record.split(" ");
                String[] time=info[0].split(":");

                int minutes=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
                String carNum=info[1];

                //첫등록 (등록시간, 누적시간, 출차여부)
                if(!cars.containsKey(carNum)) cars.put(carNum,new int[]{minutes,0,0});
                else{
                    int[] car=cars.get(carNum);

                    if(info[2].equals("IN")){
                        car[0]=minutes;
                        car[2]=0;
                    }else{
                        car[1]+=minutes-car[0];
                        car[2]=1;
                    }
                }
            }

            List<String> keySet =new ArrayList<>(cars.keySet());
            Collections.sort(keySet);
            answer=new int[keySet.size()];

            for (int i=0;i<keySet.size();i++) {
                int[] car=cars.get(keySet.get(i));

                if(car[2]==0) car[1]+=maxMin-car[0];
                answer[i]=calculateFees(fees,car[1]);
            }
            return answer;
        }

        private int calculateFees(int[] fees, int min) {
            int defaultMin=fees[0]; //기본시간(분)
            int defaultFee=fees[1]; //기본요금
            int unitMin=fees[2];    //단위시간
            int unitFee=fees[3];    //단위요금

            if(min<=defaultMin) return defaultFee;
            else return (int) (defaultFee + Math.ceil((double)(min-defaultMin)/unitMin)*unitFee);
        }
    }
}
