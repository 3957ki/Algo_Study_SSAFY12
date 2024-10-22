import java.io.*;
import java.util.*;
/*
R 값이 중요한가?
앞의 사람이 못 들었는데 뒷 사람이 들었다 -> 모순?
앞 사람이 k번 들었는데 뒤에서 k+1번 들었다 -> 모순
각 사람이 몇 번 들었는지 저장도 해야한다
 */
public class p18248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] peopleHeard = new int[n][m+1];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<m;j++){
                peopleHeard[i][j] = Integer.parseInt(st.nextToken());
                if(peopleHeard[i][j] == 1) peopleHeard[i][m]++; // i번째 사람이 j번째 종 들었으면 횟수 담아두기
            }
        }
        //앞 사람이 k번 들었는데 뒤에서 k+1번 들었다 -> 모순 -> peopleHeard[m] 순으로 정렬
        Arrays.sort(peopleHeard,(o1, o2) -> {return o2[m]-o1[m];});

        //되는지 안되는지
        boolean flag = true;

        loop:for(int i=0;i<m;i++){
            int prev = peopleHeard[0][i]; // -> 시간지나면서 갱신
            //모든 사람들에 대해
            for(int j=0;j<n;j++){
                if(prev < peopleHeard[j][i]){ // 이전값보다 더 크다 -> 더 큰값이 나왔다? 모순
                    flag = false;
                    break loop;
                }
                prev = peopleHeard[j][i]; // 조건 만족했으므로 이전값 갱신
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}