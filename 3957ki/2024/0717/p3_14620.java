import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3_14620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		boolean[][] B = new boolean[N][N];
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		int[] dx = {0, 0, 1, -1, 0};
		int[] dy = {1, -1, 0, 0, 0};
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N-1; i++) {
			F: for(int j = 1; j < N-1; j++) {
				for(int d = 0; d <= 4; d++) {
					if(B[i+dy[d]][j+dx[d]]) {
						continue F;
					}
				}
				
				for(int d = 0; d <= 4; d++) {
					B[i+dy[d]][j+dx[d]] = true;
					sum += arr[i+dy[d]][j+dx[d]];
				}
				//----------
				for(int k = i; k < N-1; k++) {
					S: for(int l = 1; l < N-1; l++) {
						if(k == i && l <= j) continue S;
						for(int d = 0; d <= 4; d++) {
							if(B[k+dy[d]][l+dx[d]]) {
								continue S;
							}
						}
						
						for(int d = 0; d <= 4; d++) {
							B[k+dy[d]][l+dx[d]] = true;
							sum += arr[k+dy[d]][l+dx[d]];
						}
						//----------
						for(int a = k; a < N-1; a++) {
							T: for(int b = 1; b < N-1; b++) {
								if(a == k && b <= l) continue T;
								for(int d = 0; d <= 4; d++) {
									if(B[a+dy[d]][b+dx[d]]) {
										continue T;
									}
								}
								
								for(int d = 0; d <= 4; d++) {
									sum += arr[a+dy[d]][b+dx[d]];
								}
								answer = Math.min(answer, sum);
								for(int d = 0; d <= 4; d++) {
									sum -= arr[a+dy[d]][b+dx[d]];
								}
							}
						}
						//----------
						for(int d = 0; d <= 4; d++) {
							B[k+dy[d]][l+dx[d]] = false;
							sum -= arr[k+dy[d]][l+dx[d]];
						}
					}
				}
				//----------
				for(int d = 0; d <= 4; d++) {
					B[i+dy[d]][j+dx[d]] = false;
					sum -= arr[i+dy[d]][j+dx[d]];
				}
			}
		}	
					
		System.out.println(answer);
	}
	
	
}
