import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//짠돌이 호석
class Main {
	static int N1, M1, N2, M2;
	static int[][] board;
	static int[][] board2;
	static int[][] board2_90;
	static int[][] board2_180;
	static int[][] board2_270;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean bebug = true;
		
		st = new StringTokenizer(br.readLine());
		N1 = Integer.parseInt(st.nextToken());
		M1 = Integer.parseInt(st.nextToken());
		board = new int[N1][M1];
		for (int i=0;i<N1;i++) {
			String input = br.readLine();
			for (int j=0;j<M1;j++) {
				board[i][j] = input.charAt(j)-'0';
			}
		}
		
		st = new StringTokenizer(br.readLine());
		N2 = Integer.parseInt(st.nextToken());
		M2 = Integer.parseInt(st.nextToken());
		board2 = new int[N2][M2];
		for (int i=0;i<N2;i++) {
			String input = br.readLine();
			for (int j=0;j<M2;j++) {
				board2[i][j] = input.charAt(j)-'0';
			}
		}
		board2_90 = turn(board2);
		board2_180 = turn(board2_90);
		board2_270 = turn(board2_180);
		
		int x_tmp = Math.min(N1, N2);
		int y_tmp = Math.min(M1,  M2);
		
		int x_right = Math.max(N1, N2);
		int y_right = Math.max(M1,  M2);
		
		int answer = Integer.MAX_VALUE;
		
		for (int x = -x_tmp+1;x<x_right;x++) {
			for (int y=-y_tmp+1;y<y_right;y++) {
				boolean isTrue = false;
				
				for (int i=0;i<N2;i++) {
					for (int j=0;j<M2;j++) {
						if (x+i>=N1 || y+j>=M1 || x+i<0 || y+j<0) continue;
						if (board[x+i][y+j] == 1 && board2[i][j] == 1) {
							isTrue = true;
							break;
						}
					}
					if (isTrue) break;
				}
				
				if (!isTrue) {
					int bottom = Math.max(N1,  N2+x);
					int top = Math.min(x, 0);
					
					int right = Math.max(M1,  M2+y);
					int left = Math.min(y, 0);
					
					answer = Math.min(answer,  (bottom-top)*(right-left));
				}
				
				isTrue = false;
				
				for (int i=0;i<N2;i++) {
					for (int j=0;j<M2;j++) {
						if (x+i>=N1 || y+j>=M1 || x+i<0 || y+j<0) continue;
						if (board[x+i][y+j] == 1 && board2_180[i][j] == 1) {
							isTrue = true;
							break;
						}
					}
					if (isTrue) break;
				}
				
				if (!isTrue) {
					int bottom = Math.max(N1,  N2+x);
					int top = Math.min(x, 0);
					
					int right = Math.max(M1,  M2+y);
					int left = Math.min(y, 0);
					
					answer = Math.min(answer,  (bottom-top)*(right-left));
				}
			}
		}
		
		for (int x=-y_tmp+1;x<y_right;x++) {
			for (int y=-x_tmp+1;y<x_right;y++) {
				boolean isTrue = false;
				
				for (int i=0;i<M2;i++) {
					for (int j=0;j<N2;j++) {
						if (x+i>=N1 || y+j>=M1 || x+i<0 || y+j<0) continue;
						if (board[x+i][y+j] == 1 && board2_90[i][j] == 1) {
							isTrue = true;
							break;
						}
						
					}
					if (isTrue) break;
				}
				if (!isTrue) {
					int bottom = Math.max(N1,  M2+x);
					int top = Math.min(x, 0);
					
					int right = Math.max(M1,  N2+y);
					int left = Math.min(y,0);
				
					
					answer = Math.min(answer,  (bottom-top)*(right-left));
				}
				
				isTrue = false;
				for (int i=0;i<M2;i++) {
					for (int j=0;j<N2;j++) {
						if (x+i>=N1 || y+j>=M1 || x+i<0 || y+j<0) continue;
						if (board[x+i][y+j] == 1 && board2_270[i][j] == 1) {
							isTrue = true;
							break;
						}
						
					}
					if (isTrue) break;
				}
				if (!isTrue) {
					int bottom = Math.max(N1,  M2+x);
					int top = Math.min(x, 0);
					
					int right = Math.max(M1,  N2+y);
					int left = Math.min(y,0);
				
					
					answer = Math.min(answer,  (bottom-top)*(right-left));
				}
			}
		}
		
		System.out.println(answer);
		
		
	}
	private static int[][] turn(int[][] arr){
		int[][] result = new int[arr[0].length][arr.length];
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				result[j][arr.length-1-i] = arr[i][j];
			}
		}
		return result;
	}
	private static void printArr(int[][] arr) {
		System.out.println("PrintArr----------");
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}