import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_2_2784 {
	static String[] input = new String[6];
	static char[][] board = new char[3][3];
	static boolean[] visit = new boolean[6];
	
	static boolean flag = false;
	
	static List<String> check = new ArrayList<>();
	static List<String> newcheck;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new String[6];
		for (int i=0;i<6;i++) {
			input[i] = br.readLine();
			check.add(input[i]);
		}
//		System.out.println(Arrays.toString(input));
		
		//사전순 정렬
		Arrays.sort(input);
		permu(0);
		
		if (!flag) {
			System.out.println(0);
			return;
		}
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}
	
	static void permu(int cnt) {
		if (cnt == 3) {
			if (pass()) {
				flag = true;
				
			}
			return;
		}
		
		for (int i=0;i<6;i++) {
			if (!visit[i]) {
				board[cnt][0] = input[i].charAt(0);
				board[cnt][1] = input[i].charAt(1);
				board[cnt][2] = input[i].charAt(2);
				visit[i] = true;
				permu(cnt+1);
				if (flag) return;
				visit[i] = false;
			}
		}
	}
	
	static boolean pass() {
		newcheck = new ArrayList<>();
		for (int i=0;i<6;i++) {
			newcheck.add(check.get(i));
		}
		
		for (int i=0;i<3;i++) {
			String tmp = "";
			String tmp2 = "";
			for (int j=0;j<3;j++) {
				tmp += board[i][j];
				tmp2 += board[j][i];
			}
			
			if (newcheck.contains(tmp)) {
				newcheck.remove(tmp);
			}
			if (newcheck.contains(tmp2)) {
				newcheck.remove(tmp2);
			}
		}
		
		return (newcheck.size() == 0);
		
	}

}
