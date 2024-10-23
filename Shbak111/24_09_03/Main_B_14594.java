import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_B_14594 {
    static int N;
    static int M;
    static int[] parents;

    static void make() {
        parents = new int[N+1];
        for(int i = 1;i <= N;i++){
            parents[i] = -1;
        }
    }

    static int find(int a) {
        if(parents[a] < 0) return a;

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootB == rootA) return false;

        parents[rootB] = rootA;

        return true;
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0903\\B_14594_동방프로젝트\\b_14594.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st2.nextToken());

        make();

        for(int i = 0;i < M;i++){
            StringTokenizer st3 = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            for(int j = a + 1;j <= b;j++){
                union(a,j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 1;i <= N;i++){
            set.add(find(i));
        }
        //System.out.println(Arrays.toString(parents));
        System.out.println(set.size());
    }
}