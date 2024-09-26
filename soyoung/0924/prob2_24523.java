import java.io.*;
import java.util.StringTokenizer;

//풀이 1 - 배열 사용 (메모리, 시간 모두 효율적)
public class prob2_24523 {
    static int N, startIdx;
    static int[] arr, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i-1] != arr[i]){
                setArr(startIdx, i-1);
                startIdx = i;
            }
        }

        for(int i=N-1; i>=0; i--){
            if(ans[i]==0)
                ans[i] = -1;
            else break;
        }

        for(int a : ans)
            bw.write(a+" ");
        bw.close();
    }
    static void setArr(int startIdx, int endIdx){
        for(int i=startIdx; i<=endIdx; i++){
            ans[i] = endIdx+2;
        }
    }
}

//풀이 2 - 배열 사용 x
//public class prob2_24523 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int prevIdx = 1;
//        int now = Integer.parseInt(st.nextToken());
//        for (int i = 2; i <= N; i++) {
//            int next = Integer.parseInt(st.nextToken());
//            if (now != next) {
//                while (prevIdx < i) {
//                    bw.write(i + " ");
//                    prevIdx++;
//                }
//                now = next;
//            }
//        }
//        while (prevIdx <= N) {
//            bw.write(-1+" ");
//            prevIdx++;
//        }
//        bw.close();
//    }
//}



