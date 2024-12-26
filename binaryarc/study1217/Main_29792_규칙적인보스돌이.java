package study1217;

import java.util.*;
import java.io.*;

public class Main_29792_규칙적인보스돌이 {
	static int N, M, K;
	static List<Long> stat;
	static List<long[]> boss;
	static long ans;
	static long maxMoney;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stat = new ArrayList<>();
		for (int i = 0; i < N; i++)
			stat.add(Long.parseLong(br.readLine()));

		boss = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			long hp = Long.parseLong(st.nextToken());
			long money = Long.parseLong(st.nextToken());
			boss.add(new long[] { hp, money });
		}
		List<Long> moneyList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			maxMoney = Long.MIN_VALUE;
			getMaxMoney(0, i, 0, stat.get(i) * (15 * 60));
			moneyList.add(maxMoney);
		}
		Collections.sort(moneyList, Collections.reverseOrder());

		ans = 0;
		for (int i = 0; i < M; i++) {
			ans += moneyList.get(i);
		}
		System.out.println(ans);

	}

	public static void getMaxMoney(int cnt, int idx, long money, long curD) {
		if (cnt == K) {
			maxMoney = Math.max(maxMoney, money);
			return;
		}

		if (curD >= boss.get(cnt)[0]) {
			getMaxMoney(cnt + 1, idx, money + boss.get(cnt)[1],
					(curD - boss.get(cnt)[0]) / stat.get(idx) * stat.get(idx));
		}

		getMaxMoney(cnt + 1, idx, money, curD);

	}

}
