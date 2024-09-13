import java.io.*;
import java.util.*;

public class boj_2232 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] bool = new boolean[N];


        for(int i=0; i<N; i++){
            if(N==1){
                bool[0] = true;
                break;
            }
            if(i==0){
                if(arr[0]>=arr[1]) bool[0] = true;
            }else if(i==N-1){
                if(arr[N-1]>=arr[N-2]) bool[N-1] = true;
            }else{
                //양쪽이 자기보다 작다면 터져야 함
                if(arr[i]>=arr[i-1] && arr[i]>=arr[i+1])
                    bool[i] = true;
            }
        }
        //터진 숫자를 출력
        for(int i=0; i<N; i++){
            if(bool[i]) System.out.println(i+1);
        }
    }

}