import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 원상복구
 * N개의 카드
 * Di번째 카드를 i번째로 가져오는 작업 : 셔플
 * 
 * K번 셔플한 카드의 정보와 D의 정보를 알고 있다고 할 때, 원래 카드는 어떤 배치?
 * @author SSAFY
 *
 */
public class Main_22858 {
	static int N,K;
	static int[] S;
	static int[] D; 
	
	static int[] answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		S = new int[N+1];
		for (int i=1;i<=N;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		D = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new int[N+1];
		
		for (int k=0;k<K;k++) {
			for (int i=1;i<=N;i++) {
				answer[D[i]] = S[i];
			}
			for (int i=1;i<=N;i++) {
				S[i] = answer[i];
			}
		}
		
		for (int i=1;i<=N;i++) {
			System.out.print(answer[i]+" ");
		}

	}

}
