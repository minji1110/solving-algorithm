package hongik_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 절대평가_23320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String scores[] = br.readLine().split(" ");
        String bounds[] = br.readLine().split(" ");

        int relativeBound = Integer.parseInt(bounds[0]);
        int absoluteBound = Integer.parseInt(bounds[1]);

        int absoluteCnt=0;
        for (int i = 0; i < n; i++) if(Integer.parseInt(scores[i])>=absoluteBound) absoluteCnt++;

        int relativeCnt= relativeBound*n/100;
        System.out.println(relativeCnt+" "+absoluteCnt);
    }
}
