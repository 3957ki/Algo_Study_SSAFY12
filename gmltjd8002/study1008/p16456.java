import java.io.*;
import java.util.*;
//부분집합? n보니깐 터질듯
// 입력-1개를 가지고 1,-1,2를 이용해서 부분집합 만들어서 최종값이 -1인거만 더해주면 되는건데?
//그래도 시간초과날거같은데 dp인거같음

/*
생각해본점
i번째에 도달할 수 있는점은
i-1에서 1칸 이동
i-2에서 2칸 이동인데
  - 그 때 i-1에서 한칸 뒤로 이동했다는 말이 된다
  - i-1에서 뒤로 한칸 이동했다 -> i-3에서 두칸 뛰었다!
  dp[i] = dp[i-1] + dp[i-3];
 */

public class p16456 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[50001]; // 섬 개수 보니깐 long일거같음
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        if(n>3){
            for(int i=4;i<=n;i++){
                dp[i] = (dp[i-1] + dp[i-3]) % 1000000009;
            }
        }
        System.out.println(dp[n]);
    }
}
