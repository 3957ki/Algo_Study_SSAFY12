package algo0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14594_동방프로젝트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M; // 동아리 방의 개수, 빌런의 행동 횟수
    static Integer[][] behave;
    static int[] rooms;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        rooms = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            rooms[i] = i;
        }
        behave = new Integer[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            behave[i] = new Integer[] {x, y};
        }
        Arrays.sort(behave, (o1, o2) -> o1[0] - o2[0]);

        for (Integer[] b : behave) {
            for (int i = b[0]; i <= b[1]; i++) {
                rooms[i] = rooms[b[0]];
            }
        }

        System.out.println(Arrays.toString(rooms));
        Set<Integer[]> s = new HashSet<>(rooms);

    }
}
