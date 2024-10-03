import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 파티션
 * 
 * 양의정수 N의 파티션 : 합이 N이 되는 수열
 * 
 * 어떤 파티션을 앞에서 읽을 때와 뒤에서 읽을 때가 같으면 --> 팰린드롬 파티션
 * 
 * 재귀적인 팰린드롬 파티션
 * : 팰린드롬이면서 왼쪽 절반과 오른쪽 절반이 재귀적인 팰린드롬 or 비어있을 때
 * 
 * 어떤 수 N --> 재귀적인 팰린드롬 파티션의 개수 출력
 * @author KOREA
 *
 */
public class Main_2_2705 {
	static int[] count = new int[1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		count[1] = 1; //1
		count[2] = 2; //1+1, 2
		count[3] = 2; //1+1+1, 3
		count[4] = 4; 
		//count[2] : (1+1+1+1, 2+2)
		//count[1] : (1+2+1)
		//4
		
		for (int i=5;i<=1000;i++) {
			//가운데 숫자 j
			for (int j=0;j<=i-2;j++) {
				if ((i-j)%2 == 0) {
					count[i] += count[(i-j)/2];
				}
			}
			count[i]++; //i = i 일때 
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(count[N]);
			
			
		}
	}

}
