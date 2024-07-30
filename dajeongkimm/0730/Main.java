import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,M,K;
    static Map<Integer, ArrayList<Integer>> order;
    static int[] time;
    static ArrayList<int[]> dfsList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
//        Map<Integer, ArrayList<Integer>> level = new HashMap();
        order = new HashMap<>();
        //방향 그래프 (일의 순서)
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            order.putIfAbsent(a, new ArrayList<>());
            order.get(a).add(b);
        }

        //N-2개 중에서 (2~N-1의 tast 중에서 K개를 0으로 만들기)
        dfsList = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        DFS(tmp,2);

        int answer = Integer.MAX_VALUE;
        for (int i=0;i<dfsList.size();i++){
            int[] k_list = dfsList.get(i);
            int[] new_time = new int[N+1];
            for (int j=0;j<N+1;j++){
                new_time[j] = time[j];
            }
            for (int j=0;j<k_list.length;j++){
                new_time[k_list[j]] = 0;
            }
            int tmp_time = BFS(new_time);
            answer = Math.min(answer, tmp_time);
        }
        System.out.println(answer);
    }
    private static void DFS(ArrayList<Integer> cur_list, int idx){
        if (cur_list.size() == K){
            int[] result = new int[cur_list.size()];
            for (int i=0;i<cur_list.size();i++) {
                result[i] = cur_list.get(i);
            }
            dfsList.add(result);
        }
        for (int i=idx;i<=N-1;i++){
            cur_list.add(i);
            DFS(cur_list,i+1);
            cur_list.remove(cur_list.size()-1);
        }
    }
    private static int BFS(int[] new_time){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int answer = new_time[1];
//        visited[N] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            int tmp_time = -1;
            for (Integer n : order.getOrDefault(cur, new ArrayList<>())) {
                int num = n;
                if (!visited[num]) {
                    tmp_time = Math.max(tmp_time, new_time[num]);
                    visited[num] = true;
                    queue.add(num);
                }
            }
//            System.out.println(tmp_time);
            if (tmp_time != -1){
                answer += tmp_time;
            }
//            System.out.println(answer);
        }
        return answer;
    }
}