package study0827;
import java.io.*;
import java.util.*;
public class b1_22858_원상복구 {
	static int[] card;
	static int[] res;
	static int[] D;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		card = new int[N];
		for(int i=0;i<N;i++) {
			card[i] = sc.nextInt();
		}
		D = new int[N];
		for(int i=0;i<N;i++) {
			D[i] = sc.nextInt();
		}
		
		for(int i=0;i<K;i++) {
			res = new int[N];
			suffle(N);
		}
		for(int i=0;i<N;i++) {
			sb.append(card[i]).append(" ");
		}
		System.out.println(sb);
	}
	public static void suffle(int N) {
		for(int i=0;i<N;i++) {
			res[D[i]-1] = card[i];
		}
		card = res.clone();
	}

}
