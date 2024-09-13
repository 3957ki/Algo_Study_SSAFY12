import java.io.*;
import java.util.*;

public class boj_27466 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] arr = new char[N];
        for(int i=0; i<N; i++){
            arr[i] = str.charAt(i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=N-1; i>=0; i--){
            if(sb.length()==0 && isCons(arr[i])){ //자음
                sb.append(arr[i]);
                continue;
            }
            if(sb.length()<3 && sb.length()>0 && arr[i]=='A'){ //A
                sb.append(arr[i]);
                continue;
            }
            if(sb.length()>=3 && sb.length()<M){
                sb.append(arr[i]);
                continue;
            }
            if(sb.length()>M) break;
        }

        if(sb.length()==M){
            System.out.println("YES");
            System.out.println(sb.reverse());
        }else{
            System.out.println("NO");
        }
    }
    static boolean isCons(char c){
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            return false;
        return true;
    }
}
