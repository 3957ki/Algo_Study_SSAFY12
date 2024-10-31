import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3_17088 {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//1개면 무조건 등차수열
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		int[] arrCopy = new int[N];
		
		//3*3*(2*N) --> 18*100_000 = 1_800_000 
		int answer = Integer.MAX_VALUE;
		for (int i=-1;i<=1;i++) {
			for (int j=-1;j<=1;j++) {
				int cnt = 0;
				boolean flag = true;
				
				//arrCopy 복사
				for (int k=0;k<N;k++) {
					arrCopy[k] = arr[k];
				}
				
				if (i != 0) cnt++;
				if (j != 0) cnt++;
				
				arrCopy[0] += i;
				arrCopy[1] += j;
				
				int diff = arrCopy[1] - arrCopy[0];
				
				for (int n=2;n<N;n++) {
					if ((arrCopy[n]-arrCopy[n-1]) == diff) continue;
					else if ((arrCopy[n]+1 - arrCopy[n-1]) == diff) {
						arrCopy[n]++;
						cnt++;
					}
					else if ((arrCopy[n]-1 - arrCopy[n-1]) == diff) {
						arrCopy[n]--;
						cnt++;
					}
					else {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					answer = Math.min(answer, cnt);
				}
			}
		}
		
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
		
	}
	

}
