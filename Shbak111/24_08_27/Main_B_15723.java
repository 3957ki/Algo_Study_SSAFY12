import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 첫째 줄에 정수 n(2 ≤ n ≤ 26)이 주어진다.
 * 둘째 줄부터 n개의 줄에 걸쳐 각 줄에 전제가 하나씩 주어진다.
 * 모두 a is b의 형식으로 주어지며 a와 b는 서로 다른 임의의 알파벳 소문자
 *
 * 링크드 리스트 형식으로 가볼까?
 *
 */

public class Main_B_15723 {
    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0827\\B_15723_n단논법\\b_15723.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        for(int i = 0;i < N;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            char p1 = st2.nextToken().charAt(0);
            st2.nextToken();
            char p2 = st2.nextToken().charAt(0);

            map.put(p1,p2);
        }
        StringTokenizer st3 = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st3.nextToken());
        for(int i = 0;i < M;i++){
            StringTokenizer st4 = new StringTokenizer(bf.readLine());
            char p1 = st4.nextToken().charAt(0);
            st4.nextToken();
            char p2 = st4.nextToken().charAt(0);

            while(true){
                if(!map.containsKey(p1)) {
                    sb.append("F").append("\n");
                    break;
                }
                if(map.get(p1) == p2) {
                    sb.append("T").append("\n");
                    break;
                }
                p1 = map.get(p1);
            }

        }

        System.out.println(sb);
    }
}