import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Ư�����̶� �ް� �;�
 * 
 * 1. �Ѹ��̶�� �� ���
 * 2. ��������� ��Ģ ���� --> �������� �Ѹ� �� �׸�
 * 3. �׸� �� ���ڿ� ���� ��÷��ȣ�� �ι�°�� ���� ���
 * @author KOREA
 *
 */
public class Main_1_24460 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = price(0,0,N);
		System.out.println(answer);
		
	}
	private static int price(int r, int c, int size) {
		int[] num = new int[4];
		
		if (size == 1) {
			return arr[r][c];
		}
		
		num[0] = price(r,c,size/2);
		num[1] = price(r,c+size/2,size/2);
		num[2] = price(r+size/2,c,size/2);
		num[3] = price(r+size/2, c+size/2, size/2);
		
		Arrays.sort(num);
		return num[1];
	}

}
