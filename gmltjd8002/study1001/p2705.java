package study1001;
import java.io.*;
import java.util.*;
/*
팰린드롬 -> 회문
초기값 1+(n-2)+1로 세팅
dp다(이전 계산값을 메모이제이션했다가 다시 써야할거같다)
dp[1] = 1(1밖에 없다)
dp[2] = 2, 1+1 (2개)
dp[3] = 3,1+1+1(2개)
dp[4] = 4,1+1+1+1, 1+2+1, 2+2(4개)
dp[5] = 5,1+1+1+1+1, 1+3+1, 2+1+2
맨처음엔 자기자신이 반복된다
그 뒤에 1부터 순차적으로 올라가는데 5를 예로 들면
1+dp[3]+1이 되는데 dp[3] -> 3,1+1+1이니깐 2
2가 되면 2+dp[1]+2가 되는데 dp[1] = 1

 */
public class p2705 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[1001];
        dp[0] = dp[1] = 1;
        int T = Integer.parseInt(br.readLine());
        
        //초기값을 제외한 부분 계산하기
        for(int i=2;i<=1000;i++){
            //자기자신
            dp[i] = 1;
            /*여긴 5를 예로 들면 j+dp[5-2j]+j 부분이다
            j가 1이면 1+dp[3]+1이다.
            (가운데를 3으로 만드는 팰린드롬 수를 메모이제이션으로 가져옴)
            그다음 j가 2가 되면 2+dp[1]+2가 된다
            그 때의 팰린드롬 수를 dp[i]에 더해준다
            */
            for(int j=1;j<=i-1;j++){
                if(j <= (i-j)){ // j가 i-j보다 작아야 왼쪽 인덱스다
                    dp[i] += dp[j];
                }
            }
        }

        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
/* -> 25%에서 컷
    for(int j=1;j<=i/2;j++){
        dp[i] += dp[j];
    } 
*/