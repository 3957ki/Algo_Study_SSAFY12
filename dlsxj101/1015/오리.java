import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 메모리 : 11720kb
 * 시간 : 72ms
 * 전략
 * 
 */
public class 오리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().trim();
		char input[] = str.toCharArray();
		
		char quack[] = {'q', 'u', 'a', 'c', 'k'};
		if(input.length % 5 != 0) {
			System.out.println(-1);
			return;
		}
		
		int dir = 0;
		int cnt = 0;
		while(true) {
			boolean flag = false;
			dir = 0;
			for(int i = 0; i < input.length; i++) {
				if(input[i] == quack[dir]) {
					if(dir == 4) flag = true;
					input[i] = '.';
					dir++;
					dir %= 5;
				}
			}
			if(!flag) break;
			cnt++;
		}
		for(int i = 0; i < input.length; i++) {
			if(input[i] != '.') {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(cnt);
	}
	
}
