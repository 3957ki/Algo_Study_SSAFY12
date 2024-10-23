import java.io.*;
import java.util.*;

public class p16938 {
    static int n,l,r,x,cnt;
    static int[] map;
    static boolean[] isVisit;
    static List<Integer> output = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[n];
        isVisit = new boolean[n];

        st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        dfs(0,0, 0);
        System.out.println(cnt);
    }
    static void dfs(int idx, int depth, int sum){
        int len = output.size();

        // depth >= 2 조건을 만족하면서 난이도 합과 차이를 체크
        if(depth >= 2 && sum >= l && sum <= r &&
                (output.get(len-1) - output.get(0)) >= x){
            cnt++;
        }

        // 모든 가능한 조합 시도
        for(int i= idx;i<n;i++){
            output.add(map[i]);
            dfs(i+1, depth+1, sum + map[i]);
            output.remove(output.size()-1);
        }
    }
}