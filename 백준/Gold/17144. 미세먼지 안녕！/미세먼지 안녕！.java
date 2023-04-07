import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, dustAmount;
	static int[][] room;
	static int[] apPos;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		room = new int[R][C];
		apPos = new int[2];

		int idx = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());

				if (room[r][c] == -1)
					apPos[idx++] = r;

				if (room[r][c] > 0)
					dustAmount += room[r][c];
			}
		}

		for (int i = 1; i <= T; i++) {
			dustDisperse();
			apOn();
//			System.out.println();
//			for (int[] ii : room)
//				System.out.println(Arrays.toString(ii));
		}

		System.out.println(dustAmount);
	}

	private static void dustDisperse() {
		int[][] tmpRoom = new int[R][C];
		for (int i = 0; i < R; i++)
			tmpRoom[i] = Arrays.copyOf(room[i], C);

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {

				if (room[r][c] > 0) {
					int dispersedCnt = 0;

					for (int d = 0; d < 4; d++) {
						int tr = r + dr[d];
						int tc = c + dc[d];

						if (tr >= 0 && tr < R && tc >= 0 && tc < C && room[tr][tc] != -1) {
							tmpRoom[tr][tc] += room[r][c] / 5;
							dispersedCnt++;
						}
					}

					tmpRoom[r][c] -= (room[r][c] / 5) * dispersedCnt;
				}
			}
		}

		for (int i = 0; i < R; i++)
			room[i] = Arrays.copyOf(tmpRoom[i], C);
	}

	private static void apOn() {
		int up = apPos[0];
		int down = apPos[1];

		// 먼지 정화
		dustAmount -= room[up - 1][0];
		dustAmount -= room[down + 1][0];

		// 위쪽 순환
		for (int row = up - 1; row > 0; row--) {
			room[row][0] = room[row - 1][0];
		}

		for (int col = 0; col < C - 1; col++) {
			room[0][col] = room[0][col + 1];
		}

		for (int row = 0; row < up; row++) {
			room[row][C - 1] = room[row + 1][C - 1];
		}

		for (int col = C - 1; col > 1; col--) {
			room[up][col] = room[up][col - 1];
		}

		// 아래쪽 순환
		for (int row = down + 1; row < R - 1; row++) {
			room[row][0] = room[row + 1][0];
		}

		for (int col = 0; col < C - 1; col++) {
			room[R - 1][col] = room[R - 1][col + 1];
		}

		for (int row = R - 1; row > down; row--) {
			room[row][C - 1] = room[row - 1][C - 1];
		}

		for (int col = C - 1; col > 1; col--) {
			room[down][col] = room[down][col - 1];
		}
		
		room[up][1] = 0;
		room[down][1] = 0;
	}
}