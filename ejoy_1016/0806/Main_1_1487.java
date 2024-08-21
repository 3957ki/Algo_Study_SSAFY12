package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main_1_1487 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [][] NArr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			NArr[i][0] = sc.nextInt();
			NArr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(NArr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0] - o2[0];
			}
		
		});
		
		int maxPrice = 0;
		int maxTotal = 0;
		
		for (int i = 0; i < N; i++) {
			int total = 0;
			for (int j = i; j < N; j++) {
				int tmp = NArr[i][0] - NArr[j][1];
				if (tmp > 0) {
					total += tmp;
				}	
				
			}
			if(total > maxTotal) {
				maxTotal = total;
				maxPrice = NArr[i][0];
			}
		}
		
		System.out.println(maxPrice);
		
	}
	
	
}