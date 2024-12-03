														import java.io.BufferedReader;
														import java.io.IOException;
														import java.io.InputStreamReader;
														import java.util.ArrayList;
														import java.util.Arrays;
														import java.util.HashSet;
														import java.util.List;
														import java.util.Set;
														import java.util.StringTokenizer;
														
														public class Main_4_����� {
															static String[] input = new String[3];
															static int[] match;
															static boolean[] visited;
															static boolean[] firstStarted;
															static List<Character> chList;
														
															public static void main(String[] args) throws IOException {
																// TODO Auto-generated method stub
																BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
																StringTokenizer st;
																
																st = new StringTokenizer(br.readLine());
																
																Set<Character> set = new HashSet<>();
																for (int i=0;i<3;i++) {
																	input[i] = st.nextToken();
																	for (int j=0;j<input[i].length();j++) {
																		set.add(input[i].charAt(j));
																	}
																}
																
																firstStarted = new boolean[26];
																firstStarted[input[0].charAt(0) - 'A'] = true;
																firstStarted[input[1].charAt(0) - 'A'] = true;
																firstStarted[input[2].charAt(0) - 'A'] = true;
																
																//���ڿ��� ��� �ִ� ��� ���ڸ� ���� ����Ʈ
																chList = new ArrayList<>(set);
														//		for (int i=0;i<chList.size();i++) {
														//			System.out.print(chList.get(i)+" ");
														//		}
																
																//��Ī�Ǵ� ������ ������ 10������ ũ�� �Ұ���
																if (chList.size()>10) {
																	System.out.println("NO");
																	return;
																}
																
																match = new int[26];
																Arrays.fill(match, -1);
																visited = new boolean[10];
																
																boolean flag = dfs(0);
														//		System.out.println(Arrays.toString(match));
																
																if (flag) {
																	System.out.println("YES");
																	return;
																}
																System.out.println("NO");
																
															}
															static boolean dfs(int cnt) {
																if (cnt >= chList.size()) {
																	long a = stringToNum(input[0]);
																	long b = stringToNum(input[1]);
																	long c = stringToNum(input[2]);
																	
														//			System.out.println("a: "+a);
														//			System.out.println("b: "+b);
														//			System.out.println("c: "+c);
																	
																	if (a == -1 || b == -1 || c == -1) {
																		return false;
																	}
																	
																	if (a + b == c) {
																		return true;
																	}
																	
																	return false;
																}
																
																char cur = chList.get(cnt);
																int curIdx = cur - 'A';
																
																for (int i=0;i<10;i++) {
																	if (!visited[i]) {
																		//0�̸� ù��°�� �� �� ����
														//				if (i == 0 && firstStarted[curIdx]) continue;
																		
																		match[curIdx] = i;
																		visited[i] = true;
																		
																		if (dfs(cnt+1)) return true;
																		
																		visited[i] = false;
																		match[curIdx] = -1;
																	}
																}
																
																return false;
															}
															
															//���ڿ� --> ��Ī�� ���� ��ȯ
															static long stringToNum(String str) {
																long result = 0;
																
																for (int i=0;i<str.length();i++) {
																	result *= 10;
																	if (match[str.charAt(i)-'A'] == -1) {
																		return -1;
																	}
																	result += match[str.charAt(i)-'A'];
																}
																return result;
															}
														
														}
