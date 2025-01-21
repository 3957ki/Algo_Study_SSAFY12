import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 나만안되는연애 {

    static int N, M, answer;
    static int parents[];
    static boolean info[];

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static void make() {
        parents = new int[N + 1];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[aRoot] += parents[bRoot];
        parents[bRoot] = aRoot;
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //M일 경우 false, W일 경우 true를 저장할 배열
        info = new boolean[N + 1];

        int Mcnt = 0;
        int Wcnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            String tmp = st.nextToken();

            if (tmp.equals("M")) {
                info[i] = false;
                Mcnt++;
            } else {
                info[i] = true;
                Wcnt++;
            }
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (info[u] == info[v]) continue;    //두 노드가 같은 성별의 대학교일 경우 연결X

            edges.add(new Edge(u, v, d));
            edges.add(new Edge(v, u, d));
        }

        Collections.sort(edges);
        make();

        int cnt = 0;
        int total = 0;

        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                total += edge.cost;

                cnt++;
                if (cnt == N - 1) break;
            }
        }
        if (cnt == N - 1) System.out.println(total);
        else System.out.println(-1);
    }
}