import java.io.*;
import java.util.*;
public class p18353 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] map = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int maxLen = 1;
        for(int i=1;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(map[i] < map[j]) { //내림차순 깨질때
                    dp[i] = Math.max(dp[i],dp[j] +1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(n - maxLen);
    }
}