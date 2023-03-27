import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[][] chessPaper;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chessPaper = new String[N][M];
		for (int r=0; r<N; r++) {
			chessPaper[r] = br.readLine().split("");
		}
		
		int ans = 65;
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (r <= N-8 && c <= M-8)
				ans = Math.min(ans, chessBoard(r, c));
			} 
		}
		
		System.out.println(ans);
	}
	
	static int chessBoard(int startRow, int startCol) {
		String[][] board = new String[8][8];
		
		for (int r=0; r<8; r++) {
			for (int c=0; c<8; c++) {
				board[r][c] = chessPaper[startRow + r][startCol + c];
			}
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		// board[0][0] = "W"
		for (int r=0; r<8; r++) {
			for (int c=0; c<8; c++) {
				if (r % 2 == 0 && c % 2 == 1) {
					if (board[r][c].equals("W"))
						cnt1++;
				} else if (r % 2 == 1 && c % 2 == 0) {
					if (board[r][c].equals("W"))
						cnt1++;
				} else if (r % 2 == 0 && c % 2 == 0) {
					if (board[r][c].equals("B"))
						cnt1++;
				} else if (r % 2 == 1 && c % 2 == 1) {
					if (board[r][c].equals("B"))
						cnt1++;
				}
			}
		}		
		
		// board[0][0] = "B";
		for (int r=0; r<8; r++) {
			for (int c=0; c<8; c++) {
				if (r % 2 == 0 && c % 2 == 1) {
					if (board[r][c].equals("B"))
						cnt2++;
				} else if (r % 2 == 1 && c % 2 == 0) {
					if (board[r][c].equals("B"))
						cnt2++;
				} else if (r % 2 == 0 && c % 2 == 0) {
					if (board[r][c].equals("W"))
						cnt2++;
				} else if (r % 2 == 1 && c % 2 == 1) {
					if (board[r][c].equals("W"))
						cnt2++;
				}
			}
		}
		
		return Math.min(cnt1, cnt2);
		
	}
}