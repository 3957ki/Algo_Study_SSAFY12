import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나무꾼 이다솜
 * 
 * 팔려고 하는 나무의 길이를 전부 같게 (자연수로)
 * 
 * 한번 자를 때는 C원이 든다
 * 나무를 살 때는 한 단위에 W원씩 준다.
 * K개의 나무 길이 L --> K*L*W
 * 
 * 현재 가지고 있는 나무의 길이가 주어졌을 때 벌 수 있는 가장 큰 돈
 * @author KOREA
 *
 */
public class Main_2_1421 {
	static int N,C,W;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		int max = 0;
		tree = new int[N];
		for (int i=0;i<N;i++) {
			tree[i]= Integer.parseInt(br.readLine());
			max = Math.max(max,  tree[i]);
			
		}
		
		int start = 1;
		while (start<=max) {
			long tmp = 0;
			for (int t : tree) {
				if (start>t) {
//					tmp += W*t;
				}
				//나누어 떨어지면 --> 한번 덜잘라도 됨 (4개면 3번 자르기)
				else if (t%start == 0) {
					long cost = ((t/start)*start*W - (t/start-1)*C);
					if (cost>0) {
						tmp += cost;
					}
					
				}
				else if (t%start != 0){
					long cost = ((t/start)*W*start - (t/start)*C);
					if (cost>0) {
						tmp += cost;
					}
				}
			}
//			System.out.println(tmp);
			answer = Math.max(answer, tmp);
			start++;
		}
		
		System.out.println(answer);
		

	}

}
