import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] land;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			land = new int[N][M];
			visited = new boolean[N][M];
			
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				land[r][c] = 1;
			}
			
			int cnt = 0;
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (!visited[r][c] && land[r][c] == 1) {
						bfs(r, c);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = curr[0] + dr[i];
				int tc = curr[1] + dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < M
						&& !visited[tr][tc] && land[tr][tc] == 1) {
					q.offer(new int[] {tr, tc});
					visited[tr][tc] = true;
				}
			}
		}
	}
	
}