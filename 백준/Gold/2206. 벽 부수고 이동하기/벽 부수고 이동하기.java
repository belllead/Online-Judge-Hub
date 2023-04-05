import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		List<int[]> wall = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			char[] temp = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = temp[c] - '0';
				if (map[r][c] == 1)
					wall.add(new int[] { r, c });
			}
		}

		// 입력 완료
		
		int min = bfs();
		min = min == Integer.MAX_VALUE ? -1 : min;
		System.out.println(min);		
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][2];

		q.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		int distance = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			distance++;
			while (size-- > 0) {
				int[] curr = q.poll();

				if (curr[0] == N - 1 && curr[1] == M - 1)
					return distance;

				for (int i = 0; i < 4; i++) {
					int tr = curr[0] + dr[i];
					int tc = curr[1] + dc[i];
					int wallBreak = curr[2];

					if (tr >= 0 && tr < N && tc >= 0 && tc < M) {
						// 벽이 아닌 경우
						if (map[tr][tc] == 0 && !visited[tr][tc][wallBreak]) {
							q.offer(new int[] { tr, tc, wallBreak });
							visited[tr][tc][wallBreak] = true;
						}

						// 벽인 경우
						if (map[tr][tc] == 1 && !visited[tr][tc][wallBreak] && wallBreak == 0) {
							q.offer(new int[] { tr, tc, wallBreak + 1 });
							visited[tr][tc][wallBreak + 1] = true;
							wallBreak++;
						}
					}
				}
			}
		}

		return Integer.MAX_VALUE;
	}
}