package study0723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1분동안 한개의탑만 고름, 몇개의 탑을 수정할 것인가

public class b2_16951 {
	static int N;
	static int K;
	static int[] tops;
	static int ans=987654321;
	public static boolean Kcheck(int[] arr) {
		for(int i=0;i<N-1;i++) {
			if(arr[i+1] - arr[i] != K)return false;
		}
		return true;
	}
	

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tops = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] tempArr = new int[N];
		tempArr[0] = tops[0];
		for(int i=1;i<N-1;i++) {
			tempArr[i] = K + tempArr[i+1];
		}
		
		int count=0;
		for(int i=0;i<N-1;i++) {
			if(tops[i] != K + tops[i+1]) {
				count++;
			}
		}

		
		System.out.println(count);
		
		
		
	}

}
