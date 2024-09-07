package algo0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1421_나무꾼이다솜 {
    static int N, C, W;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] timber;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        timber = new int[N];

        int maxTimber = 0;
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            timber[i] = v;
            if (v > maxTimber) {
                maxTimber = v;
            }
        }
        if (N == 1) {
            System.out.println(timber[0] * W);
            System.exit(0);
        }

        long maxEarning = 0;
        long cut = 0;
        for (int i = 1; i <= maxTimber; i++) {
            long cuttingSum = 0;
            long earningSum = 0;

            for (int j = 0; j < N; j++) {
            	int cutting;
            	long earning;
            	if (timber[j] % i == 0) {
                    cutting = timber[j] / i - 1;
                    earning = ((cutting + 1)* W * i) - (cutting)* C;
            	} else {
                    cutting = timber[j] / i;
                    earning = (cutting * W * i) - (cutting)* C;
            	}
            	if (earning > 0) {
                    earningSum += earning;
            	}


            }
            if (earningSum > maxEarning) {
                maxEarning = earningSum;
                cut = cuttingSum;
            }
        }
        
        for (int i = 0; i < N; i++) {
            long earning = timber[i] * W;
            for (int j = i+1; j < N; j++) {
                if (timber[i] == timber[j]) {
                    earning += timber[j] * W;
                }
            }
            maxEarning = Math.max(maxEarning, earning);
        }
        System.out.println(maxEarning);
    }
}
/*
 * 
4 1000 1
2
1
1
1
3 1 10
26
103
59
6 1 10
30
20
50
20
40
30
* */
