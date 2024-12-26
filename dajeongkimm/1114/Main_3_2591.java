import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3_2591 {
	static int[] arr;
	
	static int len;
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1개 또는 2개씩
		String input = br.readLine();
		
		len = input.length();
		arr = new int[len];
		for (int i=0;i<len;i++) {
			arr[i] = input.charAt(i)-'0';
		}
		
		dfs(0);
		System.out.println(answer);
	}
	
	static void dfs(int cur) {
		if (cur == len) {
			answer++;
			return;
		}
		
		//1개
		if (cur < len) {
			int num = arr[cur];
			if (num > 0) {
				dfs(cur+1);
			}
			
		}
		
		//2개
		if (cur < len-1) {
			int num = arr[cur]*10 + arr[cur+1];
			if (num <= 34 && num >= 10) {
				dfs(cur+2);
			}
		}
		
	}

}
