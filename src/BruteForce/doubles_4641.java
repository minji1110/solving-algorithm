package BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class doubles_4641 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while(true){
            int num=scanner.nextInt();
            if(num==-1)
                return;
            else if(num==0){
                int cnt=0;
                for(int i=0;i<list.size()-1;i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i) * 2 == list.get(j) || list.get(j) * 2 == list.get(i)) {
                            cnt++;
                        }
                    }
                }
                System.out.println(cnt);
                list.clear();
            }
            else list.add(num);
        }
    }
}
