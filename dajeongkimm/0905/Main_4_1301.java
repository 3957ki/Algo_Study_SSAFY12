import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비즈 공예
 * N종류 구슬
 * 다른 종류의 구슬은 색이 다름
 * 
 * 임의의 연속된 3개의 구슬의 색을 모두 다르게
 * 
 * 다솜이가 목걸이를 만들 수 있는 방법의 경우의 수
 * @author KOREA
 *
 */
public class Main_4_1301 {
	static int N; //구슬의 종류 (3<=N<=5)
	static int[] arr; //각각의 구슬이 몇개있는지 (<=10) 
	
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		int total = 0;
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		dp = new int[total+1][N+1]; //종류 N번으로 시작했을 때 total까지 ~
		for (int i=1;i<=N;i++) {
			dp[1][i] = 1;
		}
		
		

	}

}
