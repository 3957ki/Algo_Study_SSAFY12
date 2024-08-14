import java.io.*;
import java.util.*;

public class q16435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과일의 개수
		int L = Integer.parseInt(st.nextToken()); // 스네이크버드 초기 길이
		int result = L; // 스네이크버드 최대 길이
		
		int arr[] = new int[N];
		StringTokenizer height = new StringTokenizer(br.readLine()); // 과일 높이 
		for(int i = 0 ; i<N; i++) {
			arr[i] = Integer.parseInt(height.nextToken());
		}
		
		Arrays.sort(arr);
		int length = L; // 스네이크버드 현재 길이
		for(int j = 0; j<N; j++) {
			if(arr[j] <= length) {
				result++;
				length++;
			}
		}
		System.out.println(result);
	}
}
