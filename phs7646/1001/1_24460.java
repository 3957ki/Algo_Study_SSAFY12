package emptyJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class prob1 {
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0;i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int j = 0;j < N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(pick(0,0,N));
	}
	static int pick(int i,int j, int length) {
		if(length == 1) return arr[i][j];
		int half = length>>1;
		List<Integer> list = new ArrayList<>();
		list.add(pick(i,j,half));
		list.add(pick(i+half,j,half));
		list.add(pick(i,j+half,half));
		list.add(pick(i+half,j+half,half));
		list.sort(null);
		return list.get(1);
	}
}