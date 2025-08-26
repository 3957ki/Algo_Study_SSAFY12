package study20250501;

import java.io.*;
import java.util.*;

public class Main_2406_안정적인네트워크 {
    static int n, m;
    static int[] parent;
    static int[][] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        Arrays.fill(parent, -1);
        cost = new int[n + 1][n + 1];

        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> edges = new ArrayList<>();
        // 1번 컴퓨터는 MST에 포함시키지 않음
        // 후보 간선들 추가
        for (int i = 2; i <= n; i++) {
            for (int j = i+1; j <= n; j++) { // 중복 간선 방지 i+1
                edges.add(new int[]{i, j, cost[i][j]});
            }
        }

        //크루스칼 알고리즘을 위한 정렬
        edges.sort(Comparator.comparingInt(e -> e[2]));

        int totalCost = 0; // 연결한 총 비용
        List<int[]> added = new ArrayList<>(); // 연결한 간선들

        for(int[] e : edges) {
            // 이미 연결된 노드들은 건너뜀
            if(find(e[0]) != find(e[1]) && union(e[0], e[1])) {
                totalCost += e[2];
                added.add(e);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalCost).append(' ').append(added.size()).append('\n');
        for(int[] e : added) {
            sb.append(e[0]).append(' ').append(e[1]).append('\n');
        }

        System.out.println(sb.toString());
    }

    static int find(int x) {
        if (parent[x] < 0)
            return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        if (parent[rootA] > parent[rootB]) {
            int t = rootA;
            rootA = rootB;
            rootB = t;
        }

        parent[rootA] += parent[rootB];
        parent[rootB] = rootA;
        return true;
    }
}