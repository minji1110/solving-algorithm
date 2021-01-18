package BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 체스판다시칠하기_1018 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int height=scanner.nextInt();
        int width=scanner.nextInt();

        String[] sample=new String[]{
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW"
        };

        List<String> input = new ArrayList<>();
        String line=scanner.nextLine(); //첫 공백 비우기

        for(int h=0;h<height;h++){
            line=scanner.nextLine();
            input.add(line);
        }

        int min=64;

        //input[h][w][
        for(int h=0;h<height-7;h++){
            for(int w=0;w<width-7;w++){
                int swapCnt=0;
                for(int x=0;x<8;x++){
                    for(int y=0;y<8;y++){
                        if(input.get(x + h).charAt(y+w)!=sample[x].charAt(y)){
                            swapCnt++;
                        }
                    }
                }
                int thisMin= Math.min(swapCnt,64-swapCnt);
                if(thisMin<min) min=thisMin;
            }
        }
        System.out.println(min);
    }
}
