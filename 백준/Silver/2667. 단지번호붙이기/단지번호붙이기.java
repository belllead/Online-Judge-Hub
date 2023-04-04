import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] apart;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		apart = new int[N][N];
		visited = new boolean[N][N];
		
		for (int r=0; r<N; r++) {
			String[] sArr = br.readLine().split("");
			for (int c=0; c<N; c++) {
				apart[r][c] = Integer.parseInt(sArr[c]);
			}
		}
		
		List<Integer> cnt = new ArrayList<>();
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (apart[r][c] == 1 && !visited[r][c])
					cnt.add(bfs(r, c));
			}
		} 
		
		System.out.println(cnt.size());
		if (cnt.size() != 0) {
			Collections.sort(cnt);
			for (int c : cnt)
				System.out.println(c);
		}
	}
	
	static int bfs(int r, int c) {
		int cnt = 0;
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			cnt++;
			
			for (int i=0; i<4; i++) {
				int tr = curr[0] + dr[i];
				int tc = curr[1] + dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < N 
						&& !visited[tr][tc] && apart[tr][tc] == 1) {
					q.offer(new int[] {tr, tc});
					visited[tr][tc] = true;
				}
			}
			
			
		}
		
		return cnt;
	}
}