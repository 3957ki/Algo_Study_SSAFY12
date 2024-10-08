import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 특별상이라도받고싶어 {
	static int N, arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(N==1) {
			System.out.println(arr[0][0]);
			return;
		}
		int ans = cut(0, 0, N);
		
		System.out.println(ans);
	}
	static int cut(int r, int c, int n) {
		if(n==2) {
			List<Integer> list = new ArrayList<>();
			for(int i = r; i < r+n; i++) {
				for(int j = c; j < c+n; j++) {
					list.add(arr[i][j]);
				}
			}
			Collections.sort(list);
			return list.get(1);
		}
		int tmp[] = new int[4];
		tmp[0] = cut(r, c, n/2);
		tmp[1] = cut(r+n/2, c, n/2);
		tmp[2] = cut(r, c+n/2, n/2);
		tmp[3] = cut(r+n/2, c+n/2, n/2);
		
		Arrays.sort(tmp);
		return tmp[1];
	}
}
