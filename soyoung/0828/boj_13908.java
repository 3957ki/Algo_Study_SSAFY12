import java.util.*;
import java.io.*;
public class boj_13908 {
    static int N, M, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//길이
        M = Integer.parseInt(st.nextToken());//숫자수

        if(M != 0){
            arr = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> list = new ArrayList<>();
            select(list);
        }else {
            ans = 1;
            for(int i=0; i<N; i++){
                ans *= 10;
            }
        }

        bw.write(ans+" ");
        bw.close();
    }
    static void select(List<Integer> selected){

        if(selected.size() == N){
            if(isValid(selected))
                ans++;
            return;
        }
        for(int i=0; i<10; i++){
            selected.add(i);
            select(selected);
            selected.remove(selected.size()-1);
        }
    }
    static boolean isValid(List<Integer> list){
        for(int i=0; i<arr.length; i++){
            if(!list.contains(arr[i]))
                return false;
        }
        return true;
    }
}
