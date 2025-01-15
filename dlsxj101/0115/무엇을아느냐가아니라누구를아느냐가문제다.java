import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 무엇을아느냐가아니라누구를아느냐가문제다 {

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
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Node> adjList[] = new List[M];
            for (int i = 0; i < M; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                adjList[x].add(new Node(y, z));
                adjList[y].add(new Node(x, z));
            }

            //다익스트라 시작(0부터 출발)
            int dist[] = new int[M];
            Arrays.fill(dist, Integer.MAX_VALUE);

            //경로 역추적 할 path 리스트 생성 및 초기화
            List<Integer> path[] = new List[M];
            for (int i = 0; i < M; i++) {
                path[i] = new ArrayList<>();
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[0] = 0;
            pq.add(new Node(0, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                int nowVertex = cur.index;

                if (dist[nowVertex] < cur.cost) continue;

                for (Node next : adjList[nowVertex]) {
                    if (dist[next.index] > dist[nowVertex] + next.cost) {
                        dist[next.index] = dist[nowVertex] + next.cost;

                        //cur노드에서 다음 노드로 갈 때 dist배열이 새롭게 갱신되면 다음 노드에 저장된 경로는 필요없어지므로 clear
                        path[next.index].clear();
                        path[next.index].add(nowVertex);

                        pq.add(new Node(next.index, dist[next.index]));
                    }
                    //dist배열이 같으면 이 경로도 최단 경로에 해당되므로 path 배열에 추가
                    else if (dist[next.index] == dist[nowVertex] + next.cost) path[next.index].add(nowVertex);
                }
            }
            //로그(경로 확인용)
//            for (int i = 0; i < M; i++) {
//                System.out.print("start: " + i);
//                System.out.print(" end: ");
//                for (int j : path[i]) {
//                    System.out.print(j + " ");
//                }
//                System.out.println();
//            }
            
            if (dist[M - 1] == Integer.MAX_VALUE) sb.append("Case #").append(tc).append(": ").append(-1);
            else {
                sb.append("Case #").append(tc).append(": ");
                List<Integer> ans = new ArrayList<>();
                int tmpIndex = M - 1;
                ans.add(tmpIndex);
                while (true) {
                    if (tmpIndex == 0) break;

                    ans.add(path[tmpIndex].get(0));

                    tmpIndex = path[tmpIndex].get(0);
                }
                Collections.reverse(ans);
                for (int i : ans) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}