package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B_1_15828_Router {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());

		Queue<Integer> queue = new ArrayDeque<>();
		int input = Integer.parseInt(br.readLine().trim());
		while (input != -1) {
			if (input == 0) {
				queue.poll();
			} else if (input != 0) {
				if (queue.size() < N)
					queue.add(input);
			}
			input = Integer.parseInt(br.readLine().trim());
		}

		if (queue.size() == 0) {
			sb.append("empty");
		} else {
			while (!queue.isEmpty())
				sb.append(queue.poll()).append(" ");
		}

		System.out.println(sb);
	}
}
