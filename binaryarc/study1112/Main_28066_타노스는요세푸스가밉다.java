package study1112;

import java.util.*;

public class Main_28066_타노스는요세푸스가밉다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Deque<Integer> q = new ArrayDeque<>();
		for(int i=1;i<=N;i++)q.add(i);
		
		while(q.size()>=K) {
			q.add(q.poll());
			for(int i=1;i<K;i++)q.poll();
		}
		System.out.println(q.peek());
	}
}
