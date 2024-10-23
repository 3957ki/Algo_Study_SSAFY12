package study1015;

import java.io.*;
import java.util.*;

public class b2_129333_오리 {
	static char[] duck = { 'q', 'u', 'a', 'c', 'k' };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		if (arr.length % 5 != 0 || arr[0] != 'q' || arr[arr.length - 1] != 'k') {
			System.out.println(-1);
			return;
		}
		boolean[] visited = new boolean[arr.length];
		int cur = 0;
		int cnt = 0;
		while (true) {
			boolean flag = false;
			for(int i=0;i<arr.length;i++) {
				if(arr[i] == duck[cur] && !visited[i]) {
					visited[i] = true;
					if(cur==4) {
						flag = true;
					}
					cur = (cur+1)%5;
				}
			}
			if(flag) {
				cnt++;
			}else {
				break;
			}
		}
		for (boolean v : visited) {
            if (!v) {
                System.out.println(-1);
                return;
            }
        }
		System.out.println(cnt > 0 ? cnt : -1);

	}

}
