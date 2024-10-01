package emptyJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[1000002];
		//input
		int N = Integer.parseInt(br.readLine());
		for(int n = 0;n < N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())]++;
			arr[Integer.parseInt(st.nextToken())+1]--;
		}
		//preprocess
		int accum[] = new int[1000001];
		accum[0] = arr[0];
		for(int time = 1;time <= 1000000;time++) {
			accum[time] = accum[time-1] + arr[time];
		}
		
		//build answer
		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int q = 0;q < Q;q++) {
			sb.append(accum[Integer.parseInt(st.nextToken())]).append('\n');
		}
		System.out.println(sb);
	}

}
