import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가로세로퍼즐 {
	
	static String input[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new String[6];
		for(int i = 0; i < 6; i++) {
			input[i] = br.readLine().trim();
		}
		char map[][] = new char[3][];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if( i == j ) continue;
				for(int k = 0; k < 6; k++){
					if( i == k || j == k ) continue;
					
					map[0] = input[i].toCharArray();
					map[1] = input[j].toCharArray();
					map[2] = input[k].toCharArray();
					
					if(chk(map, i, j, k)) {
						for(int r = 0; r < 3; r++) {
							for(int c = 0; c < 3; c++) {
								System.out.print(map[r][c]);
							}
							System.out.println();
						}
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

	private static boolean chk(char[][] map, int q, int w, int e) {
		boolean visited[] = new boolean[6];
		visited[q] = true;
		visited[w] = true;
		visited[e] = true;
		
		for(int c = 0; c < 3; c++) {
			StringBuilder sb = new StringBuilder();
			for(int r = 0; r < 3; r++) {
				sb.append(map[r][c]);
			}
			String tmp = sb.toString();
			for(int i = 0; i < 6; i++) {
				if(visited[i]) continue;
				if(tmp.equals(input[i])) {
					visited[i] = true;
					break;
				}
			}
		}
		for(int i = 0; i < 6; i++) {
			if(visited[i]) continue;
			return false;
		}
		return true;
	}
}