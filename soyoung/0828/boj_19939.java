import java.util.*;
import java.io.*;

public class boj_19939{
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(pop()+" ");
        bw.close();


    }
    static int pop(){
        int[] arr = new int[K];

        int sum = 0;
        for(int i=1; i<=K; i++){
            sum += i;
            arr[i-1] = i;
        }

        if(N < sum)
            return -1;

        N -= sum;

        int i = K-1;

        while(N!=0){
            if(i<0)
                i=K-1;
            arr[i]++;
            i--;
            N--;
        }

        return arr[K-1]-arr[0];
    }

}
