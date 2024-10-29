//dp? 부분집합?
import java.io.*;
import java.util.*;
public class p21735 {
    static int n,m;
    static int[] map = new int[101];
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken()); //앞마당 길이(배열길이)
        m = Integer.parseInt(st.nextToken()); //시간

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,1,0);
        System.out.println(res);
    }
    static void dfs(int time, int size, int curPos){
        if(time == m || curPos >= n){ // 기저, 시간경과 혹은 끝까지 도달
            res = Math.max(size, res);
            return;
        }
        //눈 불리기
        for(int i=1;i<3;i++){ //1아니면 2
            //굴리면?
            if(i == 1){
                dfs(time+1, size+map[curPos+1], curPos+1);
            }else{//던지면?
                dfs(time+1, (size/2)+map[curPos+i], curPos+i);
            }
        }
    }
}
