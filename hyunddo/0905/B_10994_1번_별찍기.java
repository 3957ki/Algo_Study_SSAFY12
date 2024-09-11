package day0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10994_1번_별찍기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int size;
		if (N == 1)
			size = 1;
		else
			size = 4 * (N - 1) + 1;
		char map[][] = new char[size][size];

		int length = size;
		int index = 0;
		while (N >= 1) {
			for (int i = index; i < length; i++) {
				map[index][i] = '*'; // 첫줄
				map[i][index] = '*'; // 왼쪽
				map[i][length-1] = '*'; // 오른쪽
				map[length-1][i] = '*'; // 마지막줄
			}
			index += 2;
			length -= 2;
			N--;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == '*')
					System.out.print(map[i][j] + "");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
