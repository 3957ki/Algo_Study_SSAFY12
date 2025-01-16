import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 나무위의빗물 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        List<Integer> adjList[] = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            adjList[U].add(V);
            adjList[V].add(U);
        }

        double arr[] = new double[N + 1];
        arr[1] = W;

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int tmp[] = q.poll();

            int cur = tmp[0];
            int parent = tmp[1];

            int size = 0;
            if (cur == 1) size = adjList[cur].size();   //1번은 부모노드 없음
            else size = adjList[cur].size() - 1;    //부모노드 제거

            if (size == 0) continue;    //자식 노드가 없을 경우

            double nextWater = arr[cur] / size;
//            System.out.println(nextWater);
            arr[cur] = 0;

            for (int next : adjList[cur]) {
                if (next == parent) continue;

                arr[next] = nextWater;
                q.add(new int[]{next, cur});
            }
        }
        double total = 0;
        int cnt = 0;
//        System.out.println(Arrays.toString(arr));
        for (double tmp : arr) {
            if (tmp == 0) continue;

            total += tmp;
            cnt++;
        }
        System.out.println(total / cnt);
    }
}