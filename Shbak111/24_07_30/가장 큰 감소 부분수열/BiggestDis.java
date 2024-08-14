package 실전코테스터디.Algo_0730;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 수열 A가 주어졌을 때, 그 수열의 감소 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
 * 2. 첫째 줄에 수열 A의 크기 N(1 ≤ N ≤ 1000)이 주어진다.
 * 3. 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다.(1 ≤ Ai ≤ 1,000)
 */

public class BiggestDis {
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("res/biggestdis.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] dp = new int[N];

        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i = 0;i < N;i++){
            nums[i] = Integer.parseInt(st2.nextToken());
            dp[i] = nums[i];
        }

        for(int i = 1;i < N;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] < nums[j]) {
                    //System.out.println(i + " " + j +" "+ dp[i] + " " + dp[j] + " " +nums[i] +" "+ (dp[j] + nums[i]));
                    dp[i]= Math.max(dp[i],  dp[j] + nums[i]);

                }

            }
        }
        Arrays.sort(dp);
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[N-1]);
    }
}

