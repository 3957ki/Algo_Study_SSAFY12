import java.io.*;
import java.util.*;
/*
swea 제곱수 놀이랑 비슷한거 같음
입력된 수와 가장 가까운 제곱 수 찾기(1씩 빼보면서)
그다음 제곱수 나오면 바로 루트 씌우기 -> 그리디
샘플 테케는 다 맞는데 1%에서 틀렸다고 나옴 -> 로직이 틀린거 같다
->dp
 */
public class p1699_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		//dp[i] -> i를 만들 수 있는 최소한의 개수를 저장할 배열
		int[] dp = new int[t+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=t;i++){ // 0,1은 초기값 세팅이 되어있으니깐 2부터 t까지 돌리면서 dp에 최소값을 배당한다
			dp[i] = i; // 최악의 경우(1로만 구성되어있는 경우)
			for(int j=1;j*j<=i;j++){ // 각 항을 돌면서 최소한의 개수로 갱신할 수 있는 부분이 있는지 본다
				if(dp[i] > dp[i-j*j]+1){ //기존보다 더 최적의 조건을 찾은 경우
					dp[i] = dp[i-j*j]+1;
				}
			}
		}
		System.out.println(dp[t]);
	}

}
// 1 2 3 4 5