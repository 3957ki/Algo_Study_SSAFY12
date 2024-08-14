package study0801;

import java.io.*;
import java.util.*;

public class p15721 {
	static int zeroCnt = 0, oneCnt = 0;
	static int res = 0;
	static int a,t,target; // period -> 주기 체크
	static int period = 2; // 이미 앞에서 뻔-데기 가 두번 돌았다
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Integer.parseInt(br.readLine());
		t = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());
		for(int i=0;i<4;i++) { // 초기에는 값이 뻔-데기 2회 반복이므로 미리 대입
			zeroCnt += (i%2 == 0) ? 1 : 0;
			oneCnt += (i%2 == 1) ? 1 : 0;
		}
		System.out.println(calc());
	}
	
	public static int calc() {
		int zeroCnt =0, oneCnt =0;
		int period = 2;
		while(true) {
			for(int i=0;i<4;i++) { // 4 이하인 경우
				if(i % 2 ==0) {
					zeroCnt++;
					if(zeroCnt == t && target == 0) return (zeroCnt + oneCnt -1) % a;
				}
				else {
					oneCnt++;
					if(oneCnt == t && target == 1) return (zeroCnt + oneCnt -1) % a;
				}
			}
			for(int i=0; i<period;i++) {
				zeroCnt++;
				if(zeroCnt == t && target == 0) return (zeroCnt + oneCnt -1) % a;
			}
			
			for(int i=0; i<period;i++) {
				oneCnt++;
				if(oneCnt == t && target == 1) return (zeroCnt + oneCnt -1) % a;
			}
			period++;
		}
	}
}