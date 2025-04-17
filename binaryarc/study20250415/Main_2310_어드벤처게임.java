package study20250415;

import java.io.*;
import java.util.*;

public class Main_2310_어드벤처게임 {
	static class Room {
		int gold;
		List<Integer> canMoveList;
		char type;

		public Room(int gold, ArrayList<Integer> list, char type) {
			this.gold = gold;
			this.canMoveList = list;
			this.type = type;
		}
	}

	static int n;
	static List<Room> rooms;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int idx = 1;
		while (n != 0) {
			rooms = new ArrayList<>();
			rooms.add(null);
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				char type = st.nextToken().charAt(0);
				int gold = Integer.parseInt(st.nextToken());
				ArrayList<Integer> moveList = new ArrayList<>();

				while (true) {
					int next = Integer.parseInt(st.nextToken());
					if (next == 0)
						break;
					moveList.add(next);
				}

				rooms.add(new Room(gold, moveList, type));
			}
			if (isValid()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			n = Integer.parseInt(br.readLine());
		}
	}

	static boolean isValid() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n + 1][501];
		Room firstRoom = rooms.get(1);
		int initGold = 0;

		// 현재 금액과 다음 갈 곳
		if (firstRoom.type == 'T') {
			if (firstRoom.gold > initGold)
				return false;
			q.add(new int[] { initGold, 1 });
			visited[1][initGold] = true;
		} else if (firstRoom.type == 'L') {
			int gold = firstRoom.gold;
			for (Integer nextRoom : rooms.get(1).canMoveList) {
				q.add(new int[] { gold, nextRoom });
				visited[nextRoom][gold] = true;
			}
		} else {
			q.add(new int[] { 0, 1 });
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curGold = cur[0];
			int curRoomNum = cur[1];
			if (curRoomNum == n)
				return true;

			List<Integer> nextRooms = rooms.get(curRoomNum).canMoveList;
			for (Integer nextRoom : nextRooms) {
				int nextGold = rooms.get(nextRoom).gold;
				if (rooms.get(nextRoom).type == 'T') {
					if (nextGold > curGold)
						continue;
					nextGold = curGold - nextGold;
				} else if (rooms.get(nextRoom).type == 'L') {
					nextGold = Math.max(curGold, nextGold);
				} else {
					nextGold = curGold;
				}
				if (!visited[nextRoom][nextGold]) {
					q.add(new int[] { nextGold, nextRoom });
					visited[nextRoom][nextGold] = true;
				}
			}
		}
		return false;
	}
}
