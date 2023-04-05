import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[10][10];
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int r = 0; r < 10; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 10; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void dfs(int cnt) {
		int sR = -1;
		int sC = -1;

		outer: for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map[r][c] == 1) {
					sR = r;
					sC = c;
					break outer;
				}
			}
		}
		if (sR == -1 || sC == -1) {
			min = Math.min(min, cnt);
			return;
		}

		int sizeMax = 5;
		while (sizeMax > 0) {
			boolean flag = true;

			outer: for (int r = 0; r < sizeMax; r++) {
				for (int c = 0; c < sizeMax; c++) {
					if (sR + r >= 10 || sC + c >= 10 || map[sR + r][sC + c] == 0) {
						flag = false;
						break outer;
					}
				}
			}

			if (flag)
				break;

			sizeMax--;
		}
		
		for (int size = 1; size <= sizeMax; size++) {
			if (paper[size] == 0)
				continue;

			paste(sR, sC, size, 0);
			paper[size]--;

			dfs(cnt + 1);

			paper[size]++;
			paste(sR, sC, size, 1);
		}
	}

	private static void paste(int sR, int sC, int size, int check) {
		for (int r = sR; r < sR + size; r++) {
			for (int c = sC; c < sC + size; c++) {
				map[r][c] = check;
			}
		}
	}
}