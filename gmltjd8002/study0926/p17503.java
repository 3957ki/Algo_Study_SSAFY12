import java.io.*;
import java.util.*;

public class p17503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 기간
        int m = Integer.parseInt(st.nextToken()); // 선호도 합
        int k = Integer.parseInt(st.nextToken()); // 맥주 수
        Beers[] beers = new Beers[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            beers[i] = new Beers(like, level);
        }
        Arrays.sort(beers);
        
        int left = beers[0].level; // 젤낮은도수(기존엔 1)
        int right = beers[k-1].level; // 젤높은도수(기존엔 Integer.maxValue)
        int res = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDrink(beers, n, m, mid)) {
                res = mid;
                right = mid - 1; // 도수를 더 낮게 탐색
            } else {
                left = mid + 1; // 도수를 더 높게 탐색
            }
        }
        
        System.out.println(res);
    }

    static boolean canDrink(Beers[] beers, int n, int m, int maxLevel) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int count = 0;
        for (Beers beer : beers) {
            if (beer.level > maxLevel) continue; // 최대 도수를 넘으면 스킵
            pq.offer(beer.like);
            sum += beer.like;
            count++;
            if (count > n) {
                sum -= pq.poll(); // 선호도가 가장 높은 맥주 제거
                count--;
            }
            if (count == n && sum >= m) {
                return true; // n일 동안 마시고, 선호도 합이 m 이상이면 가능
            }
        }
        return false;
    }

    static class Beers implements Comparable<Beers> {
        int like;
        int level;

        public Beers(int like, int level) {
            this.like = like;
            this.level = level;
        }

        @Override
        public int compareTo(Beers o) {
            return this.level - o.level;
        }
    }
}