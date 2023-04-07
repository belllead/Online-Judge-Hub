import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, water;
	static int[][] pool;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static final int INF = Integer.MAX_VALUE;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pool = new int[N+2][M+2];
		
		Arrays.fill(pool[0], -1);
		Arrays.fill(pool[N+1], -1);
		for (int r=0; r<=N+1; r++) {
			pool[r][0] = -1;
			pool[r][M+1] = -1;
		}
		
		for (int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=1; c<=M; c++) {
				pool[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int[] i : pool)
//			System.out.println(Arrays.toString(i));
		
		visited = new boolean[N+2][M+2];
		
		while (true) {
			int test = water;
			
			// 가장자리는 검사할 필요 없음
			for (int r=2; r<=N-1; r++) {
				for (int c=2; c<=M-1; c++) {
					water += bfs(r, c);
//					System.out.println(r + " " + c);
//					System.out.println("bfs: " +bfs(r, c));
				}
			}
			
			// 한바퀴 돌아도 물 양이 변하지 않으면 루프 종료
			if (test == water) break;
		}
			
//		for (boolean[] b : visited)
//			System.out.println(Arrays.toString(b));
//		
//		for (int[] i : pool)
//			System.out.println(Arrays.toString(i));
		
		System.out.println(water);
		
	}
	
	private static int bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {row, col});
		visited[row][col] = true;

		int currH = pool[row][col];
		int minH = INF;
		int sameHeight = 1;
		
		List<int[]> fill = new ArrayList<>();
		fill.add(new int[] {row, col});
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = curr[0] + dr[i];
				int tc = curr[1] + dc[i];
				
				if (tr >= 0 && tr <= N+1 && tc >= 0 && tc <= M+1) {
					// 높이가 나보다 크면 벽 높이 후보로 저장
					if (pool[tr][tc] > pool[curr[0]][curr[1]])
						minH = Math.min(minH, pool[tr][tc]);
					
					// 4방향 중 나보다 낮은 게 있다면 검사 중단
					if (pool[tr][tc] < pool[curr[0]][curr[1]]) {
						for (int[] f : fill) {
							visited[f[0]][f[1]] = false;
						}
						return 0;
					}
					
					// 4방향 중 나와 같은 높이가 있다면
					// 위치를 방문체크하고 넘어가서 추가 검사
					if (pool[tr][tc] == pool[curr[0]][curr[1]] && !visited[tr][tc]) {
						int[] t = new int[] {tr, tc};
						q.offer(t);
						visited[tr][tc] = true;
						fill.add(t);
						sameHeight++;
					}
				}
			}
//			for (int[] i : q)
//				System.out.println(Arrays.toString(i));
//			System.out.println(minH);
		}

		// 여기까지 진행되면 모든방향이 다 나보다 큰 것이므로
		// 이제껏 인접한 곳 중 가장 낮은 곳과의 차이만큼 채우기
		// 이때 방문 체크된 수만큼 곱하기
		// 처리 후 처리된 위치에 물로 채워올리기
		int hDiff = minH - currH;

		for (int[] i : fill) {
			pool[i[0]][i[1]] += hDiff;
			visited[i[0]][i[1]] = false;
		}
		
		return hDiff * sameHeight;
	}
}