package study0806;
import java.io.*;
import java.util.*;

public class b3_3079 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int deskCnt = Integer.parseInt(st.nextToken());
		int peopleCnt = Integer.parseInt(st.nextToken());
		int[] deskTimes = new int[deskCnt];
		long low = Integer.MAX_VALUE;
		long high = -1;
		for(int i=0;i<deskCnt;i++) {
			deskTimes[i] = Integer.parseInt(br.readLine());
			low = Math.min(low,deskTimes[i]);
			high = Math.max(high,deskTimes[i]);
		}
		high*=peopleCnt;
		long result = high;
		while(low <= high) {
			long mid = (low+high) / 2;
			if(canPass(mid,deskTimes,peopleCnt)) {
				result = mid;
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		
		System.out.println(result);

	}
	public static boolean canPass(long time, int[] deskTimes, int peoples) {
		long count = 0;
		for(int t : deskTimes) {
			count += time / t;
			if(count>=peoples) {
				return true;
			}
		}
		return count >= peoples;
	}
}
