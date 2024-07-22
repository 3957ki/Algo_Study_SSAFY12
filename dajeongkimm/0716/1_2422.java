import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static int answer;
    static int N;
    static HashMap<Integer, ArrayList<Integer>> map;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N+1][N+1];

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        answer = 0;

        for (int i=1;i<=N-2;i++){
            for (int j=i+1;j<=N-1;j++){
                if (arr[i][j]) continue;
                for (int k=j+1;k<=N;k++){
                    if (!arr[i][k] && !arr[j][k]) answer++;
                }
            }
        }
        System.out.println(answer);



    }
    private static void IceCream(ArrayList<Integer> cur, int idx, boolean[] not){
        if (cur.size() == 3) {
            answer++;
//            for (int i=0;i<3;i++){
//                System.out.printf(cur.get(i)+" ");
//            }
//            System.out.println();
            return;
        }
        for (int i = idx+1; i<=N;i++){
            if (not[i]) {
                ArrayList<Integer> curCopy = new ArrayList<>(cur);
                boolean[] notCopy = not.clone();
                curCopy.add(i);
                if (map.containsKey(i) ){
                    ArrayList<Integer> tmp = map.get(i);
                    for (int j=0;j<tmp.size();j++){
                        notCopy[tmp.get(j)] = false;
                    }
                }
                IceCream(curCopy, i, notCopy);
            }
        }
    }
}