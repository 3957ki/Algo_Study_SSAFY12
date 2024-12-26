//이진트리
import java.io.*;
import java.util.*;
public class p2716 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<t;i++){
            String str = br.readLine().trim();
            calculate(str);
        }
        System.out.println(sb);
    }
    static void calculate(String str){
        int curDepth = 0;
        int maxDepth = 0;
        for(char c : str.toCharArray()){
            if(c == '[') curDepth++; //깊이 증가
            else curDepth--; //깊이 감소
            maxDepth = Math.max(curDepth,maxDepth);
        }
        sb.append((int) Math.pow(2,maxDepth)).append("\n");
    }
}
// [ [2,2] [[1,1],2] ]