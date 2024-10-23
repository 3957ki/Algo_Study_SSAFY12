package src.algo1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_3_11067 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N;
    static int[][] cafes;
    static Map<Integer, List<Integer>> cafeMap;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            cafeMap = new HashMap<>();

            cafes = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                cafes[i][0] = Integer.parseInt(st.nextToken());
                cafes[i][1] = Integer.parseInt(st.nextToken());
                if (!cafeMap.containsKey(cafes[i][0])) {
                    List<Integer> li = new ArrayList<>();
                    li.add(cafes[i][0]);
                    cafeMap.put(cafes[i][0], li);
                } else {
                    cafeMap.get(cafes[i][0]).add(cafes[i][1]);
                }
            }

            Arrays.sort(cafes, (c1, c2) -> (
                    c1[0] - c2[0]
                    ));

            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(cafes[i]));
            }
        }
    }

}
