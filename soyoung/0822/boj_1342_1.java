import java.io.*;
import java.util.*;

public class boj_1342_1 {

    static char[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray();
        N = arr.length;

        Arrays.sort(arr);

        int ans = 0;

        A: do{
            for(int i=1; i<N; i++){
                if(arr[i-1] == arr[i]) //인접한 곳에 같은 문자 발견
                    continue A;
            }
            ans++;
        } while(np());

        bw.write(ans+" ");
        bw.close();

    }
    static boolean np(){
        //증가하는 부분 찾기 //i-1, i
        int i = N-1;
        while(i>0 && arr[i]<=arr[i-1]) i--;

        if(i==0) return false;

        //i~N-1에서 i-1보다 크지만 가장 작은 값 찾기 //뒤에서부터 찾으면 됨
        int j = N-1;
        while(arr[i-1]>=arr[j]) j--;

        //두 수를 스왑
        swap(i-1, j);

        //i~N-1을 오름차순 정렬
        int k = N-1;
        while(k>i) swap(k--, i++);

        return true;
    }
    static void swap(int x, int y){
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
