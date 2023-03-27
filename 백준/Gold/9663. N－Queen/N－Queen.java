import java.util.Scanner;

public class Main {
	static int N, sum;
	static byte[][] chess;	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new byte[N][N];
		
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<N; c++) {
//				System.out.print(chess[r][c]);
//			}
//			System.out.println();
//		}
		
		placeQueen(0);
		System.out.println(sum);
		sc.close();
	}
	
	static void placeQueen(int col) {
		if (col == N) {
			sum++;
			return;
		}
			
		for (int r=0; r<N; r++) {
			if (isSafe(r, col)) {
				chess[r][col] = 1;
								
				placeQueen(col+1);
				
//				for (int rr=0; rr<N; rr++) {
//					for (int c=0; c<N; c++) {
//						System.out.print(chess[rr][c]);
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				chess[r][col] = 0;
			}
			
		}
	}
	
	static boolean isSafe(int row, int col) {
		// 가로 검사
		for (int c=0; c<col; c++) {
			if (chess[row][c] == 1) {
				return false;
			}
		}
		
		// 대각선 검사
		for (int r=0; r<N; r++) {
			for (int c=0; c<col; c++) {
				if (Math.abs(r - row) == Math.abs(c - col)) {
					if (chess[r][c] == 1)
						return false;
				}
			}
		}
		return true;
	}
	
}