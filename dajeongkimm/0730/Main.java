import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {
	static int N, M, K;
	static int[] time;
	static List<List<Integer>> graph;
	static int[] inDegree;
	static ArrayList<int[]> dfsList;
	static int start, end;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		time = new int[N+1];
		inDegree = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		//그래프 초기화
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
		
		start = 1;
		int maxDegree = Arrays.stream(inDegree).max().getAsInt();
		for (int i=0;i<=N;i++) {
			if (inDegree[i] == maxDegree) {
				end = i;
			}
		}
		
		//N-2개 중에서 (2~N-1의 tast 중에서 K개를 0으로 만들기)
        dfsList = new ArrayList<>();
        
        for (int i=2;i<=N;i++) {
        	ArrayList<Integer> tmp = new ArrayList<>();
        	DFS(tmp,i);
        }
        
        
        answer = Integer.MAX_VALUE;
        
        for (int i=0;i<dfsList.size();i++) {
        	int tmpTime = 0;
        	int[] zeroTime = dfsList.get(i);
        	List<Integer> list = Arrays.stream(zeroTime).boxed().collect(Collectors.toList());
        	Set<Integer> set = new HashSet<>(list);
        	ArrayDeque<Integer> queue = new ArrayDeque<>();
        	queue.add(start);
        	
        	while(!queue.isEmpty()) {
        		int cur = queue.poll();
        		
        		int addTime = 0;
        		for (int n : graph.get(cur)) {
        			inDegree[n]--;
        			if (inDegree[n] == 0) {
        				if (!set.contains(n)) {
        					addTime = Math.max(addTime, time[n]);
            				queue.add(n);
        				}
        				
        			}
        		}
        		tmpTime += addTime;
        	}
        	System.out.println("tmpTime");
        	System.out.println(tmpTime);
        	answer = Math.min(answer, tmpTime);
        	
        }
        System.out.println(answer);
        
        
	}
	private static void DFS(ArrayList<Integer> cur_list, int idx) {
		if (cur_list.size() == K) {
			int[] result = new int[cur_list.size()];
			for (int i=0;i<cur_list.size();i++) {
				result[i] = cur_list.get(i);
			}
			dfsList.add(result);
		}
		
		for (int i=idx;i<=N;i++) {
			if (i!=end) {
				cur_list.add(i);
				DFS(cur_list, i+1);
				cur_list.remove(cur_list.size()-1);
			}
		}
	}
}