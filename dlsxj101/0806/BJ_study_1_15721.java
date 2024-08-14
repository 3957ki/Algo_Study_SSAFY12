import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_study_1_15721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int slogan = Integer.parseInt(br.readLine());
		
		int[] dp = new int[2000];	//약 2000개 정도 필요
		dp[0] = 0;
		dp[1] = 4;
		for(int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1] + (i+3);
		}
		
		int time = 0;	//몇 번째 회차부터 고려하면 될지 판단
		for(int i = 0; i < dp.length; i++) {
			if(dp[i] >= T) {
				time = i;
				break;
			}
		}
		int a = T - dp[time - 1];	//계산하여 나온 회차에서부터 몇 번째 뻔(또는 데기)을 확인하면 되는지 판단
		
		int[] game = new int[dp[time] * 2];	//해당 회차의 뻔데기 게임 입력
		
		for(int i = 0; i < 4; i++) {
			game[i] = i % 2;
		}
		for(int i = 0; i < time+1; i++) {
			game[i+4] = 0;
			game[i+time+5] = 1;
		}
		
		int cnt = 0;
		int b = 0;	//입력된 번째의 뻔(또는 데기)가 나오면 그 때의 인덱스를 체크
		for(int i = 0; i < game.length; i++) {
			if(game[i] == slogan) cnt++;
			if(cnt == a) {
				b = i;
				break;
			}
		}
		
		int answer = ((dp[time-1]*2)+b+1) % A;	//전체 인원 중 몇 번째 사람이 해당되는지 체크, 이때 첫 사람이 0부터 시작하기 때문에 이것을 체크 해줘야 함.
		
		if(answer == 0) System.out.println(A-1);
		else System.out.println(answer-1);
	}
}
