import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1_10994 {
	static int remove_cnt;
	static int add_cnt;
	
	static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int len = 4*N-3;
		int center = (N-1)*2;
		arr = new char[len][len];
		for (int i=0;i<len;i++) {
			for (int j=0;j<len;j++) {
				arr[i][j] = ' ';
			}
		}
		
		star(len,0);
		
		printArr(arr);
		
	}
	public static void star(int len, int start) {
		if (start>=len) return;
		
		for (int i=start;i<len;i++) {
			arr[start][i] = '*';
			arr[i][start] = '*';
			arr[len-1][i] = '*';
			arr[i][len-1] = '*';
		}
		star(len-2, start+2);
	}
	
	public static void printArr(char[][] arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
