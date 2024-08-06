import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {
    static Map<Integer, String> map;
    static Map<String, Integer> map2;
    static Map<String, String> friend;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = 1;
        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int idx = 1;
            map = new HashMap<>();
            map2 = new HashMap<>();
            friend = new HashMap<>();
            boolean[] visited = new boolean[N+1];
            for (int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map2.containsKey(a)){
                    map.put(idx++,a);
                    map2.put(a, idx-1);
                }
                if (!map2.containsKey(b)){
                    map.put(idx++,b);
                    map2.put(b, idx-1);
                }
                friend.put(a,b);
            }
            int answer = 0;
            for (int i=1;i<=N;i++){
                if (!visited[i]){
                    answer += 1;
                    String cur = map.get(i);
                    ArrayDeque<String> queue = new ArrayDeque<>();
                    queue.add(cur);
                    visited[i] = true;
                    while (!queue.isEmpty()){
                        String cur_person = queue.poll();
                        String new_person = friend.get(cur_person);
                        int new_idx = map2.get(new_person);
                        if (!visited[new_idx]){
                            visited[new_idx] = true;
                            queue.add(new_person);
                        }
                    }
                }
            }
            System.out.println(test_case++ +" "+answer);
        }
    }
}