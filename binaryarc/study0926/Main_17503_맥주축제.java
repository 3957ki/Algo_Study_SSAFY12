package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17503_맥주축제 {
	static class Beer {
		long like;
		long alcohol;
		public Beer(int l,long a) {
			this.like = l;
			this.alcohol = a;
		}
		
	}
	static int N,K;
	static long M;
	static int like_sum;
	static List<Beer> beers;
	static PriorityQueue<Long> pq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		beers = new ArrayList<Beer>();
		pq = new PriorityQueue<>((o1,o2)->Long.compare(o1, o2));
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int like = Integer.parseInt(st.nextToken());
			long alc = Long.parseLong(st.nextToken());
			beers.add(new Beer(like, alc));
		}
		beers.sort((o1, o2) -> o1.like==o2.like?Long.compare(o1.alcohol, o2.alcohol):Long.compare(o2.like, o1.like));
		
		like_sum = 0;
		for(int i=0;i<K;i++) {
			long like = beers.get(i).like;
			
			like_sum += like;
			pq.offer(like);
			
			if(pq.size() > N) {
				like_sum -= pq.poll();
			}
			
			if(pq.size() == N && like_sum >= M) {
				System.out.println(beers.get(i).alcohol);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}

}
