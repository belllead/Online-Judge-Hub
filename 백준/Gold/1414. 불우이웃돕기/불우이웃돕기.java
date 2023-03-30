import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	static char[] length = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] com = new int[N][N];
		int lan = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < s.length(); j++) {

				for (int k = 0; k < length.length; k++) {
					if (s.charAt(j) == length[k]) {
						com[i][j] = k + 1;
						lan += com[i][j];
					}
				}
			}
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (com[r][c] == 0)
					com[r][c] = com[c][r];
				else if (com[c][r] != 0) 
					com[r][c] = Math.min(com[r][c], com[c][r]);
			}
		}

//		System.out.println(lan);
//		for (int[] i : com)
//			System.out.println(Arrays.toString(i));
		
		// 프림 알고리즘
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});
		boolean[] visited = new boolean[N];

		for (int i = 1; i < N; i++) {
			if (com[0][i] != 0)
				pq.offer(new int[] { i, com[0][i] });
		}

		int homeLan = 0;
		int pick = 1;
		visited[0] = true;

//		for (int[] i : pq)
//			System.out.println(Arrays.toString(i));

		while (pick != N) {
			try {
				int[] curr = pq.poll();
	
				if (visited[curr[0]])
					continue;
	
				visited[curr[0]] = true;
				homeLan += curr[1];
				pick++;
	
				for (int i = 0; i < N; i++) {
					if (com[curr[0]][i] != 0)
						pq.offer(new int[] { i, com[curr[0]][i] });
				}
			} catch (Exception e) {
				pick = -1;
				break;
			}
		}

		int ans = 0;
		if (pick == -1) ans = -1;
		else ans = lan - homeLan;
		System.out.println(ans);
	}
}