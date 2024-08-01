import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int N,M,K;
	
	static List<List<Integer>> graph;
	
	static List<List<Integer>> kList;
	
	static int end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] time = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		int[] inDegree = new int[N+1];
		for (int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			inDegree[b]++;
		}
		
		end = findEndNode();
//		System.out.println(end);
		if (K == 0) {
			System.out.println(RunningTime(time, inDegree));
		} else {
			int answer = Integer.MAX_VALUE;
			kList = new ArrayList<>();
			ArrayList<Integer> tmp_list = new ArrayList<>();
			MakeNewTime(2,tmp_list);
			for(List<Integer> list : kList) {
//				ArrayList<Integer> list = (ArrayList<Integer>) kList.get(k);
				int[] new_time = new int[N+1];
				for (int i=1;i<new_time.length;i++) {
					new_time[i] = time[i];
				}
				for (int i=0;i<list.size();i++) {
					int idx = list.get(i);
//					System.out.println("idx : "+idx);
					new_time[idx] = 0;
				}
				for (int i=1;i<=N;i++) {
//					System.out.println("new_time "+i+": "+new_time[i]);
				}
				int[] new_inDegree = new int[N+1];
				for (int i=1;i<new_inDegree.length;i++) {
					new_inDegree[i] = inDegree[i];
					
				}
				int tmp = RunningTime(new_time, new_inDegree);
//				System.out.println("tmp : "+tmp);
				answer = Math.min(answer, tmp);
			}
			System.out.println(answer);
			
		}
		
		
		
		
		}
	
	//마지막 작업 제외
	private static void MakeNewTime(int start, ArrayList<Integer> tmp_list) {
		if (tmp_list.size() == K) {
			kList.add(new ArrayList<>(tmp_list));
			return;
		}
		for (int i=start;i<=N;i++) {
			if (i != end) {
				tmp_list.add(i);
				MakeNewTime(i+1, tmp_list);
				tmp_list.remove(tmp_list.size()-1);
			}
			
		}
	}
	
	
	private static int RunningTime(int[] time, int[] inDegree) {
		int[] dp = new int[N+1];
		for (int i=1;i<=N;i++) {
			dp[i] = time[i];
		}
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int n : graph.get(cur)) {
				inDegree[n]--;
				dp[n] = Math.max(dp[n], dp[cur]+time[n]);
				if (inDegree[n]==0) {
					queue.add(n);
				}
			}
		}
		return Arrays.stream(dp).max().getAsInt();
	}
		
	private static int findEndNode() {
        boolean[] hasOutgoingEdge = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int neighbor : graph.get(i)) {
                hasOutgoingEdge[i] = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!hasOutgoingEdge[i]) {
                return i;
            }
        }
        return -1; 
		
		
	}}
