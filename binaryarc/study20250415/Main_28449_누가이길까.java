package study20250415;

import java.io.*;
import java.util.*;

public class Main_28449_누가이길까 {
	static int[] HI, ARC;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		HI = new int[N];
		ARC = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			HI[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			ARC[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(HI);
		long HI_WIN = 0;
        long ARC_WIN = 0;
        long draw = 0;
        
        for (int i = 0; i < M; i++) {
            int arcCard = ARC[i];
            
            // 실력 하한 탐색
            int lowerCount = lowerBound(arcCard);
            
            // 실력 상한 탐색
            int upperCount = upperBound(arcCard);
            
            // 같은 실력 개수 
            int sameCount = upperCount - lowerCount;
            
            ARC_WIN += lowerCount;
            draw += sameCount;
            HI_WIN += (N - upperCount);
        }
        
        System.out.println(HI_WIN + " " + ARC_WIN + " " + draw);
    }
    
    static int lowerBound(int arcCard) {
        int low = 0;
        int high = N;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (HI[mid] < arcCard) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    static int upperBound(int arcCard) {
        int low = 0;
        int high = N;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (HI[mid] <= arcCard) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}
