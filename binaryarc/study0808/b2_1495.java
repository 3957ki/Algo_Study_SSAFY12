package study0808;
import java.io.*;
import java.util.*;
public class b2_1495 {
	public static boolean plusRangeChk(int num) {
		return num<=maxVolume;
	}
	public static boolean minusRangeChk(int num) {
		return num>=0;
	}
	
	static int maxVolume;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //노래의수
		int s = sc.nextInt(); //시작 볼륨
		maxVolume = sc.nextInt(); //볼륨 상한선
		
		int[] v = new int[n+1];
		List<HashSet<Integer>> dp = new ArrayList<>();
		for(int i=0;i<n;i++) {
			v[i] = sc.nextInt();
		}
		dp.add(new HashSet<Integer>());
		int plus = s+v[0];
		int minus = s-v[0];
		if(plusRangeChk(plus)) dp.get(0).add(plus);
		if(minusRangeChk(minus)) dp.get(0).add(minus);
		
		for(int i=1;i<n;i++) {
			dp.add(new HashSet<Integer>());
			if(dp.get(i-1).isEmpty()) {
				System.out.println(-1);
				return;
			}else {
				for(int num : dp.get(i-1)) {
					plus = num+v[i];
					minus = num-v[i];
					if(plusRangeChk(plus)) dp.get(i).add(plus);
					if(minusRangeChk(minus)) dp.get(i).add(minus);
				}
			}
		}
		int ans=-1;
		for(int i : dp.get(dp.size()-1)) {
			if(i==maxVolume) {
				System.out.println(i);
				return;
			}
			ans = Math.max(ans,i);
		}
		System.out.println(ans);
	}

}
