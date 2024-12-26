/*
인접리스트 생각중
1.a와 b 입력 받기
2.배열 순회하기
   2-1. b값이 없다 -> 바로 -1 출력 후 리턴
   2-2. b값이 있다
      2-2-1. b값이 있는 경우 a값 저장
      2-2-2. 위의 a값이 새로운 b값이 되는 경우가 있는지 확인
      2-2-3. 이거 반복하면서 값 갱신
3. res 출력
---------------------------------------------------
다익스트라..
인접리스트(입력 부분에 치환 가능) + 양의 가중치 + 최소
 */
import java.io.*;
import java.util.*;
public class p14496 {
    static int[][] map;
    static int[] minVals;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //배열 초기화
        map = new int[n+1][n+1];
        minVals = new int[n+1];

        //초기값에 맥스 할당해놓기
        for(int i=0;i<=n;i++){
            minVals[i]=Integer.MAX_VALUE;
        }

        //갈 수 있는 간선들 등록
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine().trim());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            map[left][right]=1;
            map[right][left]=1;
        }
        int res = dijkstra(a,b); // a에서 b까지 가는 최소거리를 다익으로 구함
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
    static int dijkstra(int init,int fin){
        PriorityQueue<node> pq = new PriorityQueue<>();

        //시작지점
        minVals[init] = 0;
        pq.offer(new node(init,0));
        while(!pq.isEmpty()){
            node tmp = pq.poll();

            //이미 최소치를 넘어버린경우 진행하지 않는다
            if(tmp.cost > minVals[tmp.vertex]) continue;

            for(int next = 1;next<=n;next++){
                //해당 간선으로 진행할 수 있다면
                if(map[tmp.vertex][next]==1){
                    //기존의 최소치가 현재 값보다 크다면(갱신이 가능하다면)
                    if(minVals[next]>tmp.cost+1){
                        //갱신
                        minVals[next]=tmp.cost+1;
                        //새로 오퍼
                        pq.offer(new node(next,minVals[next]));
                    }
                }
            }
        }
        return minVals[fin];
    }
    static class node implements Comparable<node>{
        int vertex;
        int cost;
        node(int vertex,int cost){
            this.vertex=vertex;
            this.cost=cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost-o.cost;
        }
    }
}
