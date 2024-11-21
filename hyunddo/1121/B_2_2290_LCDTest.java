package day1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_2_2290_LCDTest {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		int row = 2 * s + 3; // 세로
		int column = s + 2; // 가로
		int middle = row / 2;
		List<char[][]> list = new ArrayList<>();

		// 가로
		char width[] = new char[column];
		for (int w = 0; w < column; w++) {
			if (w == 0 || w == column - 1)
				width[w] = ' ';
			else
				width[w] = '-';
		}

		// 양쪽
		char heightAll[] = new char[column];
		for (int w = 0; w < column; w++) {
			if (w == 0 || w == column - 1)
				heightAll[w] = '|';
			else
				heightAll[w] = ' ';
		}

		// 왼쪽
		char heightLeft[] = new char[column];
		for (int w = 0; w < column; w++) {
			if (w == 0)
				heightLeft[w] = '|';
			else
				heightLeft[w] = ' ';
		}

		// 오른쪽
		char heightRight[] = new char[column];
		for (int w = 0; w < column; w++) {
			if (w == column - 1)
				heightRight[w] = '|';
			else
				heightRight[w] = ' ';
		}

//		System.out.println(Arrays.toString(width));
//		System.out.println(Arrays.toString(heightLeft));
//		System.out.println(Arrays.toString(heightRight));
		// 1
		char num1[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (!(h == 0 || h == row - 1 || h == row / 2))
				num1[h] = heightRight;
			else
				Arrays.fill(num1[h], ' ');
		}
		// 2
		char num2[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1 || h == row / 2)
				num2[h] = width;
			else if (h > 0 && h < middle)
				num2[h] = heightRight;
			else
				num2[h] = heightLeft;
		}
		// 3
		char num3[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1 || h == row / 2)
				num3[h] = width;
			else
				num3[h] = heightRight;
		}
		// 4
		char num4[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1)
				Arrays.fill(num4[h], ' ');
			else if (h > middle && h < row)
				num4[h] = heightRight;
			else if (h == middle)
				num4[h] = width;
			else
				num4[h] = heightAll;
		}
		// 5
		char num5[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1 || h == row / 2)
				num5[h] = width;
			else if (h > 0 && h < middle)
				num5[h] = heightLeft;
			else
				num5[h] = heightRight;
		}
		// 6
		char num6[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1 || h == row / 2)
				num6[h] = width;
			else if (h > 0 && h < middle)
				num6[h] = heightLeft;
			else
				num6[h] = heightAll;
		}
		// 7
		char num7[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0)
				num7[h] = width;
			else if ((h > 0 && h < middle) || (h > middle && h < row - 1))
				num7[h] = heightRight;
			else
				Arrays.fill(num7[h], ' ');
		}
		// 8
		char num8[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1 || h == row / 2)
				num8[h] = width;
			else
				num8[h] = heightAll;
		}
		// 9
		char num9[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1 || h == row / 2)
				num9[h] = width;
			else if (h > 0 && h < middle)
				num9[h] = heightAll;
			else
				num9[h] = heightRight;
		}
		// 10
		char num10[][] = new char[row][column];
		for (int h = 0; h < row; h++) {
			if (h == 0 || h == row - 1)
				num10[h] = width;
			else if (h == middle)
				Arrays.fill(num10[h], ' ');
			else
				num10[h] = heightAll;
		}
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < column; j++) {
//				System.out.print((num10[i][j]) + " ");
//			}
//			System.out.println();
//		}

		list.add(num10);
		list.add(num1);
		list.add(num2);
		list.add(num3);
		list.add(num4);
		list.add(num5);
		list.add(num6);
		list.add(num7);
		list.add(num8);
		list.add(num9);

		for (int i = 0; i < row; i++) {
			for (int tmp = 0; tmp < n.length(); tmp++) {
				char ch = n.charAt(tmp);
				for (int j = 0; j < column; j++) {
					sb.append(list.get(ch-'0')[i][j]);
				}
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
