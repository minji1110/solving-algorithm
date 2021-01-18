package BruteForce;

import java.util.Scanner;

public class 기숙사바닥_2858 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int red = scan.nextInt();	// 빨간색
        int brown = scan.nextInt();	// 갈색
        int total=red+brown;

        for(int w=3;w<5000;w++){
            if(total%w!=0)
                continue;
            for(int h=3;h<4000;h++){
                if(w*h==total){
                    if(2*w+2*h-4==red){
                        System.out.println(h+ " "+w);
                        return;
                    }
                }
            }
        }
    }
}
