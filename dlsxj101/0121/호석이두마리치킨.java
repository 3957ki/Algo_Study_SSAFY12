import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 호석이두마리치킨 {

    static int N, M;
    static int answer1, answer2, minTime;
    static List<Node> adjList[];

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adjList[A].add(new Node(B, 1));
            adjList[B].add(new Node(A, 1));
        }

        answer1 = 0;
        answer2 = 0;
        minTime = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                dijk(i, j);
            }
        }
        sb.append(answer1).append(" ").append(answer2).append(" ").append(minTime);
        System.out.println(sb);
    }

    static void dijk(int store1, int store2) {
        int dist[] = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[store1] = 0;
        dist[store2] = 0;

        pq.add(new Node(store1, 0));
        pq.add(new Node(store2, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int nowVertex = cur.index;

            if (dist[nowVertex] < cur.cost) continue;

            for (Node next : adjList[nowVertex]) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        sum *= 2;
        if (minTime > sum) {
            answer1 = store1;
            answer2 = store2;
            minTime = sum;
        }
    }
}