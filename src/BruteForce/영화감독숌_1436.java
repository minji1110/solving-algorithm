package BruteForce;

import java.util.Scanner;

public class 영화감독숌_1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 1) {
            System.out.println("666");
            return;
        }

        int cnt = 1;
        int number = 1666;
        while(true){
            if(String.valueOf(number).contains("666")){
                cnt+=1;
                if(cnt==n){
                    System.out.println(number);
                    return;
                }
            }
            number+=1;
        }
    }
}
