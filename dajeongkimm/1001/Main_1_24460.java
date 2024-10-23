import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 특별상이라도 받고 싶어
 * 
 * 1. 한명이라면 그 사람
 * 2. 재귀적으로 규칙 적용 --> 구역마다 한명씩 총 네명
 * 3. 네명 중 의자에 적힌 추첨번호가 두번째로 작은 사람
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
