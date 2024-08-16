import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_최고의팀만들기 {
	
	static int[] white = new int[1000];
	static int[] black = new int[1000];
	
	static String input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Scanner sc = new Scanner(System.in);
		
		int idx = 0;
		
		try {
			String line;
			while ((line=br.readLine()) != null && !line.isEmpty()) {
				st = new StringTokenizer(line);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				white[idx] = a;
				black[idx] = b;
				idx++;
			}
		} catch (IOException e) {
			
		}
		
//		while (sc.hasNextInt()) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			white[idx] = a;
//			black[idx] = b;
//			idx++;
//		}
//		
//		try {
//			while ((input=br.readLine()) != null) {
//				st = new StringTokenizer(br.readLine());
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				white[idx] = a;
//				black[idx] = b;
//				idx++;
//			}
//		} catch (Exception e) {
//			
//		}
		
//		while (true) {
//			st = new StringTokenizer(br.readLine());
//			if (st.hasMoreElements()) {
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				white[idx] = a;
//				black[idx] = b;
//				idx++;
//			} else break;
//			
//		}
		
		int[][][] dp = new int[idx][16][16];
		
		dp[0][1][0] = white[0];
		dp[0][0][1] = black[0];
		
		for (int i=1;i<idx;i++) {
			for (int w=0;w<=15;w++) {
				for (int b=0;b<=15;b++) {
					dp[i][w][b] = dp[i-1][w][b];
					if (w>=1) {
						dp[i][w][b] = Math.max(dp[i][w][b], dp[i-1][w-1][b]+white[i]);
					}
					if (b>=1) {
						dp[i][w][b] = Math.max(dp[i][w][b], dp[i-1][w][b-1]+black[i]);
					}
				}
			}
		}
		
		System.out.println(dp[idx-1][15][15]);
		
	}

}
